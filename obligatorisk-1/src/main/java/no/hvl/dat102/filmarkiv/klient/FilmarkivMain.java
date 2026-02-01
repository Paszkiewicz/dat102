package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
    public static void main(String[] args) {
        // Her velger du hvilken implementasjon du vil bruke (Oppgave 1 eller 2)
        Filmarkiv arkiv = new Filmarkiv(10); 
        Meny meny = new Meny(arkiv);
        meny.start();
    }
}