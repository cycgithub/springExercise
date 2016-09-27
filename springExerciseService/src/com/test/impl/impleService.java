package com.test.impl;

import com.test.ServiceTest;
import org.springframework.stereotype.Service;

/**
 * Created by chenyuchao on 2016/9/26.
 */
@Service("impleService")
public class ImpleService implements ServiceTest{
    @Override
    public String play(String abc){
        System.out.println("asdfasd");
        return abc;
    }
}
