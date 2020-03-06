package com.andy.thread;

//class TicketWindow extends Thread{
//    private static int ticket = 100;
//    @Override
//    public void run() {
//        while (true){
//            if(ticket > 0){
//                System.out.println(Thread.currentThread().getName() + " sale ticket with num: " +ticket );
//                ticket--;
//            }
//
//        }
//    }
//}

import static java.lang.Thread.sleep;
//Use synchronized method
class TicketWindow2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            sale();

        }
    }

    private synchronized void sale(){
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " sale ticket with num: " + ticket);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            }
        }
    }

public class SaleTickets2 {
    public static void main(String[] args){
        TicketWindow2 ticketWindow2 = new TicketWindow2();
        Thread t1 = new Thread(ticketWindow2);
        Thread t2 = new Thread(ticketWindow2);
        Thread t3 = new Thread(ticketWindow2);

        t1.setName("Window1");
        t2.setName("Window2");
        t3.setName("Window3");

        t1.start();
        t2.start();
        t3.start();
    }
}


