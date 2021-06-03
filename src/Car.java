public class Car {
    private final int marca;
    private int kms;
    private int minutes;

    public Car(int marca, int kms, int minutes) {
        this.marca = marca;
        this.kms = kms;
        this.minutes = minutes;
    }

    public int getMarca() {
        return marca;
    }

    public int getKms() {
        return kms;
    }

    public int getMinutes() {
        return minutes;
    }
}
