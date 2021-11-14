package com.restdemo.demo;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class newFile {
    public static void main(String args[]) {
        ConfigurableApplicationContext x = SpringApplication.run(newFile.class);
        Example y = x.getBean(Example.class);
        y.display();
    }
    
}
