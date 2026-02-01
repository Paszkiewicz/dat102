package no.hvl.dat102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT arkiv;

    public Meny(FilmarkivADT arkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.arkiv = arkiv;
    }

    public void start() {

        // forhåndsdata
        arkiv.leggTilFilm(new Film(1,"Lucas","Star Wars",1977,Sjanger.SCIFI,"Fox"));
        arkiv.leggTilFilm(new Film(2,"Nolan","Inception",2010,Sjanger.ACTION,"WB"));
        arkiv.leggTilFilm(new Film(3,"Spielberg","Saving Private Ryan",1998,Sjanger.HISTORY,"Paramount"));

        Scanner sc = new Scanner(System.in);

        boolean ferdig = false;
        while (!ferdig) {
            System.out.println("\n1: Ny film");
            System.out.println("2: Søk tittel");
            System.out.println("3: Søk produsent");
            System.out.println("4: Statistikk");
            System.out.println("0: Avslutt");
            System.out.print("Valg: ");

            int valg = sc.nextInt();
            sc.nextLine();

            switch (valg) {
                case 1 -> arkiv.leggTilFilm(tekstgr.lesFilm());
                case 2 -> {
                    System.out.print("Delstreng: ");
                    tekstgr.skrivUtFilmDelstrengITittel(arkiv, sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Produsent: ");
                    tekstgr.skrivUtFilmProdusent(arkiv, sc.nextLine());
                }
                case 4 -> tekstgr.skrivUtStatistikk(arkiv);
                case 0 -> ferdig = true;
            }
        }
    }
}