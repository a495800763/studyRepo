package com.javanetprogram.thread;

/**
 * @program: JavaNetProgram
 * @author: liumq
 * @create: 2020-04-10 09:06
 **/
public class TestThreadNew implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("threadNew");
        }
    }
}
