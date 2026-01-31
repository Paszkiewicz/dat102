package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    Film[] filmarkiv;
    int antall;

    public Filmarkiv(int antall) {
        this.filmarkiv = new Film[antall];
        this.antall = antall;
    }

    private Film[] trimFilmarkiv(Film[] filmarkiv, int n) {
        Film[] nyfilmark = new Film[n];
        int i = 0;
        while (i < n) {
            nyfilmark[i] = filmarkiv[i];
            i++;
        }
        return nyfilmark;
    }

    @Override
    public Film finnFilm(int nr) {

        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i].getFilmnummer() == nr) {
                return filmarkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i] == null) {
                filmarkiv[i] = nyFilm;
                antall++;
            }
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {

        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i].getFilmnummer() == filmnr) {
                filmarkiv[i] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        Film[] soektab = new Film[filmarkiv.length];
        int j = 0;
        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i].getTittel().equals(delstreng)) {
                soektab[j] = filmarkiv[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
        Film[] fullsoek = trimFilmarkiv(soektab, soektab.length);
        return fullsoek;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        Film[] soekprod = new Film[filmarkiv.length];
        int j = 0;
        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i].getFilmskaper().equals(delstreng)) {
                soekprod[j] = filmarkiv[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
        Film[] fullprod = trimFilmarkiv(soekprod, soekprod.length);
        return fullprod;
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {

        int telle = 0;
        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i].getSjanger() == sjanger) {
                telle++;
            }
        }
        return telle;
    }

    @Override
    public int antall() {

        int telle = 0;
        for (int i = 0; i < filmarkiv.length; i++) {
            if (filmarkiv[i] != null) {
                telle++;
            }
        }
        return telle;
    }
}

