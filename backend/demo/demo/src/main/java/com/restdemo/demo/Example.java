package com.restdemo.demo;

import org.springframework.stereotype.Component;

@Component
public class Example {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void display() {
        System.out.println("display this");
    }

}
