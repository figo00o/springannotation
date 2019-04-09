package com.figo.aop;

import org.springframework.stereotype.Component;

@Component
public class MathCaculator {

    public int div(int i,int j){
        return i/j;
    }
}
