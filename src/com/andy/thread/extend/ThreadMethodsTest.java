package com.andy.thread.extend;

import static java.lang.Thread.sleep;

class MyThread01 extends Thread{
    public MyThread01(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i<=100; i++){
            if(i%2 ==0){
                //test sleep
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":"+ getPriority() + i);
            }
            //测试yield方法
//            if(i%20 == 0){
//                yield();
//            }
        }
    }
}

public class ThreadMethodsTest {
    public static void main(String[] args){
        MyThread01 t1 = new MyThread01("Thread 1");
        //t1.setName("Thread 1");
        t1.start();

        //给主线程命名
        Thread.currentThread().setName("Main Thread");
        for(int i = 0; i<=100; i++){
            if(i%2 !=0){
                System.out.println(Thread.currentThread().getName() + ":"+ Thread.currentThread().getPriority() + i);
            }

            //测试join
//            if(i == 20){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
