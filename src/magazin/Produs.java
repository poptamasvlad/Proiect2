package magazin;

public abstract class Produs {
    private String nume;
    private double pret;
    private int stoc;

    public Produs(String nume, double pret, int stoc) {
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public int getStoc() {
        return stoc;
    }

    @Override
    public String toString() {
        return "Nume: " + nume + ", Pret: " + pret + ", Stoc: " + stoc;
    }
}
