package com.andy.proxy;

interface ClothFactory {
    void produceCloth();
}

class ClothFactoryProxy implements ClothFactory {
    private ClothFactory clothFactory;

    public ClothFactoryProxy(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("prepare....");

        clothFactory.produceCloth();

        System.out.println("finished....");

    }
}

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike producing....");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();

        ClothFactoryProxy proxy = new ClothFactoryProxy(nike);

        proxy.produceCloth();
    }
}
