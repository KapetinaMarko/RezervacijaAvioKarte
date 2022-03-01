package rajvosa_airlines;

//Klasa Let koja sadrzi navedene atribute razlicitih tipova
public class Let {
    private int brojLeta;
    private String polaziste;
    private String odrediste;
    private String vrijemePolijetanja;
    private int kapacitet;
    private int brojDostupnihSjedista;
    private double cijena;

//Konstruktor koji prima 6 parametara i inicijalizira objekat klase Let
    public Let(int brLeta, String polaziste, String odrediste, String vrijemePolijetanja, int kapacitet, double cijena) {
        this.brojLeta = brLeta;
        this.polaziste = polaziste;
        this.odrediste = odrediste;
        this.vrijemePolijetanja = vrijemePolijetanja;
        this.kapacitet = kapacitet;
        this.brojDostupnihSjedista = kapacitet;
        this.cijena = cijena;
    }
//Metoda kupiKartu koja vraca true/false u zavisnosti da li ima slobodnih sjedista u avionu
    public boolean kupljenaKarta() {
        if (brojDostupnihSjedista > 0) {
            brojDostupnihSjedista--;
            return true;
        }
        return false;
    }

    public double getCijena() {
        return this.cijena;
    }

    public String getPolaziste() {
        return this.polaziste;
    }

    public String getOdrediste() {
        return this.odrediste;
    }

    public String getVrijemePolijetanja() {
        return this.vrijemePolijetanja;
    }

    public int getBrojLeta() {
        return this.brojLeta;
    }

    public int getBrojDostupnihSjedista() {
        return this.brojDostupnihSjedista;
    }

    public int getKapacitet() {
        return this.kapacitet;
    }
//Set metoda koja postavlja vrijednost cijene karte na vrijednost proslijedjenog parametra
    public void setCijena(double c) {
        this.cijena = c;
    }

    public void setPolaziste(String p) {
        this.polaziste = p;
    }

    public void setOdrediste(String o) {
        this.odrediste = o;
    }

    public void setVrijemePolijetanja(String vrijeme) {
        this.vrijemePolijetanja = vrijeme;
    }

    public void setBrojLeta(int brLeta) {
        this.brojLeta = brLeta;
    }

    public void setBrojDostupnihSjedista(int brSjedista) {
        this.brojDostupnihSjedista = brSjedista;
    }

    public void setKapacitet(int k) {
        this.kapacitet = k;
    }
//Preklopljena verzija metode toString koja omogucava ispis u zeljenom formatu
    @Override
    public String toString() {
        return "Let " + this.brojLeta + ", " + this.polaziste + "-" + this.odrediste + ", " + this.vrijemePolijetanja + ", cijena karte: " + this.cijena + "KM.";
    }
}
