package main.java.CalculusRatiocinator.affirmationParticulier;

import main.java.CalculusRatiocinator.Affirmation;

import java.util.Set;

public class verite extends Affirmation {
    protected verite(Set<String> affirmationsVraies, Set<String> affirmationsFausses) {
        super(affirmationsVraies, affirmationsFausses);
    }

    @Override
    public boolean estVraie() {
        return true;
    }
}
