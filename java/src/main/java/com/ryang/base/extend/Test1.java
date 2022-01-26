package com.ryang.base.extend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() ->{

                System.out.println("111");
                System.out.println(1/0);

//            catch (Exception e) {
//                System.out.println(e);
//            }

        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}


