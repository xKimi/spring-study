package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 16:44
 * @Author Feng Yalong
 */
public class AtomicLongDemo {

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        AtomicLong counter = new AtomicLong(0);
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(counter));
        }
        Thread.sleep(2000);
        System.out.println(counter.get());
        System.out.println(System.currentTimeMillis() - t1);
    }

    static class Task implements Runnable {
        private final AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }
}
