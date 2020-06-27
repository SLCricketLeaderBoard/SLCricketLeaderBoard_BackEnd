package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtInMemoryUserDetailsService jwtUser;

	public User userRegister(User user) {

		return null;
	}

	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}

	public Boolean isEmailHas(String email) {
		User user = userRepository.findUserByEmail(email);
		if (user != null && email.equals(user.getEmail())) {
			return true;
		}
		return false;
	}

	public Boolean isUserNameHas(String userName) {
		User user = userRepository.findUserByUserName(userName);
		if (user != null && userName.equals(user.getUserName())) {
			return true;
		}
		return false;
	}

	public Boolean isNicHas(String nic) {
		User user = userRepository.findUserByNic(nic);
		if (user != null && nic.equals(user.getNic())) {
			return true;
		}
		return false;
	}

	public User getUserByUserId(String userId) {
		Integer x = Integer.parseInt(userId);
		return this.userRepository.findById(x).get();
	}

	public User signupUser(User user) {

		if (!(isEmailHas(user.getEmail()) || isNicHas(user.getNic()))) {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setStatus((byte) 0);

			user = this.userRepository.save(user);
			jwtUser.addNewUserInMemory(user);
			return user;
		}
		return null;
	}

	public User registerUser(User user) {

		if (!(isEmailHas(user.getEmail()) || isNicHas(user.getNic()))) {

			// password encryption object
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			// update password encrypted
			user.setPassword(encoder.encode(user.getPassword()));

			// set user status to 1
			Byte x = 1;
			user.setStatus(x);

			// save user on the database
			user = this.userRepository.save(user);

			// add user in the in memory
			jwtUser.addNewUserInMemory(user);

			return user;
		}
		return null;
	}

	public User resetPassword(User user) {

		// remove the users in current jwt memory
		User userTemp = this.getUser(user.getEmail());

		// jwtUser.removeNewUserInMemory(userTemp);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// encrypt the password here
		user.setPassword(encoder.encode(user.getPassword()));

		// set User status to 1
		Byte x = 1;
		user.setStatus(x);

		// Update the record
		user = this.userRepository.save(user);
		jwtUser.updateUserInMemory(userTemp, user);
		return user;
	}

	public User updateUserProfile(User user) {
		return this.userRepository.save(user);

	}

	public Integer updateUser(User updateUser) {
		User anotherUserExist = userRepository.findByNicAndEmail(updateUser.getNic(), updateUser.getEmail(),
				updateUser.getUserId());

		if (anotherUserExist == null) {// User update data(NIC/Email) is unique)

			// 1. Check whether password change or not
			User previousUser = userRepository.findByUserId(updateUser.getUserId());
			String pwd1 = previousUser.getPassword();
			String pwd2 = updateUser.getPassword();
			Boolean isPasswordChanged = false;

			if (!pwd1.equals(pwd2)) {// If password changed
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String encryptedUpdatedPassword = encoder.encode(pwd2);
				updateUser.setPassword(encryptedUpdatedPassword);
				isPasswordChanged = true;
			}

			// 2. check whether email changed or not
			String email1 = previousUser.getEmail();
			String email2 = updateUser.getEmail();
			Boolean isEmailChaned = false;
			if (!email1.equals(email2)) {// If email changed
				isEmailChaned = true;
			}

			User result = userRepository.save(updateUser);

			if (result != null) {
				if ((isEmailChaned || isPasswordChanged)) {// If email or password changed then update JwtUserDetails						// List
					jwtUser.updateUserInMemory(previousUser, updateUser);
				}
				return 1;// save success
			}

		}
		return 0;// same Email or NIC has another person
	}

	public Integer userAccountDeactivate(Integer userId) {
		if (userId != null && userId > 0 && userRepository.existsById(userId)) {
			User user = userRepository.findByUserId(userId);
			user.setStatus((byte) 0);
			userRepository.save(user);
			return 1;
		}
		return null;
	}
}
