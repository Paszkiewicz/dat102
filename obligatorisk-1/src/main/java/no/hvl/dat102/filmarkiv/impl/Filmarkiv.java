package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmtabell;
    private int antall;

    public Filmarkiv(int kapasitet) {
        filmtabell = new Film[kapasitet];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmtabell[i].getFilmnummer() == nr) {
                return filmtabell[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmtabell.length) {
            utvid();
        }
        filmtabell[antall] = nyFilm;
        antall++;
    }

    private void utvid() {
        // Dobler størrelsen på tabellen når den er full
        Film[] nyTabell = new Film[filmtabell.length * 2];
        System.arraycopy(filmtabell, 0, nyTabell, 0, filmtabell.length);
        filmtabell = nyTabell;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmtabell[i].getFilmnummer() == filmnr) {
                // Flytter den siste filmen til plassen vi sletter for å unngå "hull" 
                filmtabell[i] = filmtabell[antall - 1];
                filmtabell[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int iTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmtabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[iTreff] = filmtabell[i];
                iTreff++;
            }
        }
        return trimTab(treff, iTreff);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int iTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmtabell[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[iTreff] = filmtabell[i];
                iTreff++;
            }
        }
        return trimTab(treff, iTreff);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;
        for (int i = 0; i < antall; i++) {
            if (filmtabell[i].getSjanger() == sjanger) {
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    // Hjelpemetode for å trimme tabellen til riktig størrelse
    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        System.arraycopy(tab, 0, nytab, 0, n);
        return nytab;
    }
}