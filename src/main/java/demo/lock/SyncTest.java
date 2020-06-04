package demo.lock;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/2 14:43
 * @Author Feng Yalong
 */
public class SyncTest {
    public void syncBlock() {
        synchronized (this) {
            System.out.println("kimi");
        }
    }
}
