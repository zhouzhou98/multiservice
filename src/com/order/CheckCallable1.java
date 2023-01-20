package com.order;

import java.util.concurrent.Callable;

public class CheckCallable1 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        CheckService1 checkService1 = new CheckService1();
        return checkService1.check();
    }
}
