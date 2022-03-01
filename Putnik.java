package rajvosa_airlines;

//Klasa Putnik koja sadrzi dva atributa tipa String (ime i prezime)
public class Putnik {
    private String ime;
    private String prezime;

//Konstruktor koji prima dva parametra i inicijalizira ime i prezime na proslijedjene vrijednosti
    public Putnik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }
//Metoda za dobavljanje imena putnika
    public String getIme(){
        return this.ime;
    }

    public String getPrezime(){
        return this.prezime;
    }
}
