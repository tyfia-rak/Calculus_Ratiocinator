package main.java.CalculusRatiocinator;

import java.util.Set;

public abstract class Affirmation{
    protected final Set<String> affirmations;

    protected Affirmation(Set<String> affirmations) {
        this.affirmations = affirmations;
    }

    public boolean contient(String uneAffirmation) {
        return affirmations.contains(uneAffirmation);
    }

    public abstract boolean estVraie();

}
