package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class Filmarkiv2Test {

    private FilmarkivADT arkiv;
    private Film film1, film2, film3;

    @BeforeEach
    void setUp() {
        arkiv = new Filmarkiv2();
        film1 = new Film(1, "Produsent A", "Film A", 2000, Sjanger.ACTION, "Selskap A");
        film2 = new Film(2, "Produsent B", "Film B", 2005, Sjanger.DRAMA, "Selskap B");
        film3 = new Film(3, "Produsent A", "Film C", 2010, Sjanger.SCIFI, "Selskap A");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
    }

    @Test
    void testFinnFilm() {
        assertEquals(film1, arkiv.finnFilm(1));
        assertEquals(film2, arkiv.finnFilm(2));
        assertEquals(film3, arkiv.finnFilm(3));
        assertNull(arkiv.finnFilm(99)); // finnes ikke
    }

    @Test
    void testSlettFilm() {
        assertTrue(arkiv.slettFilm(2));
        assertNull(arkiv.finnFilm(2));
        assertFalse(arkiv.slettFilm(99)); // finnes ikke
        assertEquals(2, arkiv.antall());
    }

    @Test
    void testSoekTittel() {
        Film[] result = arkiv.soekTittel("Film");
        assertEquals(3, result.length);

        result = arkiv.soekTittel("A");
        assertEquals(2, result.length); // Film A og Film C
    }

    @Test
    void testSoekProdusent() {
        Film[] result = arkiv.soekProdusent("Produsent A");
        assertEquals(2, result.length);

        result = arkiv.soekProdusent("B");
        assertEquals(1, result.length);

        result = arkiv.soekProdusent("Ingen");
        assertEquals(0, result.length);
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.ACTION));
        assertEquals(1, arkiv.antall(Sjanger.DRAMA));
        assertEquals(1, arkiv.antall(Sjanger.SCIFI));
        assertEquals(0, arkiv.antall(Sjanger.HISTORY));
    }

    @Test
    void testAntallTotalt() {
        assertEquals(3, arkiv.antall());
        arkiv.slettFilm(1);
        assertEquals(2, arkiv.antall());
    }
}
