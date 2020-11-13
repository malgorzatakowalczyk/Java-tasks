Zadania na zajęcia Programowanie Obiektowe 2 i Projektowanie Aplikcacji Internetowych 
Polecenia PO2 
1. Napisz program czytajacy argumenty wywolania programu i konwertujacy je do Integer. 
Zmodyfikuj program w ten sposob, aby kolejne argumenty byly wspolczynikami wielomianu postaci Ax2+Bx+C=0. Policz pierwiastki tego wielomianu. <br />
2.Napisz program, ktory pobiera dwie liczby oraz lancuch znakow z wiersza polecen oraz wyswietla fragment podanego lancucha okreslony wprowadzonymi liczbami. Na przyklad:
java Substring Witaj 2 4<br />
powinien wyswietlic:<br />
taj<br />
Obsluz wszystkie mozliwe wyjatki, ktore moga wystapic w przypadku zlego zestawu argumentow.<br />
3. Napisz program losujacy liczbe z zakresu 0-100. Nastepnie program pyta sie uzytkownika, co to za liczba. 
Jezeli uzytkownik nie zgadl, dowiaduje sie czy wylosowana liczba jest wieksza czy mniejsza od podanej. 
Jezeli zgadl, dowiaduje sie ile wykonal prob i jest pytany o ochote do dalszej gry.<br />
4. Napisz program losujacy 1000 znakow i zapisz je do pliku, a nastepnie odczytaj pliku i wypisz na ekran. 
Utworz dwie rozne pary procedur zapisujaco/odczytujacych, raz korzystajac z pakietu java.io a drugi raz z pakietu java.nio.
Porownaj szybkosc zapisu i odczytu, wynik wypisz na ekranie. <br />
5. Napisz program odczytujacy zawartosc pliku tekstowego. Sciezka do pliku powinna byc podawana przez uzytkownika po uruchomieniu programu oraz zapisywana do osobnego pliku.
Po nacisnieciu dowolnego klawisza program pobiera kolejny ciag znakow o losowej dlugosci (od 1 do 5 znakow) z wczytanego pliku tekstowego i wyswietla go na ekranie. <br />
6. Napisz program proszacy o podanie 2 wektorow (wektor to ciag liczb). Koniec wektora oznacza sie za pomoca wcisniecia klawisza enter. 
 Jezeli podany ciag nie jest liczba, jest ignorowany. Nastepnie nalezy sprobowac dodac wektory, jezeli sa rownej dlugosci. 
Jezeli nie, sa, rzucany jest wlasny wyjatek WektoryRoznejDlugosciException, za pomoca ktorego mozna podac a nastepnie odczytac dlugosci tych wektorow (nalezy tak skonstruowac wyjatek, aby mozliwe bylo skonstruowanie zdania po jego przechwyceniu : "Dlugosc pierwszego wektora to AA a drugiego to BB). Jezeli sa rownej dlugosci, wynik dodawania zapisywany jest do pliku. Jezeli nie sa rownej dlugosci, uzytkownik jest proszony o ponowne wprowadzenie tych wektorow. <br />
7. Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable. 
Nastepnie utworz abstrakcyjna klase Wpis a nastepnie dziedziczace z niej klasy Osoba i Firma. 
Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis. 
Byc moze ma rowniez inne metody abstrakcyjne lub nie w miare potrzeb. 
Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu).
Klasa Firma ma miec nazwe i adres( w tym NrTelefonu). Utworz kilka obiektow klasy Osoba i kilka obiektow klasy Firma i umiesc je w kontenerze TreeMap,
poslugujac sie jako kluczem numerem telefonicznym. Nastepnie wypisz utworzona w ten sposob ksiazke telefoniczna za pomoca iteratora.


Polecenia PAI:
1. Napisz program, ktory pobiera liste plikow z linii polecen i wyswietla liczbe wierszy kazdego z nich. 
Program powinien utworzyc jeden watek dla kazdego z plikow i uzyc tych watkow do zliczenia liczby wierszy kazdego z plikow rownoczenie.
Utworz wersje programu, ktora odczytuje pliki nie jednoczesnie a sekwencyjnie. <br />
Porownaj wydajnosc wielowatkowego i jednowatkowego programu uzywajac System.currentTimeMillis() do okreslenia czasu wykonania.
Porownania dokonaj dla dwoch, trzech i pieciu plikow.<br />
2.Napisz program laczacy sie ze strona podana jako argument wywolania programu i wypisujacy wszystkie znalezione na niej linki i adresy email wykorzystujac w tym celu wyrazenia regularne (pakiet java.util.regex). Oprocz tego program ma zapisac do pliku wszystkie parametry polaczenia, adres IP komputera na ktorym znajduje sie strona oraz naglowek strony (zawartosc sekcji <head>). <br />
3. Echo klient i echo serwer wielowatkowy <br />
4. Opracuj drzewo przeszukiwan binarnych przechowujace wartosci jakiegos typu (zaproponuj ten typ: np. samochod, budynek, zegarek). Algorytm porownujacy ma byc dostarczany w formie interfejsu Comparable bądz Comparator. Zaproponuj takie dwa algorytmy oparte o te dwa interfejsy. Algorytmy powinny byc nieoczywiste - nie powinny bazowac wylacznie na liczbach, datach czy kolejnosci alfabetycznej.  Rozwiazanie powinno uwzgledniac:<br />
- generowanie przykladowego drzewa skladajacego sie z co najmniej 30 elementow zgodnie z podanymi regulami sortowania wynikajacymi z algorytmu Comparable badz Comparator<br />
- tworzenie pustego drzewa,<br />
- dodawanie/usuwanie elementu do/z drzewa,<br />
- wypisywanie w kolejnosci rosnacej zawartosci drzewa.<br />


