package com.devtest.ControllerMock;

import com.devtest.Controller.person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//在1.4之前的版本中使用@SpringApplicationConfiguration来指定 Spring 配置文件或者配置类的位置，
// 在1.4版本中@SpringApplicationConfiguration已被标记为废弃，在1.5版本中已删除，并使用@SpringBootTest代替
@SpringBootTest(classes = MockConfig.class)
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
    public void test() throws Exception {
        this.mockMvc.perform(get("/hello/print/")).andExpect(status().isOk()).andDo(print());

        System.out.println(person);

    }

}
