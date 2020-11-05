package org.simple.demo.test.callableAndFuture;

import java.util.concurrent.Callable;

public class MyRunable implements Runnable {


    @Override
    public void run()
    {
        int i=0;
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(this.getClass().getName()+"---"+(++i)+"\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //return sb.toString();
    }
}
