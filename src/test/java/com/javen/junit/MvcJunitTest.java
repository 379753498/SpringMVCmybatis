package com.javen.junit;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences.PRINT_SCALING;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;  

import com.javen.Config.RootConfig;
import com.javen.Config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="SpringMVCmybatis/src/main/webapp")

@ContextConfiguration(classes={WebConfig.class,RootConfig.class})
@Transactional 
public class MvcJunitTest {

	private MockMvc mockMvc;
	
	@Autowired	
	WebApplicationContext wac;
	

	 @Before
	    public void setUp() throws Exception {
	        this.mockMvc = MockMvcBuilders.standaloneSetup(wac).build();
	    }
	 
	 
	 @Test
	 public void testone() throws Exception
	 {
		 mockMvc.perform(get("/demo/user/{id}",3)).andExpect(status().isOk()).andDo(print()); 
	 }
}
