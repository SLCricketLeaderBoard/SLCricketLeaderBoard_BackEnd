package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByEmail(String email);

	public User findUserByUserName(String userName);

	public User findUserByNic(String nic);

	@Query("from User u where u.status=1")
	List<User> getActiveUsers();

	public User findByEmail(String email);

	@Query(value="SELECT * FROM user u WHERE (u.nic = :nic OR u.email = :email) AND (u.user_id NOT IN (:userId)) LIMIT 1 ",nativeQuery=true)
	public User findByNicAndEmail(@Param("nic") String updateNic, @Param("email") String updateEmail,
			@Param("userId") Integer userId);

	@Query("FROM User u WHERE u.userId = :userId")
	public User findByUserId(@Param("userId") Integer userId);
}
