package magazin;

public class PC extends magazin.Produs {
    private String procesor;
    private int memorieRAM;
    private int stocare;

    public PC(String nume, double pret, int stoc, String procesor, int memorieRAM, int stocare) {
        super(nume, pret, stoc);
        this.procesor = procesor;
        this.memorieRAM = memorieRAM;
        this.stocare = stocare;
    }

    public String getProcesor() {
        return procesor;
    }

    public int getMemorieRAM() {
        return memorieRAM;
    }

    @Override
    public String toString() {
        return super.toString() + ", Procesor: " + procesor + ", Memorie RAM: " + memorieRAM + " GB, Stocare: " + stocare + " GB";
    }

}
