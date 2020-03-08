package com.andy.thread.producer;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(10);
                clerk.addProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
