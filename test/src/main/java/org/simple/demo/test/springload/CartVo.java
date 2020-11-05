package org.simple.demo.test.springload;

import lombok.Data;

@Data
public class CartVo {
    private  Integer cartID;
    private String cartName;

    public  CartVo(){

        System.out.println("CartVo constructor");
    }
}

