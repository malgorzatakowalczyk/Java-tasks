//ZADANIE 2
/*
Napisz program, ktory pobiera dwie liczby oraz lancuch znakow z wiersza polecen oraz wyswietla fragment podanego lancucha okreslony wprowadzonymi liczbami. Na przyklad:
java Substring Witaj 2 4
powinien wyswietlic:
taj
Obsluz wszystkie mozliwe wyjatki, ktore moga wystapic w przypadku zlego zestawu argumentow.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {

    public static void main(String[] args) {
        try
        {
        System.out.println("Podaj napis i dwie liczby");
        int liczba1=0;
        int liczba2=0;
       
        Scanner input=new Scanner(System.in);
        String napis=input.next();
        try
        {
        liczba1=input.nextInt();
        }
        catch (InputMismatchException e) {
            input.close();
             System.out.println("Podałeś liczbę w złym formacie");
             return;
         }
        try
        {
        liczba2=input.nextInt();
        }
        catch (InputMismatchException e) {
            input.close();
             System.out.println("Podałeś liczbę w złym formacie");
             return;
         }
        int len=napis.length();
        if(liczba1>liczba2 || len<liczba2 || liczba1<0 || liczba2<0)
        {
            System.out.println("Podane liczby nie spełniaja warunkow zadania");
            throw new StringIndexOutOfBoundsException ();
        }
        System.out.println(napis.substring(liczba1,liczba2+1));
        input.close();
        }
       catch(Exception e)
    {
        System.out.println("Wystapil blad");
    }
    }
}
