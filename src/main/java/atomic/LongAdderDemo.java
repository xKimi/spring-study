package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 16:49
 * @Author Feng Yalong
 */
public class LongAdderDemo {
    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        LongAdder counter = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(counter));
        }
        Thread.sleep(2000);
        System.out.println(counter.sum());
        System.out.println(System.currentTimeMillis() - t1);
    }

    static class Task implements Runnable {
        private final LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }
}
