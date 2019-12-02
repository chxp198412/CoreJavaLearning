package com.andy.thread;

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}


public class ThreadTest{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        //不能再次启动已经启动的线程，会报错
        //t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        for(int i = 0; i<100; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i + "******");
        }
    }

}
