package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }
    public void nyNode(Film ny) {
        LinearNode<Film> nynode = new LinearNode<Film>(ny);
        nynode.neste = start;
        start = nynode;
        antall++;

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

        boolean funnet = false;
        LinearNode<Film> current = start;
        while (!funnet && (current != null)) {
            if (nr == current.getData().getFilmnummer()) {
                funnet = true;
            } else {
                current = current.neste;
            }
            return current.getData();
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

        nyNode(nyFilm);

    }

    @Override
    public boolean slettFilm(int filmnr) {

        boolean slette = false;
        LinearNode<Film> current = start;
        while (!slette && (current != null)) {
            if (filmnr == current.getData().getFilmnummer()) {
                current.data = start.data;
                start = start.neste;
                antall--;
                slette = true;
            }
        }
        return slette;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        Film[] soektitt = new Film[antall()];
        int i = 0;
        boolean telt = false;
        LinearNode<Film> current = start;
        while (!telt && current != null) {
            if (delstreng == current.getData().getTittel()) {
                soektitt[i] = current.getData();
                i++;
                current = current.neste;
            }
            i++;
            current = current.neste;
        }
        Film[] fulltitt = trimFilmarkiv(soektitt, soektitt.length);
        return fulltitt;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] soekprod = new Film[antall()];
        int i = 0;
        boolean telt = false;
        LinearNode<Film> current = start;
        while (!telt && current != null) {
            if (delstreng == current.getData().getFilmskaper()) {
                soekprod[i] = current.getData();
                i++;
                current = current.neste;
            }
            i++;
            current = current.neste;
        }
        Film[] fullprod = trimFilmarkiv(soekprod, soekprod.length);
        return fullprod;
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int telle = 0;
        LinearNode<Film> current = start;
        boolean telt = false;
        while (!telt && current != null) {
            if (current.getData().getSjanger() == sjanger) {
                telle++;
                current = current.neste;
            }
        }
        return telle;
    }

    @Override
    public int antall() {
        int telle = 0;
        boolean telt = false;
        LinearNode<Film> current = start;
        while (!telt && current != null) {
            telle++;
            current = current.neste;
        }
        return telle;
    }
}
