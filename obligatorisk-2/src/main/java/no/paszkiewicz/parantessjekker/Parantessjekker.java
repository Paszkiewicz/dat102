package no.paszkiewicz.parantessjekker;



public class Parantessjekker{

    public boolean sjekkParanteser(String s) {

        TabellStabel<Character> stabel = new TabellStabel<>();

        for (char c : s.toCharArray()) {

            if (erStartParantes(c)) {
                stabel.push(c);
            }

            else if (erSluttParantes(c)) {

                if (stabel.isEmpty()) {
                    return false;
                }

                char start = stabel.pop();

                if (!erParantesPar(start, c)) {
                    return false;
                }
            }
        }

        return stabel.isEmpty();
    }

    private boolean erStartParantes(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean erSluttParantes(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean erParantesPar(char start, char slutt) {
        return (start == '(' && slutt == ')') ||
                (start == '[' && slutt == ']') ||
                (start == '{' && slutt == '}');
    }
}