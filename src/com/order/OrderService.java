package com.order;

import java.util.concurrent.*;

public class OrderService {
    public static void createSyncOrder() {
        CheckService1 checkService1 = new CheckService1();
        CheckService2 checkService2 = new CheckService2();
        CheckService3 checkService3 = new CheckService3();
        checkService1.check();
        checkService2.check();
        checkService3.check();
        createOrder();
    }

    private static void createOrder() {
        try {
            Thread.sleep(500);
            System.out.println("==finally create Order==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createCompleteAsyncOrder() {
        CheckService1 checkService1 = new CheckService1();
        CheckService2 checkService2 = new CheckService2();
        CheckService3 checkService3 = new CheckService3();
        CompletableFuture<Boolean> f1 = CompletableFuture.supplyAsync(() -> {
            return checkService1.check();
        });
        CompletableFuture<Boolean> f2 = CompletableFuture.supplyAsync(() -> {
            return checkService2.check();
        });
        CompletableFuture<Boolean> f3 = CompletableFuture.supplyAsync(() -> {
            return checkService3.check();
        });
        CompletableFuture.allOf(f1, f2, f3).thenRun(() -> {
            createOrder();
        }).join();
    }
    public static void createAsyncOrder() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CheckCallable2 checkCallable2 = new CheckCallable2();
        CheckCallable1 checkCallable1 = new CheckCallable1();
        CheckCallable3 checkCallable3 = new CheckCallable3();
        Future<Boolean> f1 = executorService.submit(checkCallable1);
        Future<Boolean> f2 = executorService.submit(checkCallable2);
        Future<Boolean> f3 = executorService.submit(checkCallable3);
        try {
            if (f1.get() && f2.get() && f3.get()) {
                createOrder();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        long t1=System.currentTimeMillis();
        System.out.println("begin to excute createSyncOrder");
        OrderService.createSyncOrder();
        System.out.println("end createSyncOrder , it has spent "+ (System.currentTimeMillis()-t1)+" ms");
        System.out.println("===========================================");
        long t2=System.currentTimeMillis();
        System.out.println("begin to excute createParrelOrder");
        OrderService.createAsyncOrder();
        System.out.println("end createParrelOrder, it has spent "+ (System.currentTimeMillis()-t2)+" ms");
        long t3=System.currentTimeMillis();
        System.out.println("begin to excute complete order");
        OrderService.createCompleteAsyncOrder();
        System.out.println("end excute complete order, it has spent "+ (System.currentTimeMillis()-t3)+" ms");

    }
}
