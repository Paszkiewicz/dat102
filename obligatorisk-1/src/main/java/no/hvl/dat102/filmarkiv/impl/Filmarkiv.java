package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmliste;

    public Filmarkiv(int antallfilmer){
        this.filmliste = new Film[antallfilmer];
    }

    public Film[] utvid(Film[] liste) {
        if (this.filmliste.length == 0) {

        } else {
            Film[] nyFilmListe = new Film[filmliste.length * 2];
        }
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall(); i++) {
            if (filmliste[i].getFilmnr() == nr) {
                return filmliste[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        try {
            filmliste[antall()] = nyFilm;
        } catch (ArrayIndexOutOfBoundsException e) {
            filmliste = utvid(filmliste);
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] filmMedtittel = new Film[antall()];
        int count = 0;

        for (int i = 0; i < antall(); i++) {
            if (filmliste[i].getFilmtittel().contains(delstreng)) {
                filmMedtittel[count - 1] = filmliste[i];
            }
        }

        return filmMedtittel;
    }

    @Override
    public Film[] soekProdusent(String produsent) {
        Film[] filmprodusent = new Film[antall()];
        int count = 0;

        for (int i = 0; i < antall(); i++) {
            if (filmliste[i] != null && filmliste[i].getFilmskaper().contains(produsent)) {
                filmprodusent[count - 1] = filmliste[i];
                count--;
            }
        }

        return filmprodusent;
    }

    @Override
    public int antall(Sjanger filmSjanger) {
        int filmMedSjanger = 0;

        for (int i = 0; i < antall(); i++) {
            if (filmliste[i].getFilmsjanger() == filmSjanger && filmliste[i] != null) {
                filmMedSjanger++;
            }
        }
        return filmMedSjanger;
    }

    @Override
    public int antall() {
        int antall = 0;

        for (int i = 0; i < filmliste.length; i++) {
            if (filmliste[i] != null) {
                antall++;
            }
        }
        return antall;
    }
}
