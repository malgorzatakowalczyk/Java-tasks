/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingline;

/**
 *
 * @author Malgorzata Kowalczyk
 */
import static countingline.Multi.multi;
import static countingline.Single.single;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingLine {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough arguments");
        } else {
            long executionTimeOfFirstMethod = multi(args);
            long executionTimeOfSecondMethod = single(args);
            System.out.println("\nExcecution time of the first method:\t" + executionTimeOfFirstMethod);
            System.out.println("Excecution time of the second method:\t" + executionTimeOfSecondMethod);
        }
    }

    public static int countingLinesInAFile(String nameOfFile) {
        int numberOfLinesInTheFile = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            while ((reader.readLine()) != null) {
                numberOfLinesInTheFile += 1;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return numberOfLinesInTheFile;
    }

}
