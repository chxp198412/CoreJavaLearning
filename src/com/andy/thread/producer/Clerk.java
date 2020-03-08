package com.andy.thread.producer;

public class Clerk {
    int product = 0 ;

    public synchronized void addProduct() {
        if(product<20){
            product++;
            System.out.println(Thread.currentThread().getName() + " started produce No. " + product );
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void subProduct() {
        if(product > 0){
            System.out.println(Thread.currentThread().getName() + " started consume No. " + product);
            product--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
