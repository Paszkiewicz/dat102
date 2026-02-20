package no.paszkiewicz.parantessjekker;

import no.paszkiewicz.parantessjekker.Parantessjekker;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ParantessjekkerTest {

    private Parantessjekker sjekker;

    @BeforeEach
    void setup() {
        sjekker = new Parantessjekker();
    }

    @Test
    void korrekteParanteser() {
        assertTrue(sjekker.sjekkParanteser("{ [ ( ) ] }"));
    }

    @Test
    void manglerSluttparantes() {
        assertFalse(sjekker.sjekkParanteser("{ [ ( ) }"));
    }

    @Test
    void manglerStartparantes() {
        assertFalse(sjekker.sjekkParanteser("[ ( ) ] }"));
    }

    @Test
    void feilRekkefølge() {
        assertFalse(sjekker.sjekkParanteser("[ ( { ) } ]"));
    }

    @Test
    void kodeEksempel() {
        String kode = """
                class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello World!");
                    }
                }
                """;
        assertTrue(sjekker.sjekkParanteser(kode));
    }
}