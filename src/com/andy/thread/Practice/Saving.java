package com.andy.thread.Practice;

import static java.lang.Thread.sleep;

public class Saving {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        Customer c3 = new Customer(account);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        t1.setName("c1");
        t2.setName("c2");
        t3.setName("c3");
        t2.start();
        t3.start();
        t1.start();

    }

}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double money){
        balance+=money;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " deposited success ,Current Balance is: " + balance);
    }
}

class Customer implements Runnable{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
            for(int i = 0; i<3; i++){
                account.deposit(1000);
            }
    }
}