

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malgorzata Kowalczyk
 */

public class OnePthread implements Runnable {

    private final String nameOfFile;

    public OnePthread(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @Override
    public void run() {
        System.out.println("File: " + nameOfFile + ": " + CountingLine.countingLinesInAFile(nameOfFile) + " lines");
    }

}
