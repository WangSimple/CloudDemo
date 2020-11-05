package org.simple.demo.test.jvmload;

public class SuperBean {
    {
        System.out.println("Super block");
    }
    static{
        System.out.println("Super static");
    }
    public SuperBean(){
        System.out.println("Super constructor");
    }
}

