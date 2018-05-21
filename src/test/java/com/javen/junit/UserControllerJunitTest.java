package com.javen.junit;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;  
@Transactional
public class UserControllerJunitTest extends MvcJunitRunApplication {

	
	@Test
	public void UserController() throws Exception
	{
		super.mockMvc.perform(get("/demo/user/666")).andExpect(status().isOk()).andDo(print());
	}
	
	
}
