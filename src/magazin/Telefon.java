package magazin;

public class Telefon extends magazin.Produs {
    private String sistemOperare;
    private String model;

    public Telefon(String nume, double pret, int stoc, String sistemOperare, String model) {
        super(nume, pret, stoc);
        this.sistemOperare = sistemOperare;
        this.model = model;
    }

    public String getSistemOperare() {
        return sistemOperare;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sistem de operare: " + sistemOperare + ", Model: " + model;
    }
}
