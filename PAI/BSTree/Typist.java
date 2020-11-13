
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class Typist implements Comparable<Typist> {

    String name;
    String surname;
    String fileName;
    int timeInSeconds;
    Keyboard keyboard;
    public  Typist left, right, parent;

    public Typist(String name, String surname, String fileName, int timeInSeconds, Keyboard keyboard) {
        this.name = name;
        this.surname = surname;
        this.fileName = fileName;
        this.timeInSeconds = timeInSeconds;
        this.keyboard = keyboard;
        left = null;
        right = null;
        parent = null;

    }

    @Override
    public int compareTo(Typist osoba) {
        if (finalPoints(osoba.fileName, osoba.timeInSeconds) > finalPoints(fileName, timeInSeconds)) {
            return 1;
        } else if (finalPoints(osoba.fileName, osoba.timeInSeconds) < finalPoints(fileName, timeInSeconds)) {
            return -1;
        }
        return 0;

    }

    public float pointsForText(String fileName) {
        float pointsForSigns = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String input = "";
            while ((input = reader.readLine()) != null) {
                for (int k = 0; k < input.length(); k++) {

                    char znak = input.charAt(k);
                    if (Character.isUpperCase(znak)) {
                        pointsForSigns += 0.25;
                    }
                    pointsForSigns++;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pointsForSigns;
    }

    public float finalPoints(String fileName, int timeInSeconds) {
        float allPoints = pointsForText(fileName) / timeInSeconds;
        return allPoints;
    }

    void print() {
        System.out.println(name + " " + surname);
    }

    void printFinalPoints() {
        System.out.println(finalPoints(fileName, timeInSeconds));
    }
}

class PersonWithTheBestKeyboard implements Comparator<Typist> {

    double averageRating(Typist fPerson) {
        double averageCustomerRaiting = fPerson.keyboard.averageCustomerRaiting;
        double avergageRatingOfSpecialists = fPerson.keyboard.avergageRatingOfSpecialists;
        return (averageCustomerRaiting + avergageRatingOfSpecialists) / 2;
    }

    @Override
    public int compare(Typist firstPerson, Typist secondPerson) {
        if (firstPerson.keyboard.keyboardType.ordinal() > secondPerson.keyboard.keyboardType.ordinal()) {
            return 1;
        } else if (firstPerson.keyboard.keyboardType.ordinal() < secondPerson.keyboard.keyboardType.ordinal()) {
            return -1;
        } else {
            if (averageRating(firstPerson) < averageRating(secondPerson)) {
                return 1;
            } else if (averageRating(firstPerson) > averageRating(secondPerson)) {
                return -1;
            } else {
                if (firstPerson.keyboard.price < secondPerson.keyboard.price) {
                    return 1;
                } else if (firstPerson.keyboard.price > secondPerson.keyboard.price) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
