package demo.collection;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/4 10:47
 * @Author Feng Yalong
 */
public class ElementTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        blockingQueue.element();
    }
}
