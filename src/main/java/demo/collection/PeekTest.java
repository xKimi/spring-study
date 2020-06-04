package demo.collection;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 11:30
 * @Author Feng Yalong
 */
public class PeekTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        System.out.println(blockingQueue.peek());
    }
}
