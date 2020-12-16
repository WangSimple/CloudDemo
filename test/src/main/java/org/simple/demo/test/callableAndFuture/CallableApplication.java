package org.simple.demo.test.callableAndFuture;

import java.util.concurrent.*;

public class CallableApplication {
    private static Callable<String> myCall=new MyCallable();
    private static Runnable myRun=new MyRunable();
    public static void main(String[] args) {
        testRun();
       // testCall();

    }

    public static void testRun(){
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(myRun);
        try {
            System.out.println(submit.isDone());
            System.out.println("-----------------------");
            //Object o = submit.get(5000,TimeUnit.MILLISECONDS);
            Thread.sleep(3000L);

            submit.cancel(true);
            System.out.println("-----------------------");
            //System.out.println(o);
            System.out.println("-----------------------");
            System.out.println(submit.isDone());
        } catch (Exception e) {
            e.printStackTrace();
            executorService.shutdown();
        }
    }

    public static void testCall(){
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(myCall);
        try {
            System.out.println(submit.isDone());
            System.out.println("---------------------------");
            Object o = submit.get(5000,TimeUnit.MILLISECONDS);
           //Thread.sleep(3000L);
            submit.cancel(true);
            System.out.println("---------------------------");
            System.out.println(submit.isDone());
        } catch (Exception e) {
            e.printStackTrace();
            //submit.cancel(true);
            executorService.shutdown();//并不会终止目前正在运行的线程
        }
    }
}
