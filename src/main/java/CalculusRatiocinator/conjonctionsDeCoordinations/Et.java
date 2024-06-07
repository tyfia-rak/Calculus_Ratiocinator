package main.java.CalculusRatiocinator.conjonctionsDeCoordinations;

import main.java.CalculusRatiocinator.Affirmation;

public class Et extends Affirmation {
    private final Affirmation Affirmation1;
    private final Affirmation Affirmation2;

    public Et(Affirmation Affirmation1, Affirmation Affirmation2) {
        this.Affirmation1 = Affirmation1;
        this.Affirmation2 = Affirmation2;
    }

    @Override
    public boolean estVraie() {
        if (Affirmation1.estVraie() && Affirmation2.estVraie()){
            return true;
        }
        return false;
    }
}
