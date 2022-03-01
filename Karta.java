package rajvosa_airlines;

public class Karta {
    //instance klasi Let i Putnik kao atributi klase Karta
    private Let let;
    private Putnik putnik;
    private double cijena;
    private int brojKarte;
    private int brojac = 0;

    public Karta(Let l, Putnik p, double c) {
        this.brojac++;
        this.let = l;
        this.putnik = p;
        this.cijena = c;
        this.brojKarte = brojac;
    }

    @Override
    public String toString() {
        return this.putnik.getIme() + " " + this.putnik.getPrezime() + ", let " + this.let.getBrojLeta() + ", " + this.let.getPolaziste() + "-" + this.let.getOdrediste() + ", " + this.let.getVrijemePolijetanja() + ", cijena karte: " + this.let.getCijena() + "KM.";
    }

    public Let getLet() {
        return this.let;
    }

    public void setLet(Let L) {
        this.let = L;
    }

    public Putnik getPutnik() {
        return this.putnik;
    }

    public void setPutnik(Putnik P) {
        this.putnik = P;
    }

    public double getCijena() {
        return this.cijena;
    }

    public void setCijena(double C) {
        this.cijena = C;
    }

    public int getBrojKarte() {
        return this.brojKarte;
    }

    public void setBrojKarte(int br) {
        this.brojKarte = br;
    }

    public int getBrojac() {
        return this.brojac;
    }

    public void setBrojac(int n) {
        this.brojac = n;
    }
}
