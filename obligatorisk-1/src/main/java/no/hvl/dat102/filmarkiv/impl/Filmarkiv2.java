package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2(int i) {
        antall = i;
        start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> p = start;
        while (p != null) {
            if (p.data.getFilmnr() == nr) return p.data;
            p = p.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> ny = new LinearNode<>(nyFilm);
        ny.neste = start;
        start = ny;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> p = start, prev = null;
        while (p != null) {
            if (p.data.getFilmnr() == filmnr) {
                if (prev == null) start = p.neste;
                else prev.neste = p.neste;
                antall--;
                return true;
            }
            prev = p;
            p = p.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] res = new Film[antall];
        int n = 0;
        LinearNode<Film> p = start;
        while (p != null) {
            if (p.data.getTittel().toLowerCase().contains(delstreng.toLowerCase()))
                res[n++] = p.data;
            p = p.neste;
        }
        Film[] ferdig = new Film[n];
        System.arraycopy(res, 0, ferdig, 0, n);
        return ferdig;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] res = new Film[antall];
        int n = 0;
        LinearNode<Film> p = start;
        while (p != null) {
            if (p.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase()))
                res[n++] = p.data;
            p = p.neste;
        }
        Film[] ferdig = new Film[n];
        System.arraycopy(res, 0, ferdig, 0, n);
        return ferdig;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int n = 0;
        LinearNode<Film> p = start;
        while (p != null) {
            if (p.data.getSjanger() == sjanger) n++;
            p = p.neste;
        }
        return n;
    }

    @Override
    public int antall() {
        return antall;
    }
}
