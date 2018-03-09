package com.foo.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test() {
        this.jmsTemplate.convertAndSend("foo", "Hello, world!");
        this.jmsTemplate.setReceiveTimeout(1_000);
        Assert.assertEquals("Hello, world!", this.jmsTemplate.receiveAndConvert("foo"));
    }

}