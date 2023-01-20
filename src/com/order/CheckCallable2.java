package com.order;

import java.util.concurrent.Callable;

public class CheckCallable2 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        CheckService2 checkService2 = new CheckService2();
        return checkService2.check();
    }
}
