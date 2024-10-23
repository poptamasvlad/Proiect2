public class Produs {
    private String nume;
    private double pret;
    private int stoc;

    public Produs(String nume, double pret, int stoc)
    {
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getNume()
    {
        return nume;
    }

    public double getPret()
    {
        return pret;
    }

    public int getStoc()
    {
        return stoc;
    }

    public void setStoc(int stoc)
    {
        this.stoc = stoc;
    }

    public void afiseazaDetalii()
    {
        System.out.println("Produs: " + nume + ", Preț: " + pret + " RON, Stoc: " + stoc);
    }
}

