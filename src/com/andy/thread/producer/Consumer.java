package com.andy.thread.producer;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(120);
                clerk.subProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
