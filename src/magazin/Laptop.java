package magazin;

public class Laptop extends magazin.Produs {
    private double greutate;
    private int autonomie;

    public Laptop(String nume, double pret, int stoc, double greutate, int autonomie) {
        super(nume, pret, stoc);
        this.greutate = greutate;
        this.autonomie = autonomie;
    }

    public double getGreutate() {
        return greutate;
    }

    public int getAutonomie() {
        return autonomie;
    }

    @Override
    public String toString() {
        return super.toString() + ", Greutate: " + greutate + " kg, Autonomie: " + autonomie + " ore";
    }
}
