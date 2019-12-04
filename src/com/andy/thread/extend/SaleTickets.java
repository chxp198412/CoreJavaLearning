package com.andy.thread.extend;

class TicketWindow extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + " sale ticket with num: " +ticket );
                ticket--;
            }

        }
    }
}

public class SaleTickets {
    public static void main(String[] args){
        TicketWindow t1 = new TicketWindow();
        TicketWindow t2 = new TicketWindow();
        TicketWindow t3 = new TicketWindow();

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}


