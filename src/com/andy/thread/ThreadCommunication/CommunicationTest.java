package com.andy.thread.ThreadCommunication;

import static java.lang.Thread.sleep;

class NumberThread implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();

                if (number <= 100) {

                    try {
                        sleep(100);
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                        number++;

                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        Thread t1 = new Thread(numberThread);
        Thread t2 = new Thread(numberThread);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

}
