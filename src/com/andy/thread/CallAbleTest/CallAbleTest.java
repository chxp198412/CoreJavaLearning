package com.andy.thread.CallAbleTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum =0;
        for( int i = 0; i<=100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class CallAbleTest {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();

        FutureTask futureTask =  new FutureTask(numThread);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
           Object sum = futureTask.get();
           System.out.println("Sum is: "+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
