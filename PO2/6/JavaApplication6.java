package javaapplication6;

import java.util.*;
import java.io.*;

public class JavaApplication6 {

    public static void main(String[] args) {
        Vector<Double> v1 = new Vector<Double>();
        Vector<Double> v2 = new Vector<Double>();
        Vector<Double> suma = new Vector<Double>();
        while(true)
        {
        v1.clear(); 
        v2.clear(); 
        suma.clear(); 
        System.out.println("Podaj pierwszy wektor");
        v1=czytajVector();
        System.out.println("Podaj drugi wektor");
        v2=czytajVector();
        try
        {
            if(v1.size()!=v2.size())
                    throw new WektoryRoznejDlugosciException(v1.size(),v2.size(),"Wektory nie sa rowne");
            //DODAWANIE WEKTOROW
            for(int i=0;i<v1.size();i++)
            {
                suma.add(v1.get(i)+v2.get(i));
            }
            System.out.println("Suma wektorow"+suma);
            try
            {
            File file = new File("sumaWektorow.txt");
            if(!file.exists()) 
              file.createNewFile();
            PrintWriter zapis = new PrintWriter(file);
            zapis.println(suma);
            zapis.close();
            break;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        catch(WektoryRoznejDlugosciException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Dlugosc pierwszego wektora to "+ ex.getFirstValue()+" a drugiego to " + ex.getSecondValue());
        }  
        }
    }
 	static Vector<Double> czytajVector() {
            Vector<Double> v1 = new Vector<Double>();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader rd = new BufferedReader(isr);
            String val=null;
            try
            {                
                val=rd.readLine();
            }
            catch(Exception e)
            {
                System.out.println("Nie udalo sie wczytac wektora");
            }
            Scanner szukajDouble = new Scanner(val);
            while(szukajDouble.hasNext()) {
            if(szukajDouble.hasNextDouble())
		v1.add(szukajDouble.nextDouble());
            else
		szukajDouble.next();
		}
            szukajDouble.close();
            return v1;
	}
}
class WektoryRoznejDlugosciException extends Exception
        {
            private final int first;
            private final int second;
            public WektoryRoznejDlugosciException(int first,int second,String string)
            {
                super(string);
                this.first = first;
                this.second=second;
            }
             public int getFirstValue() {
                    return first;   
            }
            public int getSecondValue() {
                    return second;   
            }
        }
