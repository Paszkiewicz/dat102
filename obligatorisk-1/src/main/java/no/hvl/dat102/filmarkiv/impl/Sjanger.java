package no.hvl.dat102.filmarkiv.impl;

public enum Sjanger {
    ACTION, DRAMA, SCI_FI, FANTASY, THRILLER, HORROR, ROMANCE, EROTICA,
    COMEDY, DOCUMENTARY, KIDS, MYSTERY, WESTERN, NOIR, PROPAGANDA, MUSICAL,
    ANIMATION, LIVE_ACTION, TRAGEDY, EDUCATIONAL, SLICE_OF_LIFE, WAR, SPORTS,
    HISTORICAL, ALTERNATE_HISTORY, MELODRAMA;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if  (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }

}