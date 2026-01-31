package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        // legg inn en del forhåndsdefinerte filmer for å teste metodene
// ..
        Film film1 = new Film(1, "Tarantino", "Pulp Fiction", 1994, Sjanger.THRILLER, "A band Apart");
        Film film2 = new Film(2, "Edgar Wright", "Scott Pilgrim vs. The World", 2010, Sjanger.COMEDY, "Marc Platt Productions");
        Film film3 = new Film(3, "Stanley Kubrick", "2001: A Space Odyssey", 1968, Sjanger.SCI_FI, "Stanley Kubrick Productions");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        tekstgr.skrivUtFilm(film1);
        tekstgr.skrivUtStatistikk(filmarkiv);
    }
}
