package atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 17:04
 * @Author Feng Yalong
 */
public class LongAccumulatorDemo {

    public static void main(String[] args) throws InterruptedException {
//        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y , 0);
//        ExecutorService service = Executors.newFixedThreadPool(8);
//        IntStream.range(1, 10).forEach(i -> service.submit(() -> accumulator.accumulate(i)));
//        Thread.sleep(500);
//        System.out.println(accumulator.getThenReset());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y , 0);
        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
        Thread.sleep(500);
        System.out.println(accumulator.getThenReset());
    }
}
