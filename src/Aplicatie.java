import java.util.Scanner;

public class Aplicatie {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;

        while (optiune != 7)
        {
            System.out.println("\n Meniu Magazin");
            System.out.println("1. Adauga un produs");
            System.out.println("2. Afișeaza toate produsele");
            System.out.println("3. Ajusteaza stocul unui produs");
            System.out.println("4. Vinde un produs");
            System.out.println("5. Cauta un produs dupa nume");
            System.out.println("6. Afișeaza produsele scumpe");
            System.out.println("7. Ieșire");
            System.out.print("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    magazin.adaugaProdus();
                    break;
                case 2:
                    magazin.afiseazaProduse();
                    break;
                case 3:
                    magazin.ajusteazaStocProdus();
                    break;
                case 4:
                    magazin.vindeProdus();
                    break;
                case 5:
                    magazin.cautaProdusDupaNume();
                    break;
                case 6:
                    magazin.afiseazaProduseScumpe();
                    break;
                case 7:
                    System.out.println("Iesire din aplicatie.");
                    break;
                default:
                    System.out.println("Optiune invalida! Încearca din nou.");
            }
        }

        scanner.close();
    }
}

