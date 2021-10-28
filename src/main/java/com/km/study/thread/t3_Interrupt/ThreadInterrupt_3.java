package com.km.study.thread.t3_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author coming
 * @date 2021/10/25 22:30
 */
public class ThreadInterrupt_3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("i will start work");
                while (!isInterrupted()){
                    //working
                    System.out.println("一直劳碌的命啊");
                }
                System.out.println("i will be exiting");
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }
}
