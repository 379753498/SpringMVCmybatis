package com.devtest.ControllerMock;

import com.devtest.Controller.person;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SpringbootConfigTest {

    @Bean
    public person  getperson()
    {
        person p = new person();
        p.setAge(12);
        p.setName("379753498@qq.com");
        return p;
    }
}
