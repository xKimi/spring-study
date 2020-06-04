package beans.multithreadsafe;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/1 16:48
 * @Author Feng Yalong
 */
public class WrongResultDemo {

    volatile static int i;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i++;
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        Thread thread1 = new Thread(r);
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
