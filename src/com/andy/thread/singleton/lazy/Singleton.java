package com.andy.thread.singleton.lazy;

//Thread not safe
//public class Singleton {
//    private static Singleton instance = null;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//
//}

//Thread safe
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    //not effective
//    public synchronized static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    //effective with double check
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }

        return instance;
    }

}