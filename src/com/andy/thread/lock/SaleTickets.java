package com.andy.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

class TicketWindow implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " sale ticket with num: " + ticket);
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class SaleTickets {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        Thread t1 = new Thread(ticketWindow);
        Thread t2 = new Thread(ticketWindow);
        Thread t3 = new Thread(ticketWindow);

        t1.setName("Window1");
        t2.setName("Window2");
        t3.setName("Window3");

        t1.start();
        t2.start();
        t3.start();
    }
}