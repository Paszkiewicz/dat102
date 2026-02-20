# dat102 - obligatorisk innlevering 2

**Leveringsfrist**: 20. februar 2026

**Gruppemedlemmer**

| *Navn*                       | *Github brukernavn* |
| ---------------------------- | ------------------- |
| Bartosz Paszkiewicz          | Paszkiewicz         |
| Lars Birger Bergmål          | larsbirger          |
| Markus Fosse Høvring         | Markus-Hovring      |
| Daniel Aarsand               | brasswhisper-hub    |

---

## Oppgave 1: Parentessjekker (Uke 6)

### Beskrivelse

Jeg har implementert en `ParentesSjekker` som bruker en stabel (`TabellStabel`) for å validere om parenteser i en streng er korrekt balansert og plassert. Algoritmen sjekker mot symbolene `(`, `[`, og `{`.

### Skjermbilde av kjøring (JUnit-tester)

> 
> Lim inn skjermbilde her som viser at `ParentesSjekkerTest` kjører grønt på de 5 testtilfellene fra oppgaven.
> 
> 

---

## Oppgave 2: Optimalisert Insertion Sort (Uke 7, Oppgave 1)

### Beskrivelse

Jeg har implementert en kombinert optimalisering av Insertion Sort som inkluderer:

1. **Vaktpost (Sentinel):** Det minste elementet flyttes først til posisjon 0 for å forenkle `while`-løkken.

2. **Dobbel innsetting:** To elementer settes inn samtidig for å redusere antall flyttinger i den sorterte delen av tabellen.

### Observasjoner

Etter å ha endret koden til a finne den minste verdien først for å så sette den ved index = 0, ble det observert en tids reduksjon fra cirka 8.350 til 7.950 s.

**Analyse:** Ved å flytte to elementer av gangen reduseres antall sammenligninger i den indre løkken, og vaktposten fjerner behovet for å sjekke om indeksen  i hver iterasjon.

## Oppgave 3: Sammenligning av sorteringsmetoder (Uke 7, Oppgave 2)

### Måleresultater

Her er gjennomsnittstidene målt på min maskin for de ulike algoritmene.

Tabell for Kvikksortering

|  | Antall målinger | Målt tid (snitt) | Teoretisk tid () |
| --- | --- | --- | --- |
| 32 000 | 10 | [Tid] ms | [Tid] ms |
| 64 000 | 10 | [Tid] ms | [Tid] ms |
| 128 000 | 10 | [Tid] ms | [Tid] ms |

*(Gjenta lignende tabeller for Insertion Sort, Selection Sort og Merge Sort i PDF-en din)*.

### Teorispørsmål

**1. Samsvarer de teoretiske resultatene med de målte?**
[Ditt svar her: Diskuter om tiden 4-dobles for -algoritmer når  dobles].

**2. Hva skjer når Quicksort sorterer en tabell der alle elementene er like?**
[Ditt svar her: Forklar om partisjoneringen blir ubalansert og hvordan dette påvirker kjøretiden (ofte mot )].

---

## Vedlegg: Skjermbilder av kjøring

> *Legg til skjermbilder som viser tidsmålingene i konsollen for de ulike algoritmene.*

---

**Vil du at jeg skal hjelpe deg med å beregne konstanten  for en av tabellene dine hvis du har målt en tid for ?**