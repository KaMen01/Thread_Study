package com.km.study.thread.t1_begin;


import java.util.stream.IntStream;

public class ThreadTest_3 {

    private final static String PREFIX="ALEX-";

    public static void main(String[] args) {
        IntStream.range(0,5).mapToObj(ThreadTest_3::createThread).forEach(Thread::start);
    }

    private static Thread createThread(int intName){
        return new Thread(()-> System.out.println(Thread.currentThread().getName()),PREFIX+intName);

    }
}
