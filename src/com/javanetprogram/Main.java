package com.javanetprogram;

import com.javanetprogram.thread.TestThread;
import com.javanetprogram.thread.TestThreadNew;

public class Main {

    public static void main(String[] args) {
	  Thread t = new Thread(new TestThread());
	  Thread s = new Thread( new TestThreadNew());
	  t.start();
	  s.start();
    }
}
