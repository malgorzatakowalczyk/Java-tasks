Zadania na zajęcia Programowanie Obiektowe 2 i Projektowanie Aplikcacji Internetowych 
Polecenia PO2 
1. Napisz program czytajacy argumenty wywolania programu i konwertujacy je do Integer. 
Zmodyfikuj program w ten sposob, aby kolejne argumenty byly wspolczynikami wielomianu postaci Ax2+Bx+C=0. Policz pierwiastki tego wielomianu.
2.Napisz program, ktory pobiera dwie liczby oraz lancuch znakow z wiersza polecen oraz wyswietla fragment podanego lancucha okreslony wprowadzonymi liczbami. Na przyklad:
java Substring Witaj 2 4
powinien wyswietlic:
taj
Obsluz wszystkie mozliwe wyjatki, ktore moga wystapic w przypadku zlego zestawu argumentow.
3. Napisz program losujacy liczbe z zakresu 0-100. Nastepnie program pyta sie uzytkownika, co to za liczba. 
Jezeli uzytkownik nie zgadl, dowiaduje sie czy wylosowana liczba jest wieksza czy mniejsza od podanej. 
Jezeli zgadl, dowiaduje sie ile wykonal prob i jest pytany o ochote do dalszej gry.
4. Napisz program losujacy 1000 znakow i zapisz je do pliku, a nastepnie odczytaj pliku i wypisz na ekran. 
Utworz dwie rozne pary procedur zapisujaco/odczytujacych, raz korzystajac z pakietu java.io a drugi raz z pakietu java.nio.
Porownaj szybkosc zapisu i odczytu, wynik wypisz na ekranie.
5. Napisz program odczytujacy zawartosc pliku tekstowego. Sciezka do pliku powinna byc podawana przez uzytkownika po uruchomieniu programu oraz zapisywana do osobnego pliku.
Po nacisniÄciu dowolnego klawisza program pobiera kolejny ciÄg znakow o losowej dlugosci (od 1 do 5 znakow) z wczytanego pliku tekstowego i wyswietla go na ekranie.
6. Napisz program proszacy o podanie 2 wektorow (wektor to ciag liczb). Koniec wektora oznacza sie za pomoca wcisniecia klawisza enter. 
7. Jezeli podany ciag nie jest liczba, jest ignorowany. Nastepnie nalezy sprobowac dodac wektory, jezeli sa rownej dlugosci. 
Jezeli nie, sa, rzucany jest wlasny wyjatek WektoryRoznejDlugosciException, za pomoca ktorego mozna podac a nastepnie odczytac dlugosci tych wektorow (nalezy tak skonstruowac wyjatek, aby mozliwe bylo skonstruowanie zdania po jego przechwyceniu : "Dlugosc pierwszego wektora to AA a drugiego to BB). Jezeli sa rownej dlugosci, wynik dodawania zapisywany jest do pliku. Jezeli nie sa rownej dlugosci, uzytkownik jest proszony o ponowne wprowadzenie tych wektorow.
Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable. 
Nastepnie utworz abstrakcyjna klase Wpis a nastepnie dziedziczace z niej klasy Osoba i Firma. 
Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis. 
Byc moze ma rowniez inne metody abstrakcyjne lub nie w miare potrzeb. 
Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu).
Klasa Firma ma miec nazwe i adres( w tym NrTelefonu). Utworz kilka obiektow klasy Osoba i kilka obiektow klasy Firma i umiesc je w kontenerze TreeMap,
poslugujac sie jako kluczem numerem telefonicznym. Nastepnie wypisz utworzona w ten sposob ksiazke telefoniczna za pomoca iteratora.


Polecenia PAI:
1. Napisz program, ktory pobiera liste plikow z linii polecen i wyswietla liczbe wierszy kazdego z nich. 
Program powinien utworzyc jeden watek dla kazdego z plikow i uzyc tych watkow do zliczenia liczby wierszy kazdego z plikow rownoczenie.
Utworz wersje programu, ktora odczytuje pliki nie jednoczesnie a sekwencyjnie.
Porownaj wydajnosc wielowatkowego i jednowatkowego programu uzywajac System.currentTimeMillis() do okreslenia czasu wykonania.
Porownania dokonaj dla dwoch, trzech i pieciu plikow.
