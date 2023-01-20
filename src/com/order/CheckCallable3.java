package com.order;

import java.util.concurrent.Callable;

public class CheckCallable3 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        CheckService3 checkService3 = new CheckService3();
        return checkService3.check();
    }
}
