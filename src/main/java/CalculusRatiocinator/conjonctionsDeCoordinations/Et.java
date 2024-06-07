package main.java.CalculusRatiocinator.conjonctionsDeCoordinations;

import main.java.CalculusRatiocinator.Affirmation;

import java.util.Set;

public class Et extends Affirmation {
    private final String affirmation1;
    private final String affirmation2;

    public Et(Set<String> affirmations, String affirmation1, String affirmation2) {
        super(affirmations);
        this.affirmation1 = affirmation1;
        this.affirmation2 = affirmation2;
    }

    @Override
    public boolean estVraie() {
        if (contient(affirmation1) && contient(affirmation2)){
            return true;
        }
        return false;
    }
}
