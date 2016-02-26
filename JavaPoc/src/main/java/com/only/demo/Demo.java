package com.only.demo;


public class Demo {

	private int m_Age;
    private final int AGE_INPUT = 15;

    public Demo() {
        setAge(AGE_INPUT);
    }

    public int getAge() {
        return m_Age;
    }

    private void setAge(int age) {
        m_Age = age;
    }

}
