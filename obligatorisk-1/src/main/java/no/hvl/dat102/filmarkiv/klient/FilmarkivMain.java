package no.hvl.dat102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmarkivADT arkiv = new Filmarkiv(10);
        Meny meny = new Meny(arkiv);
        meny.start();
    }
}