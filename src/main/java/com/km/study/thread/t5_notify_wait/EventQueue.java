package com.km.study.thread.t5_notify_wait;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author coming
 * @date 2021/10/28 20:41
 */
public class EventQueue {
    private final int max;

    static class Event{}

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max){
        this.max = max;
    }

    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size()>=max){
                try {
                    console("事件队列已满");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //若队列未满
            eventQueue.addLast(event);
            console("事件已添加到队列中");
            eventQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.size()<= 0 ){
                try {
                    console("事件队列中没有事件需要处理");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //若存在事件
            Event event = eventQueue.removeFirst();
            console("事件"+event+"处理成功~");
            eventQueue.notify();
            return event;
        }
    }


    private void console(String message){
        System.out.printf("%s:%s\n", Thread.currentThread().getName(),message);
    }
}
