
enum Type {
    MECHANICAL,
    HYBRID,
    MEMBRANE
}

class Keyboard {

    Type keyboardType;
    double averageCustomerRaiting;
    double avergageRatingOfSpecialists;
    double price;

    Keyboard(Type typ, double averageCustomerRaiting, double avergageRatingOfSpecialists, double price) {
        this.keyboardType = typ;
        this.averageCustomerRaiting = averageCustomerRaiting;
        this.avergageRatingOfSpecialists = avergageRatingOfSpecialists;
        this.price = price;
    }

    void print() {
        System.out.println("Typ:" + keyboardType + " Średnia: " + (averageCustomerRaiting + avergageRatingOfSpecialists) / 2 + " Cena: " + price + "PLN");
    }
}
