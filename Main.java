package rajvosa_airlines;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Korisnik K = new Korisnik();
        Let L;
        Putnik P;
        Scanner scanner = new Scanner(System.in);
        String unos, polaziste, odrediste, ime, prezime;
        int brojLeta;
        boolean pomocna = false;

        while (!pomocna) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Program za rezervaciju karata aviokompanije RajvoSa Airlines");
            System.out.println("Unesite K ako zelite kreirati let.");
            System.out.println("Unesite L ako zelite prikazati sve letove za zeljene destinacije.");
            System.out.println("Unesite I ako zelite informacije o letu.");
            System.out.println("Unesite R ako zelite rezervisati kartu za odredjeni let.");
            System.out.println("Unesite X ako zelite izaci iz programa.");
            System.out.println("---------------------------------------------------------------------------");
            unos = scanner.nextLine();
            switch (unos) {
                case "K":
                    K.kreirajLet();
                    break;
                case "L":
                    System.out.println("Unesite polaziste: ");
                    polaziste = scanner.nextLine();
                    System.out.println("Unesite odrediste: ");
                    odrediste = scanner.nextLine();
                    K.prikaziDostupneLetove(polaziste, odrediste);
                    break;
                case "I":
                    System.out.println("Unesite broj leta: ");
                    brojLeta = Integer.valueOf(scanner.nextLine());
                    L = K.getLet(brojLeta);
                    if (L == null) {
                        System.out.println("Let " + brojLeta + " ne postoji.");
                    } else {
                        System.out.println("Informacije o letu " + brojLeta + ": ");
                        System.out.println(L);
                    }
                    break;
                case "R":
                    System.out.println("Unesite ime putnika: ");
                    ime = scanner.nextLine();
                    System.out.println("Unesite prezime putnika: ");
                    prezime = scanner.nextLine();
                    System.out.println("Unesite broj leta: ");
                    brojLeta = Integer.valueOf(scanner.nextLine());
                    P = new Putnik(ime, prezime);
                    K.kupiKartu(brojLeta, P);
                    break;
                case "X":
                    pomocna = true;
                    System.out.println("Izasli ste iz programa.");
                    break;
                default:
                    System.out.println("Nepravilan unos (unesite opcije K, L I, R ili X).");
                    break;
            }

        }

    }
}
