import java.util.Scanner;

public class Magazin {
    private static int maximProduse = 10;
    private Produs[] produse = new Produs[maximProduse];
    private int nrProduse = 0;
    Scanner scanner = new Scanner(System.in);

    public void adaugaProdus()
    {
        if (nrProduse >= maximProduse)
        {
            System.out.println("Inventar plin!");
            return;
        }

        System.out.print("Introdu numele produsului: ");
        String nume = scanner.nextLine();

        System.out.print("Introdu pretul produsului: ");
        double pret = scanner.nextDouble();

        System.out.print("Introdu cantitatea in stoc: ");
        int stoc = scanner.nextInt();
        scanner.nextLine();

        produse[nrProduse] = new Produs(nume, pret, stoc);
        nrProduse++;
        System.out.println("Produsul adaugat cu succes!");
    }

    public void afiseazaProduse()
    {
        if (nrProduse == 0)
        {
            System.out.println("Nu exista produse in inventar.");
        }
        else
        {
            System.out.println("\nProduse in inventar:");
            for (int i = 0; i < nrProduse; i++)
            {
                System.out.print((i + 1) + ". ");
                produse[i].afiseazaDetalii();
            }
        }
    }

    public void cautaProdusDupaNume()
    {
        if (nrProduse == 0)
        {
            System.out.println("Nu exista produse in inventar.");
            return;
        }

        System.out.print("Introdu numele produsului: ");
        String numeCautat = scanner.nextLine();

        boolean gasit = false;
        for (int i = 0; i < nrProduse; i++)
        {
            if (produse[i].getNume().equalsIgnoreCase(numeCautat))
            {
                System.out.println("Produsul gasit:");
                produse[i].afiseazaDetalii();
                gasit = true;
                break;
            }
        }

        if (!gasit)
        {
            System.out.println("Nu exista niciun produs cu numele cautat.");
        }
    }

    public void afiseazaProduseScumpe()
    {
        if (nrProduse == 0)
        {
            System.out.println("Nu exista produse in inventar.");
            return;
        }

        System.out.print("Introdu pretul minim: ");
        double pretMinim = scanner.nextDouble();
        scanner.nextLine();

        boolean gasit = false;
        System.out.println("Produse cu pret peste " + pretMinim + " RON:");
        for (int i = 0; i < nrProduse; i++)
        {
            if (produse[i].getPret() > pretMinim)
            {
                produse[i].afiseazaDetalii();
                gasit = true;
            }
        }

        if (!gasit)
        {
            System.out.println("Nu exista produse mai scumpe decat " + pretMinim + " RON.");
        }
    }

    public void ajusteazaStocProdus()
    {
        if (nrProduse == 0)
        {
            System.out.println("Nu exista produse.");
            return;
        }

        afiseazaProduse();
        System.out.print("Alege numarul produsului: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < nrProduse)
        {
            System.out.print("Introdu noua cantitate in stoc: ");
            int nouStoc = scanner.nextInt();
            scanner.nextLine();

            produse[index].setStoc(nouStoc);
            System.out.println("Stoc actualizat cu succes!");
        }
        else
        {
            System.out.println("Index invalid.");
        }
    }

    public void vindeProdus()
    {
        if (nrProduse == 0)
        {
            System.out.println("Nu exista produse.");
            return;
        }

        afiseazaProduse();
        System.out.print("Alege numarul produsului pe care vrei să il vinzi: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < nrProduse)
        {
            System.out.print("Introdu cantitatea de vandut: ");
            int cantitate = scanner.nextInt();
            scanner.nextLine();

            if (cantitate > produse[index].getStoc())
            {
                System.out.println("Cantitate insuficientă în stoc.");
            }
            else
            {
                produse[index].setStoc(produse[index].getStoc() - cantitate);
                System.out.println("Ai vandut " + cantitate + " bucati de " + produse[index].getNume() + ".");
            }
        }
        else
        {
            System.out.println("Index invalid.");
        }
    }
}

