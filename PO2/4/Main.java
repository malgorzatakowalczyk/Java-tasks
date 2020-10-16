/*
Napisz program losujacy 1000 znakow i zapisz je do pliku, a nastepnie odczytaj pliku i wypisz na ekran.
Utworz dwie rozne pary procedur zapisujaco/odczytujacych, raz korzystajac z pakietu java.io a
drugi raz z pakietu java.nio. Porownaj szybkosc zapisu i odczytu, wynik wypisz na ekranie. 
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;


public class Main {
    public static void main(String[] args) { 
        //losowanie znaków 
        Random rand = new Random();
        char[] str = new char[1000];  
        for(int i = 0; i < 1000 ;i++)
            str[i] = (char)(rand.nextInt(126 - 32 + 1) + 32);
        String name1="file1.txt";
        String name2="file2.txt";
        long zap = System.currentTimeMillis();
        zapisywanie_io(name1,str);
        long zap2 = System.currentTimeMillis();
        long czas_zapis=zap2-zap;
        zap = System.currentTimeMillis();
        odczytywanie_io(name1);
        zap2 = System.currentTimeMillis();
        long czas_odczyt=zap2-zap;
        System.out.println();
        zap = System.currentTimeMillis();
        zapisywanie_nio(name2,str);
        zap2 = System.currentTimeMillis();
        long czas_zapis_nio=zap2-zap;
        zap = System.currentTimeMillis();
        odczytywanie_nio(name2);
        zap2 = System.currentTimeMillis();
        long czas_odczytu_nio=zap2-zap;
        System.out.println("Zapisywanie za pomoca pakietu io trwa "+ czas_zapis +"ms");
        System.out.println("Zapisywanie za pomoca pakietu nio trwa "+ czas_zapis_nio +"ms");
        System.out.println("Odczytanie za pomoca pakietu io trwa "+czas_odczyt +"ms");
        System.out.println("Odczytanie za pomoca pakietu nio trwa "+czas_odczytu_nio +"ms");
    }
    ///////////////////////////////// IO ////////////////////////////////
    //////////////////////////////// ZAPISYWANIE ///////////////////////
    static void zapisywanie_io(String name,char[] str)
    {
    try
    {
    PrintWriter zapis = new PrintWriter(name);
    zapis.println(str);
    zapis.close();
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
    }
    ///////////////////////////////// ODCZYTYWANIE /////////////////////////
    static void odczytywanie_io(String name)
    {
        try
        {
         BufferedReader reader= new BufferedReader(new FileReader(name));
         String tresc="";
         while((tresc=reader.readLine())!=null)
            System.out.println(tresc);
         reader.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    ///////////////////////////////// NIO ////////////////////////////////
    //////////////////////////////// ZAPISYWANIE /////////////////////////
   static void zapisywanie_nio(String f,char[] s) {
       try{
                String msg=new String(s);
                Files.write(Paths.get(f), msg.getBytes());
       }
       catch(IOException e)
       {
           System.out.println(e.getMessage());
       }
	}
   ////////////// ODCZYTYWANIE /////////////////////////////////////
       static void odczytywanie_nio(String f) {
            try
            {
             String content = new String(Files.readAllBytes(Paths.get(f)));
             System.out.println(content);
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
       }


}
    
