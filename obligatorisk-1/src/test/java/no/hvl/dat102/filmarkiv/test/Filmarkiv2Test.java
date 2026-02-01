package no.hvl.dat102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv2;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {
    private FilmarkivADT arkiv;
    private Film f1;
    private Film f2;
    private Film f3;

    @BeforeEach
    void setUp() {
        arkiv = new Filmarkiv2(10);
        
        f1 = new Film(1, "Spielberg", "Jaws", 1975, Sjanger.THRILLER, "Universal");
        f2 = new Film(2, "Lucas", "Star Wars", 1977, Sjanger.SCI_FI, "Fox");
        f3 = new Film(3, "Nolan", "Inception", 2010, Sjanger.SCI_FI, "Warner");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
    }

    @Test
    void testLeggTilOgAntall() {
        assertEquals(2, arkiv.antall());
        arkiv.leggTilFilm(f3);
        assertEquals(3, arkiv.antall());
    }

    @Test
    void testFinnFilm() {
        assertEquals(f1, arkiv.finnFilm(1));
        assertNull(arkiv.finnFilm(99), "Skal returnere null for filmnummer som ikke finnes");
    }

    @Test
    void testSlettFilm() {
        assertTrue(arkiv.slettFilm(1));
        assertEquals(1, arkiv.antall());
        assertNull(arkiv.finnFilm(1));
        
        assertFalse(arkiv.slettFilm(99), "Skal returnere false ved sletting av ikke-eksisterende film");
    }

    @Test
    void testSoekTittel() {
        Film[] resultat = arkiv.soekTittel("Star");
        assertEquals(1, resultat.length);
        assertEquals("Star Wars", resultat[0].getTittel());
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.SCI_FI));
        arkiv.leggTilFilm(f3); // f3 er også SCI_FI
        assertEquals(2, arkiv.antall(Sjanger.SCI_FI));
    }
}