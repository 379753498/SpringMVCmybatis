package com.devtest.ControllerMock;

import com.devtest.Controller.person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockConfig.class)
@WebAppConfiguration
public class MockJunitTest {

    public MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
     person person;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        System.err.println("mockMvc运行环境已完成可以使用super.mockMvc.perform进行 测试");

    }
    @Test
    public void test()
    {
        System.out.println(person);

    }

}
