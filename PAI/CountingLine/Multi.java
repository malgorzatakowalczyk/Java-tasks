/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Malgorzata
 */
public class Multi {

    static long multi(String[] args) {
        System.out.println("\nFirst method");
        long timeBefore = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(args.length);
        for (int i = 0; i < args.length; i++) {
            Runnable worker = new OnePthread(args[i]);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long timeAfter = System.currentTimeMillis();
        long executionTime = timeAfter - timeBefore;
        return executionTime;
    }
}
