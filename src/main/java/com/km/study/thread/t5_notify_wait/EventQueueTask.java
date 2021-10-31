package com.km.study.thread.t5_notify_wait;

import java.util.concurrent.TimeUnit;

/**
 * @author coming
 * @date 2021/10/28 20:59
 */
public class EventQueueTask {
    public static void main(String[] args) {
        final EventQueue eventQueue= new EventQueue();
        new Thread(()->{
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();

        new Thread(()->{
            for(;;){
                try {
                    eventQueue.take();
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
