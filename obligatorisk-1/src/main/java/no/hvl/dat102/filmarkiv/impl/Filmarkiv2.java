package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        antall = 0;
        start = null;
    }

    public Filmarkiv2(int i) {
        antall = i;
        start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> denne = start;
        while (denne != null) {
            if (denne.data.getFilmnummer() == nr) {
                return denne.data;
            }
            denne = denne.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start == null) return false;

        // Spesialtilfelle: Filmen ligger i den første noden
        if (start.data.getFilmnummer() == filmnr) {
            start = start.neste;
            antall--;
            return true;
        }

        // Vanlig tilfelle: Må lete etter noden og koble forbi den
        LinearNode<Film> forrige = start;
        LinearNode<Film> denne = start.neste;

        while (denne != null) {
            if (denne.data.getFilmnummer() == filmnr) {
                forrige.neste = denne.neste; // Kobler forbi noden
                antall--;
                return true;
            }
            forrige = denne;
            denne = denne.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return lagTrimmetTabell(delstreng, true);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return lagTrimmetTabell(delstreng, false);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> denne = start;
        while (denne != null) {
            if (denne.data.getSjanger() == sjanger) {
                teller++;
            }
            denne = denne.neste;
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

    // Hjelpemetode for å unngå duplisert kode i søkene
    private Film[] lagTrimmetTabell(String delstreng, boolean erTittelSoek) {
        Film[] midlertidig = new Film[antall];
        int treff = 0;
        LinearNode<Film> denne = start;

        while (denne != null) {
            String sammenlignMed = erTittelSoek ? denne.data.getTittel() : denne.data.getFilmskaper();
            
            if (sammenlignMed.toLowerCase().contains(delstreng.toLowerCase())) {
                midlertidig[treff] = denne.data;
                treff++;
            }
            denne = denne.neste;
        }

        // Trimmer tabellen til nøyaktig antall treff
        Film[] resultat = new Film[treff];
        System.arraycopy(midlertidig, 0, resultat, 0, treff);
        return resultat;
    }
}