package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Film implements FilmarkivADT {

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

    public void setFilmnummer(int filmnummer) {
        this.filmnummer = filmnummer;
    }

    public int getFilmnummer() {
        return filmnummer;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getTittel() {
        return tittel;
    }

    public void setUtgivelsesaar(int utgivelsesaar) {
        this.utgivelsesaar = utgivelsesaar;
    }

    public int getUtgivelsesaar() {
        return utgivelsesaar;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    @Override
    public Film finnFilm(int nr) {
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}