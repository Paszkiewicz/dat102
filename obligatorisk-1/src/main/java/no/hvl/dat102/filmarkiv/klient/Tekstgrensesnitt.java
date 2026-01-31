package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){

        Scanner tastatur = new Scanner(System.in);
        Film film = new Film();
        System.out.print("Skriv inn filmnummer: ");
        film.setFilmnummer(tastatur.nextInt());
        System.out.print("Skriv inn filmtittel: ");
        film.setTittel(tastatur.nextLine());
        System.out.print("Skriv inn filmskaper: ");
        film.setFilmskaper(tastatur.nextLine());
        System.out.print("Skriv inn filmselskap: ");
        film.setFilmselskap(tastatur.nextLine());
        System.out.print("Skriv inn sjanger (i all caps):");
        film.setSjanger(Sjanger.valueOf(tastatur.nextLine()));
        System.out.print("Skriv inn utgivelsesaar: ");
        film.setUtgivelsesaar(tastatur.nextInt());
        tastatur.close();
        return film;
    }
    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {

        System.out.println("Filmnummer: "+film.getFilmnummer()+"\nFilmtittel: "+film.getTittel()+"\nFilmskaper: "+film.getFilmskaper()+"\nFilmselskap: "+film.getFilmselskap()+"\nSjanger: "+film.getSjanger().toString()+"\nUtgivelsesaar: "+film.getUtgivelsesaar());
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {

        System.out.println(arkiv.soekTittel(delstreng));
    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {

        System.out.println(arkiv.soekProdusent(delstreng));

    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        Sjanger[] sjangtab = Sjanger.values();
        int[] antallsjangtab = new int[sjangtab.length];
        for (int i = 0; i < sjangtab.length; i++) {
            antallsjangtab[i] = arkiv.antallSjanger(sjangtab[i]);
            i++;
        }
        System.out.println(arkiv.antall());
        System.out.println(antallsjangtab.toString());
    }
// osv ... andre metoder
}