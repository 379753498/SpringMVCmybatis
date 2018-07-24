package com.devtest.testserver;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.junit.Assert.assertEquals;

/**
 * junit形式进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class JunitTestApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private CalculationServiceimp foo;

    @Test
    public void testPlusCount() throws Exception {
        System.out.println("bbbbbb");
        foo.plusCount();
        assertEquals(foo.getCount(), 2);

        foo.plusCount();
        assertEquals(foo.getCount(), 3);

    }



}

