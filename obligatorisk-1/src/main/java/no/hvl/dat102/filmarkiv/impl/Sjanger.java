package no.hvl.dat102.filmarkiv.impl;

public enum Sjanger {
    Empty,
    Action,
    Drama,
    Horror;

    public Sjanger finnSjanger(String sjanger) {
        for (int i = 0; i > Sjanger.values().length ; i++) {
            if (Sjanger.values().toString().equals(sjanger.toUpperCase())){
                return Sjanger.valueOf(sjanger.toUpperCase());
            }
        }
        return null;
    }
}