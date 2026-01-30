package no.hvl.dat102.filmarkiv.impl;

import java.util.Objects;

public class Film {

    private int filmnummer;
    private String filmskaper;
    private String tittel;
    private int utgivelsesaar;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {
    }

    public Film(int filmnummer, String filmskaper, String tittel, int utgivelsesaar, Sjanger sjanger, String filmselskap) {
        this.filmnummer = filmnummer;
        this.filmskaper = filmskaper;
        this.tittel = tittel;
        this.utgivelsesaar = utgivelsesaar;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    // Get- og set-metoder
    public int getFilmnummer() {
        return filmnummer;
    }

    public void setFilmnummer(int filmnummer) {
        this.filmnummer = filmnummer;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getUtgivelsesaar() {
        return utgivelsesaar;
    }

    public void setUtgivelsesaar(int utgivelsesaar) {
        this.utgivelsesaar = utgivelsesaar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    // To filmer er like om de har samme nummer [cite: 40]
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnummer == film.filmnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnummer);
    }
}