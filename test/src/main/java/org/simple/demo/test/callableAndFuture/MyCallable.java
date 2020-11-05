package org.simple.demo.test.callableAndFuture;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {


    @Override
    public String call() throws Exception {
        int i=0;
        //while(!Thread.currentThread().isInterrupted()){
        while(true){
            System.out.println(this.getClass().getName()+"---"+(++i)+"\n");
            Thread.sleep(1000);
        }
        //return sb.toString();
       // return "out";
    }
}
