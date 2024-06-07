package main.java.CalculusRatiocinator.conjonctionsDeCoordinations;

import main.java.CalculusRatiocinator.Affirmation;

import java.util.Set;

public class Ou extends Affirmation {
    private final String affirmation1;
    private final String affirmation2;
    public Ou(Set<String> affirmationsVraies, Set<String> affirmationsFausses, String affirmation1, String affirmation2) {
        super(affirmationsVraies, affirmationsFausses);
        this.affirmation1 = affirmation1;
        this.affirmation2 = affirmation2;
    }

    @Override
    public boolean estVraie() {
        if (estVraie(affirmation1) || estVraie(affirmation2)){
            return true;
        }
        return false;
    }
}
