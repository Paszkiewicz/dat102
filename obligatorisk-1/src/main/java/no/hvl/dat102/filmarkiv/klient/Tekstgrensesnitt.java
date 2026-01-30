package no.hvl.dat102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner scanner = new Scanner(System.in);

    // Leser opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        System.out.print("Filmnummer: ");
        int nr = Integer.parseInt(scanner.nextLine());
        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();
        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();
        System.out.print("År: ");
        int aar = Integer.parseInt(scanner.nextLine());
        System.out.print("Filmselskap: ");
        String selskap = scanner.nextLine();
        
        System.out.print("Sjanger (f.eks. ACTION, DRAMA, SCI_FI): ");
        String sjangerStr = scanner.nextLine();
        Sjanger sjanger = Sjanger.finnSjanger(sjangerStr);

        return new Film(nr, produsent, tittel, aar, sjanger, selskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm
    public void visFilm(Film film) {
        if (film != null) {
            System.out.println(film.getFilmnummer() + ": " + film.getTittel() + " (" + film.getUtgivelsesaar() + ")");
            System.out.println("   Produsent: " + film.getFilmskaper() + ", Sjanger: " + film.getSjanger());
        }
    }

    // Skriver ut alle filmer med en gitt delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] treff = arkiv.soekTittel(delstreng);
        for (Film f : treff) {
            visFilm(f);
        }
    }

    // Skriver ut statistikk for arkivet
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Totalt antall filmer: " + arkiv.antall());
        for (Sjanger s : Sjanger.values()) {
            System.out.println(s + ": " + arkiv.antall(s));
        }
    }
}