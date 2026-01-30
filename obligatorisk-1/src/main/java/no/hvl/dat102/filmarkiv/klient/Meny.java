package no.hvl.dat102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        this.tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    /**
     * Arrow in case statement supported from Java 14 onwards onlyJava(1073743544)
     */
    public void start() {
        // Legg inn noen testdata først
        filmarkiv.leggTilFilm(new Film(1, "Spielberg", "Jaws", 1975, Sjanger.THRILLER, "Universal"));
        filmarkiv.leggTilFilm(new Film(2, "Lucas", "Star Wars", 1977, Sjanger.SCI_FI, "Fox"));

        Scanner in = new Scanner(System.in);
        boolean fortsett = true;

        while (fortsett) {
            System.out.println("\n--- FILMARKIV MENY ---");
            System.out.println("1: Legg til ny film");
            System.out.println("2: Søk etter tittel");
            System.out.println("3: Slett film");
            System.out.println("4: Vis statistikk");
            System.out.println("0: Avslutt");
            System.out.print("Valg: ");
            
            String valg = in.nextLine();

            switch (valg) {
                case "1" -> filmarkiv.leggTilFilm(tekstgr.lesFilm());
                case "2" -> {
                    System.out.print("Søketekst: ");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, in.nextLine());
                }
                case "3" -> {
                    System.out.print("Filmnummer som skal slettes: ");
                    int nr = Integer.parseInt(in.nextLine());
                    if (filmarkiv.slettFilm(nr)) System.out.println("Slettet.");
                    else System.out.println("Fant ikke filmen.");
                }
                case "4" -> tekstgr.skrivUtStatistikk(filmarkiv);
                case "0" -> fortsett = false;
                default -> System.out.println("Ugyldig valg.");
            }
        }
    }
}