package com.andy.thread.producer;

public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread productThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);

        productThread.setName("producer1");
        consumerThread.setName("consumer1");
        consumerThread2.setName("consumer2");

        productThread.start();
        consumerThread.start();
        consumerThread2.start();
    }
}
