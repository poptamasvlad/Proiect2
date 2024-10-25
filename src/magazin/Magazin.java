package magazin;

import java.util.ArrayList;

public class Magazin {
    private ArrayList<magazin.Produs> produse;

    public Magazin() {
        produse = new ArrayList<>();
    }

    public void adaugaProdus(magazin.Produs produs) {
        produse.add(produs);
    }

    public ArrayList<magazin.Produs> getProduse() {
        return produse;
    }

}
