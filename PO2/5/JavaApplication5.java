package javaapplication5;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;	
import javax.swing.*;

public class JavaApplication5 {
  public static void main(String args[]) throws Exception {
    //POBIERANIE OD UZYTKOWNIKA NAZWY PLIKU
    Scanner scan = new Scanner(System.in);
    System.out.println("Podaj nazwe pliku");
    String file = scan.nextLine();
    BufferedReader reader;
    //SPRAWDZENIE CZY PLIK ISTNIEJE 
    try
    {
    reader= new BufferedReader(new FileReader(file));
    }
    catch(Exception e)
    {
        System.out.println("Nie ma takiego pliku");
        return;
    }
    ///ZAPISUJEMY NAZWE SCIEZKI DO PLIKU
    try
    {
    PrintWriter zapis = new PrintWriter("sciezkaDoPliku.txt");
    zapis.println(file);
    zapis.close();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }

   JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTextField nameTextField = new JTextField();
   
    frame.add(nameTextField, BorderLayout.NORTH);

    KeyListener keyListener = new KeyListener() {
      public void keyPressed(KeyEvent keyEvent) {     
        try
        {
         Random rand = new Random();
         int a = rand.nextInt(5)+1;
         for(int i=0;i<a;i++)
         {
             int theCharNum = reader.read();
             if(theCharNum==-1) 
             {
                 System.out.println("\nZostał wczytany cały plik");
                 frame.setVisible (false);
                 System.exit(0);
             }
             char theChar = (char) theCharNum;
             System.out.print(theChar);
         }
        }
        catch(IOException e)
        {
              
           System.out.println(e.getMessage());
        }
      }
      public void keyReleased(KeyEvent keyEvent) {
      }
      public void keyTyped(KeyEvent keyEvent) {
      }

    };
    nameTextField.addKeyListener(keyListener);
 

    frame.setSize(250, 100);
    frame.setVisible(true);
  }
}

 