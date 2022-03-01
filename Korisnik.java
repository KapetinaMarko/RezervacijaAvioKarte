package rajvosa_airlines;

//Ukljucivanje ugradjenih biblioteka za rad sa ArrayListama i omogucavanje interakcije korisnika sa programom unosenjem podataka sa tastature
import java.util.ArrayList;
import java.util.Scanner;

//Klasa Korisnik koja sadrzi dva atributa tipa ArrayList
public class Korisnik {
    ArrayList<Let> letovi;
    ArrayList<Karta> karte;

    public Korisnik() {
        this.letovi = new ArrayList<Let>();
        this.karte = new ArrayList<Karta>();
    }

    //Metoda bez parametara koja "ne vraca nista" a sluzi za kreiranje leta koristeci unesene podatke sa tastature
    public void kreirajLet() {
        int brLeta, kapacitet;
        double cijena;
        String polaziste, odrediste, vrijemePolijetanja;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite broj leta: ");
        brLeta = Integer.valueOf(scanner.nextLine());
        System.out.println("Unesite polaziste: ");
        polaziste = scanner.nextLine();
        System.out.println("Unesite zeljeno odrediste: ");
        odrediste = scanner.nextLine();
        System.out.println("Unesite datum i vrijeme polaska: ");
        vrijemePolijetanja = scanner.nextLine();
        System.out.println("Unesite kapacitet leta: ");
        kapacitet = Integer.valueOf(scanner.nextLine());
        System.out.println("Unesite cijenu karte: ");
        cijena = Double.valueOf(scanner.nextLine());
        //Kreira se instanca objekta klase Let dinamickom alokacijom memorije
        Let L = new Let(brLeta, polaziste, odrediste, vrijemePolijetanja, kapacitet, cijena);
        //Dodavanje kreiranog leta u listu letova
        letovi.add(L);
        System.out.println("Let je kreiran.");
        System.out.println(L);
    }

    //Metoda koja prikazuje dostupne letove izmedju odabranih destinacija
    public void prikaziDostupneLetove(String polaziste, String odrediste) {
        int duzinaListe, sjedista;
        boolean pomocna = true;
        String p, o;
        duzinaListe = letovi.size();
        for (int i = 0; i < duzinaListe; i++) {
            p = letovi.get(i).getPolaziste();
            o = letovi.get(i).getOdrediste();
            sjedista = letovi.get(i).getBrojDostupnihSjedista();
            //Provjera da li ima letova sa trazenim polazistem i odredistem uz uslov da ima slobodnih sjedista na letu
            if ((p.equals(polaziste)) && (o.equals(odrediste)) && sjedista > 0) {
                if (pomocna==true) {
                    System.out.println("Lista dostupnih letova: ");
                    pomocna = false;
                }
                System.out.println(letovi.get(i));
            }
        }
        if (pomocna==true) {
            System.out.println("Nema dostupnih letova.");
        }
    }

    //Metoda getLet koja vraca objekat klase Let a prima brojLeta kao parametar
    public Let getLet(int brojLeta) {
        int duzinaListe = letovi.size();
        for (int i = 0; i < duzinaListe; i++) {
            if (letovi.get(i).getBrojLeta() == brojLeta) {
                return letovi.get(i);
            }
        }
        return null;
    }

    public void kupiKartu(int brojLeta, Putnik p) {
        int duzinaListe = letovi.size();
        boolean imaLeta = false;
        int indeks = 0, sjedista;
        for (int i = 0; i < duzinaListe; i++) {
            //Provjera da li lista sadrzi let za koji zelimo kupiti kartu
            if (letovi.get(i).getBrojLeta() == brojLeta) {
                imaLeta = true;
                indeks = i;
                break;
            }
        }
        double cijena;
        //Broj dostupnih sjedista na odgovarajucem letu
        sjedista = letovi.get(indeks).getBrojDostupnihSjedista();
        //Ako postoji trazeni let sa slobodnim sjedistima vrsimo rezervaciju karte za isti
        if (imaLeta==true && (sjedista > 0)) {
            letovi.get(indeks).kupljenaKarta();
            cijena = letovi.get(indeks).getCijena();
            //Inicijalizacija objekta tipa Karta
            Karta karta = new Karta(letovi.get(indeks), p, cijena);
            //Dodavanje karte u listu karata
            karte.add(karta);
            System.out.println("Uspjesno ste rezervisali mjesto na zeljenom letu " + brojLeta);
            System.out.println("Karta: " + karta);

        } else {
            //Postoji let ali na njemu nema slobodnih sjedista
            if (imaLeta==true && sjedista == 0) {
                System.out.println("Let " + brojLeta + " je popunjen i ne mozete rezervisati kartu.");
            //Let uopste ne postoji
            } else if (imaLeta==false) {
                System.out.println("Let " + brojLeta + " ne postoji.");
            }
        }
    }
}
