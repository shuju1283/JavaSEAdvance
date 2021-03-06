package com.shiju.homework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 电影院一共有100张票，写4个窗口卖这100张票，使用多线程 (线程池)来模拟卖票的过程
 *
 * @author shiju
 * @date 2021/04/12 20:13
 **/
public class TicketSales {
    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //创建Tickets对象
        Tickets lock = new Tickets();
        for (int i = 1; i <= 4; i++) {
            pool.submit(() -> {
                while (true) {
                    synchronized (lock) {
                        if (lock.ticket <= 0) {
                            System.out.println("票卖完了,886~");
                            break;
                        } else {
                            lock.ticket--;
                            System.out.println(Thread.currentThread().getName() + "卖出了一张票,还剩" + lock.ticket + "张票");
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
        pool.shutdown();
    }
}

class Tickets {
    public static volatile int ticket = 100;
}