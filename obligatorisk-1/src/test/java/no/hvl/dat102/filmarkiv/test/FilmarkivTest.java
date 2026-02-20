package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {

    private FilmarkivADT arkiv;

    private Film f1, f2, f3;

    @BeforeEach
    void setup() {
        arkiv = new Filmarkiv(5);

        f1 = new Film(1, "Lucas", "Star Wars", 1977, Sjanger.SCIFI, "Fox");
        f2 = new Film(2, "Nolan", "Inception", 2010, Sjanger.ACTION, "WB");
        f3 = new Film(3, "Tarantino", "Pulp Fiction", 1994, Sjanger.COMEDY, "Miramax");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
        arkiv.leggTilFilm(f3);
    }

    @Test
    void testAntall() {
        assertEquals(3, arkiv.antall());
    }

    @Test
    void testFinnFilm() {
        Film funnet = arkiv.finnFilm(2);
        assertNotNull(funnet);
        assertEquals("Inception", funnet.getTittel());
    }

    @Test
    void testSlettFilm() {
        assertTrue(arkiv.slettFilm(2));
        assertEquals(2, arkiv.antall());
        assertNull(arkiv.finnFilm(2));
    }

    @Test
    void testSoekTittel() {
        Film[] res = arkiv.soekTittel("Star");
        assertEquals(1, res.length);
        assertEquals("Star Wars", res[0].getTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] res = arkiv.soekProdusent("Nolan");
        assertEquals(1, res.length);
        assertEquals("Inception", res[0].getTittel());
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.SCIFI));
        assertEquals(1, arkiv.antall(Sjanger.ACTION));
        assertEquals(1, arkiv.antall(Sjanger.HISTORY));
    }
}


