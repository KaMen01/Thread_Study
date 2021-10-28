package com.km.study.thread.t3_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author coming
 * @date 2021/10/25 20:55
 */
public class ThreadInterrupt_2 {
    public static void main(String[] args) {
        System.out.println("Thread-Main is interrupted:"+Thread.currentThread().isInterrupted());

        Thread.currentThread().interrupt();

        System.out.println("Thread-Main is interrupted:"+Thread.currentThread().isInterrupted());

        //当我先给线程interrupt，然后执行可中断方法时，直接捕获到interrupt的signal，抛出异常
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Thread-Main is interrupted:"+Thread.currentThread().isInterrupted());
        }
    }
}
