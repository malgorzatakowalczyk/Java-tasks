//ZADANIE 3
/*
Napisz program losujacy liczbe z zakresu 0-100. Nastepnie program pyta sie uzytkownika, co to za 
liczba. Jezeli uzytkownik nie zgadl, dowiaduje sie czy wylosowana liczba jest wieksza czy mniejsza
od podanej. Jezeli zgadl, dowiaduje sie ile wykonal prob i jest pytany o ochote do dalszej gry. 
*/
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        try
        {
        for(;;)
        {
        Scanner input=new Scanner(System.in);
        Random r = new Random(); 
        int a = r.nextInt(101);
        int b=0;
        int proba=1;
        int graDalej=1;
        for(;;)
        {
        System.out.println("Podaj liczbe");
        b=input.nextInt();
        if(b==a)
        {
            System.out.println("Liczbe odgadnieto po "+proba+" probach");
            String [] tak={"tak","TAK"};
            String []nie={"nie","NIE"};
            for(;;)
            {
            System.out.println("Czy chcesz grac dalej?tak/nie");
            String wyjscie=input.next();
            if(wyjscie.equals(tak[0]) || wyjscie.equals(tak[1]))
            {
                graDalej=1;
                break;
            }
            else if(wyjscie.equals(nie[0]) || wyjscie.equals(nie[1]))
            {
                graDalej=0;
                break;
            }
            }
            break;
            
        }
        else if(b>a)
        {
            System.out.println("Wylosowana liczba jest mniejsza");
            proba++;
        }
        else
        {
            System.out.println("Wylosowana liczba jest wieksza");
            proba++;
        }
        }
         if(graDalej==0) break;
         if(graDalej!=1 && graDalej!=0) break; //wyjatek
        }
    }
    catch(Exception e)
    {
            System.out.println("Wyjatek "+e);
    }
    }
    
}
