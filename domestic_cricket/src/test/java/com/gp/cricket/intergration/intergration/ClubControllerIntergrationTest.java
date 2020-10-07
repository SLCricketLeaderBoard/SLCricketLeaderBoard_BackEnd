package com.gp.cricket.intergration.intergration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.cricket.controller.ClubController;
import com.gp.cricket.entity.Club;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClubController.class)
class ClubControllerIntergrationTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

//  @Test
//  void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
//
//	Club input = new Club();
//	input.setClubId(-1);
//	
//    String body = objectMapper.writeValueAsString(input);
//
//    mvc.perform(post("/validateBody")
//            .contentType("application/json")
//            .content(body))
//            .andExpect(status().isBadRequest());
//  }
}
