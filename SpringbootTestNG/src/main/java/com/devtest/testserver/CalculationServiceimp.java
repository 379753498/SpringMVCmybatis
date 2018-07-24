package com.devtest.testserver;

import org.springframework.stereotype.Component;

@Component
public class CalculationServiceimp implements CalculationService {

    private int count = 0;
    @Override
    public void plusCount() {
        count=count+1;

    }

    @Override
    public int getCount() {
        System.out.println(count);
        return count;
    }
}
