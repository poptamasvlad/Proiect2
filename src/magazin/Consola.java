package magazin;

public class Consola extends magazin.Produs {
    private int stocare;
    private String generatie;

    public Consola(String nume, double pret, int stoc, int stocare, String generatie) {
        super(nume, pret, stoc);
        this.stocare = stocare;
        this.generatie = generatie;
    }

    public int getStocare() {
        return stocare;
    }

    public String getGeneratie() {
        return generatie;
    }

    @Override
    public String toString() {
        return super.toString() + ", Stocare: " + stocare + " GB, Generatie: " + generatie;
    }
}
