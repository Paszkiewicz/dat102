package no.hvl.dat102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] arkiv;
    private int antall;

    public Filmarkiv(int kapasitet) {
        arkiv = new Film[kapasitet];
        antall = 0;
    }

    private void utvid() {
        Film[] ny = new Film[arkiv.length * 2];
        System.arraycopy(arkiv, 0, ny, 0, antall);
        arkiv = ny;
    }

    private Film[] trim(Film[] tab, int n) {
        Film[] ny = new Film[n];
        System.arraycopy(tab, 0, ny, 0, n);
        return ny;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmnr() == nr) return arkiv[i];
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == arkiv.length) utvid();
        arkiv[antall++] = nyFilm;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmnr() == filmnr) {
                arkiv[i] = arkiv[antall - 1];
                arkiv[--antall] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] res = new Film[antall];
        int n = 0;
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                res[n++] = arkiv[i];
            }
        }
        return trim(res, n);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] res = new Film[antall];
        int n = 0;
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                res[n++] = arkiv[i];
            }
        }
        return trim(res, n);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int n = 0;
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getSjanger() == sjanger) n++;
        }
        return n;
    }

    @Override
    public int antall() {
        return antall;
    }
}