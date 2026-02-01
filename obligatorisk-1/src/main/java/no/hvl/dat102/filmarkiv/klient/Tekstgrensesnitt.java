package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner tastatur;

    public Tekstgrensesnitt() {
        tastatur = new Scanner(System.in);
    }

    public Film lesFilm() {
        System.out.println("Skriv inn filmnummer: ");
        int nr = Integer.parseInt(tastatur.nextLine());

        System.out.println("Skriv inn produsent: ");
        String produsent = tastatur.nextLine();

        System.out.println("Skriv inn tittel: ");
        String tittel = tastatur.nextLine();

        System.out.println("Skriv inn år for lansering: ");
        int aar = Integer.parseInt(tastatur.nextLine());

        System.out.println("Skriv inn sjanger (ACTION, DRAMA, HISTORY, SCIFI): ");
        String sjangerTekst = tastatur.nextLine();
        Sjanger sjanger = Sjanger.finnSjanger(sjangerTekst);
        if (sjanger == null) {
            System.out.println("Ugyldig sjanger! Setter til DRAMA som standard.");
            sjanger = Sjanger.DRAMA;
        }

        System.out.println("Skriv inn filmselskap: ");
        String selskap = tastatur.nextLine();

        return new Film(nr, produsent, tittel, aar, sjanger, selskap);
    }

    public void skrivUtFilm(Film film) {
        if (film == null) {
            System.out.println("Fant ingen film.");
            return;
        }
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("Produsent: " + film.getProdusen
