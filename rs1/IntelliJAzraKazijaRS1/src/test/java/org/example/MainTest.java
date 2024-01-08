import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public static void main(String[] args) {

        Garaza garaza = kreirajTestGarazu();
        System.out.println("Naziv garaže: " + garaza.getNaziv());
        System.out.println("Lokacija garaže: " + garaza.getLokacija());
        System.out.println("Broj spratova garaže: " + garaza.getBrojSpratova());


        Scanner scanner = new Scanner(System.in);
        parkirajAuto(garaza, scanner);


        prikaziBrojSlobodnihMjestaPoSpratu(garaza, scanner);


        prikaziTrenutnuZaradu(garaza);

        scanner.close();
    }

    public static Garaza kreirajTestGarazu() {
        String naziv = "Test garaža";
        String lokacija = "Test lokacija";
        int brojSpratova = 3;

        List<Sprat> spratovi = new ArrayList<>();
        for (int i = 1; i <= brojSpratova; i++) {
            Sprat sprat = kreirajTestSprat(i);
            spratovi.add(sprat);
        }

        return new Garaza(naziv, lokacija, spratovi);
    }

    public static Sprat kreirajTestSprat(int brojSprata) {
        int brojMjesta = 10;
        double cijena = 5.0;

        List<Mjesto> mjesta = new ArrayList<>();
        for (int i = 1; i <= brojMjesta; i++) {
            Mjesto mjesto = new Mjesto(i, Status.SLOBODNO);
            mjesta.add(mjesto);
        }

        return new Sprat(brojSprata, mjesta, cijena);
    }
}