package com.order;

public class CheckService3 {
    public Boolean check() {
        Boolean tag = true;
        try {
            //模拟执行逻辑
            Thread.sleep(1500);
            System.out.println("==CheckService3.check==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tag;
    }
}
