package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaza garaza = null;
        int choice;

        do {
            System.out.println("Dobrodošli! Odaberite opciju:");
            System.out.println("1. Kreiraj garažu");
            System.out.println("2. Parkiraj auto");
            System.out.println("3. Broj slobodnih mjesta po spratu");
            System.out.println("4. Trenutna zarada parkinga");
            System.out.println("5. Kraj");
            System.out.print("Unesite broj opcije: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (garaza == null) {
                        garaza = kreirajGarazu(scanner);
                        System.out.println("Garaža je uspješno kreirana.");
                    } else {
                        System.out.println("Garaža je već kreirana.");
                    }
                    break;

                case 2:
                    if (garaza != null) {
                        parkirajAuto(garaza, scanner);
                    } else {
                        System.out.println("Garaža nije kreirana. Molimo prvo kreirajte garažu.");
                    }
                    break;

                case 3:
                    if (garaza != null) {
                        prikaziBrojSlobodnihMjestaPoSpratu(garaza, scanner);
                    } else {
                        System.out.println("Garaža nije kreirana. Molimo prvo kreirajte garažu.");
                    }
                    break;

                case 4:
                    if (garaza != null) {
                        prikaziTrenutnuZaradu(garaza);
                    } else {
                        System.out.println("Garaža nije kreirana. Molimo prvo kreirajte garažu.");
                    }
                    break;

                case 5:
                    System.out.println("Hvala što koristite našu aplikaciju. Doviđenja!");
                    break;

                default:
                    System.out.println("Nevažeća opcija. Molimo odaberite ponovo.");
                    break;
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }

    public static Garaza kreirajGarazu(Scanner scanner) {
        System.out.print("Unesite naziv garaže: ");
        String naziv = scanner.nextLine();
        System.out.print("Unesite lokaciju garaže: ");
        String lokacija = scanner.nextLine();
        System.out.print("Unesite broj spratova garaže: ");
        int brojSpratova = scanner.nextInt();
        scanner.nextLine();

        List<Sprat> spratovi = new ArrayList<>();
        for (int i = 1; i <= brojSpratova; i++) {
            Sprat sprat = kreirajSprat(i, scanner);
            spratovi.add(sprat);
        }

        return new Garaza(naziv, lokacija, spratovi);
    }

    public static Sprat kreirajSprat(int brojSprata, Scanner scanner) {
        System.out.print("Unesite broj parking mjesta za sprat " + brojSprata + ": ");
        int brojMjesta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Unesite cijenu parkinga za sprat " + brojSprata + ": ");
        double cijena = scanner.nextDouble();
        scanner.nextLine();

        List<Mjesto> mjesta = new ArrayList<>();
        for (int i = 1; i <= brojMjesta; i++) {
            Mjesto mjesto = new Mjesto(i, Status.SLOBODNO);
            mjesta.add(mjesto);
        }

        return new Sprat(brojSprata, mjesta, cijena);
    }

    public static void parkirajAuto(Garaza garaza, Scanner scanner) {
        System.out.print("Unesite broj sprata na kojem želite parkirati auto: ");
        int brojSprata = scanner.nextInt();
        scanner.nextLine();

        if (brojSprata < 1 || brojSprata > garaza.getBrojSpratova()) {
            System.out.println("Nevažeći broj sprata. Molimo odaberite ponovo.");
            return;
        }

        Sprat sprat = garaza.getSpratovi().get(brojSprata - 1);
        List<Mjesto> slobodnaMjesta = new ArrayList<>();
        for (Mjesto mjesto : sprat.getMjesta()) {
            if (mjesto.getStatus() == Status.SLOBODNO) {
                slobodnaMjesta.add(mjesto);
            }
        }

        if (slobodnaMjesta.isEmpty()) {
            System.out.println("Na odabranom spratu nema slobodnih mjesta.");
        } else {
            System.out.println("Slobodna mjesta na spratu " + brojSprata + ":");
            for (Mjesto mjesto : slobodnaMjesta) {
                System.out.println("Mjesto " + mjesto.getBrojMjesta());
            }

            System.out.print("Unesite broj željenog mjesta: ");
            int brojMjesta = scanner.nextInt();
            scanner.nextLine();

            Mjesto odabranoMjesto = null;
            for (Mjesto mjesto : slobodnaMjesta) {
                if (mjesto.getBrojMjesta() == brojMjesta) {
                    odabranoMjesto = mjesto;
                    break;
                }
            }

            if (odabranoMjesto != null) {
                odabranoMjesto.setStatus(Status.ZAUZETO);
                System.out.println("Auto je parkiran na mjestu " + odabranoMjesto.getBrojMjesta() + ".");
            } else {
                System.out.println("Nevažeći broj mjesta. Molimo odaberite ponovo.");
            }
        }
    }

    public static void prikaziBrojSlobodnihMjestaPoSpratu(Garaza garaza, Scanner scanner) {
        System.out.print("Unesite broj sprata: ");
        int brojSprata = scanner.nextInt();
        scanner.nextLine();

        if (brojSprata < 1 || brojSprata > garaza.getBrojSpratova()) {
            System.out.println("Nevažeći broj sprata. Molimo odaberite ponovo.");
            return;
        }

        Sprat sprat = garaza.getSpratovi().get(brojSprata - 1);
        int brojSlobodnihMjesta = 0;
        for (Mjesto mjesto : sprat.getMjesta()) {
            if (mjesto.getStatus() == Status.SLOBODNO) {
                brojSlobodnihMjesta++;
            }
        }

        System.out.println("Broj slobodnih mjesta na spratu " + brojSprata + ": " + brojSlobodnihMjesta);
    }

    public static void prikaziTrenutnuZaradu(Garaza garaza) {
        double zarada = 0.0;
        for (Sprat sprat : garaza.getSpratovi()) {
            for (Mjesto mjesto : sprat.getMjesta()) {
                if (mjesto.getStatus() == Status.ZAUZETO) {
                    zarada += sprat.getCijena();
                }
            }
        }

        System.out.println("Trenutna zarada parkinga: " + zarada);
    }
}

