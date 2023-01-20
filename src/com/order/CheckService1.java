package com.order;

public class CheckService1{

    public Boolean check() {
        Boolean tag = true;
        try {
            //模拟执行逻辑
            Thread.sleep(2500);
            System.out.println("==CheckService1.check==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tag;
    }
}
