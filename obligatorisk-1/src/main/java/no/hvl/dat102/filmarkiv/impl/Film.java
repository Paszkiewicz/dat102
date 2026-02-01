package no.hvl.dat102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String filmskaper;
    private String filmtittel;
    private int filmlansering;
    private Sjanger filmsjanger;
    private String filmnavn;

    public Film() {}

    public Film(int filmnr, String filmskaper, String filmtittel, int filmlansering, Sjanger filmsjanger, String filmnavn) {
        this.filmnr = filmnr;
        this.filmskaper = filmskaper;
        this.filmtittel = filmtittel;
        this.filmlansering = filmlansering;
        this.filmsjanger = filmsjanger;
        this.filmnavn = filmnavn;
    }

    public int getFilmnr(){
        return this.filmnr;
    }

    public void setFilmnr(int filmnr){
        this.filmnr = filmnr;
    }

    public String getFilmskaper() {
        return this.filmskaper;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getFilmtittel() {
        return this.filmtittel;
    }

    public void setFilmtittel(String filmtittel) {
        this.filmtittel= filmtittel;
    }

    public int getFilmlansering() {
        return this.filmlansering;
    }

    public void setFilmlansering(int filmlansering) {
        this.filmlansering = filmlansering;
    }

    public Sjanger getFilmsjanger() {
        return this.filmsjanger;
    }

    public void setFilmsjanger(Sjanger filmsjanger) {
        this.filmsjanger = filmsjanger;
    }
    public String getFilmnavn() {
        return this.filmnavn;
    }

    public void setFilmnavn(String filmnavn) {
        this.filmnavn = filmnavn;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }
}