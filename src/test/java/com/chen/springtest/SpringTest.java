package com.chen.springtest;

import com.chen.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SpringTest extends BaseTest {

    @Autowired
    private Date myDate;

    @Test
    public void test() {
        System.out.println(myDate);
    }
}
