package com.devtest.testserver;

import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.junit.Assert.assertEquals;

/**
 * Testng方式进行测试
 */
@Test
@ContextConfiguration(classes = Config.class)
public class TestngApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private CalculationServiceimp foo;

    @Test()
    public void testPlusCount() throws Exception {
        System.out.println("aaaaaa");

        assertEquals(foo.getCount(), 0);

        foo.plusCount();
        assertEquals(foo.getCount(), 1);
    }



}

