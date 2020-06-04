package demo.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 11:40
 * @Author Feng Yalong
 */
public class BlockingQueuePutTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        new Thread( () -> {
            try {
                blockingQueue.put(1);
                blockingQueue.put(2);
                blockingQueue.put(3);
                System.out.println("blockingQueue放入了3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread( () -> {
            try {
                Thread.sleep(5000);
                System.out.println("remove开始操作");
                blockingQueue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ).start();
    }

}
