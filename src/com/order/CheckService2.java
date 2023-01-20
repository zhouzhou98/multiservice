package com.order;

public class CheckService2 {
    public Boolean check() {
        Boolean tag = true;
        try {
            //模拟执行逻辑
            Thread.sleep(1800);
            System.out.println("==CheckService2.check==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tag;
    }
}
