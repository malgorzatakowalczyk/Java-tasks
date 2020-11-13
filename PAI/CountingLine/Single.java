/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malgorzata Kowalczyk
 */
public class Single {

    static long single(String[] args) {
        System.out.println("\nSecond method");
        long timeBefore = System.currentTimeMillis();
        for (int i = 0; i < args.length; i++) {
            System.out.println("File " + args[i] + ": " + CountingLine.countingLinesInAFile(args[i]) + " lines");
        }
        long timeAfter = System.currentTimeMillis();
        long executionTime = timeAfter - timeBefore;
        return executionTime;
    }
}
