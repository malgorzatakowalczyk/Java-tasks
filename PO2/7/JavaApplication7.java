
package javaapplication7;
/*
Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable. +
Nastepnie utworz abstrakcyjna klase Wpis a nastepnie dziedziczace z niej klasy Osoba i Firma. +
Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis. +
Byc moze ma rowniez inne metody abstrakcyjne lub nie w miare potrzeb. 
Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu). +
Klasa Firma ma miec nazwe i adres( w tym NrTelefonu). +

Utworz kilka obiektow klasy Osoba i kilka obiektow klasy Firma i umiesc je w kontenerze TreeMap, 
poslugujac sie jako kluczem numerem telefonicznym.
Nastepnie wypisz utworzona w ten sposob ksiazke telefoniczna za pomoca iteratora.
*/
import java.util.*; 

public class JavaApplication7 {


    public static void main(String[] args) {
       Osoba osoba1=new Osoba("Kasia","Nowak","Narutowicza 7",48,509629790);
       Osoba osoba2=new Osoba("Pawel","Nowak","Narutowicza 7",48,691629790);
       Osoba osoba3=new Osoba("Weronika","Kowalska","Pilsudskiego",51,771629790);
       Osoba osoba4=new Osoba("Marta","Zajac","Nawrot 19",52,871667790);
       Osoba osoba5=new Osoba("Kamil","Szymanski","Piotrkowska 3",49,508771453);
       Firma firma1=new Firma("CD Projekt","Marszalkowska 19",48 ,510345210);
       Firma firma2=new Firma("Bershka","Karskiego 5",42,6310262);
       Firma firma3=new Firma("Empik","Marszałkowska 104/122",48, 224627250);
       Firma firma4=new Firma("Mohito","Złota 59",48,572708216);
       Firma firma5=new Firma("Annabelle minerals","gen.Maczka 9",48,669921792);

       System.out.println("Ksiazka telefoniczna");
       TreeMap<NrTelefoniczny, Wpis> map = new TreeMap<>();
        map.put(osoba1.numerTel, osoba1);
        map.put(osoba2.numerTel, osoba2);
        map.put(osoba3.numerTel, osoba3);
        map.put(osoba4.numerTel, osoba4);
        map.put(osoba5.numerTel, osoba5);
        map.put(firma1.numerTel, firma1);
        map.put(firma2.numerTel, firma2);
        map.put(firma3.numerTel, firma3);
        map.put(firma4.numerTel, firma4);
        map.put(firma5.numerTel, firma5);
        for(Map.Entry<NrTelefoniczny,Wpis> en:map.entrySet())
        {
            en.getValue().opis();
        }
    }
    
}
class NrTelefoniczny implements Comparable<NrTelefoniczny>
{
    NrTelefoniczny(){
        
    }
    NrTelefoniczny(int nrKierunkowy, int nrTelefonu)
    {
        this.nrKierunkowy=nrKierunkowy;
        this.nrTelefonu=nrTelefonu;
    }
    int nrKierunkowy; 
    int nrTelefonu;
   public int compareTo(NrTelefoniczny pn) {
    int result = Integer.compare(nrKierunkowy, pn.nrKierunkowy);
        if (result == 0) {
            result = Integer.compare(nrTelefonu, pn.nrTelefonu);
            }   
        return result;
}
}
abstract class Wpis
{
    abstract void opis();
}
class Osoba extends Wpis
{
    Osoba()
    {
    }
    Osoba(String name,String surname,String adres,int kierunkowy,int numer)
    {
        this.name=name;
        this.surname=surname;
        this.adres=adres;
        numerTel=new NrTelefoniczny(kierunkowy,numer);
    }
    private String name;
    private String surname;
    private String adres;
    NrTelefoniczny numerTel;
    void opis()
    {
        System.out.println(name+" "+surname+" "+adres+" "+numerTel.nrKierunkowy+" "+numerTel.nrTelefonu);       
    }
}
class Firma extends Wpis
{
    Firma()
    {
    }
    Firma(String name,String adres,int kierunkowy,int numer)
    {
        this.name=name;
        this.adres=adres;
        numerTel=new NrTelefoniczny(kierunkowy,numer);
    }
    private String name;
    private String adres;
    NrTelefoniczny numerTel;
    void opis()
    {
               System.out.println(name+" "+adres+" "+numerTel.nrKierunkowy+" "+numerTel.nrTelefonu);        
    }
}
