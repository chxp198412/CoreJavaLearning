package com.andy.proxy;

/*
*
* 动态代理举例
*
*
*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{

    String getBelief();

    void eat(String food);
}

class Superman implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat " + food);
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();

        Object returnValue = method.invoke(obj, args);

        util.method2();
        return returnValue;
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("=========generic method1=======");
    }

    public void method2(){
        System.out.println("=========generic method2=======");
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        Human superMan = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("aaa");

        System.out.println("*************************");

        ClothFactory nikeFactory = new NikeClothFactory();
        ClothFactory clothProxy = (ClothFactory) ProxyFactory.getProxyInstance(nikeFactory);

        clothProxy.produceCloth();
    }
}
