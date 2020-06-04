package beans.multithreadsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/6/1 18:14
 * @Author Feng Yalong
 */
public class WrongInitDemo {

    private Map<Integer, String> students;

    public WrongInitDemo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                students = new HashMap<>();
                students.put(1, "赵一");
                students.put(2, "钱二");
                students.put(3, "孙三");
                students.put(4, "李四");
            }
        }).start();
    }

    public Map<Integer, String> getStudents() {
        return students;
    }

    public static void main(String[] args) throws InterruptedException {
        WrongInitDemo wrongInitDemo = new WrongInitDemo();
        Thread.sleep(1000);
        System.out.println(wrongInitDemo.getStudents().get(1));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
