package com.devtest.ControllerMock;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

public class Junit4Runner extends SpringJUnit4ClassRunner {



    public Junit4Runner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
