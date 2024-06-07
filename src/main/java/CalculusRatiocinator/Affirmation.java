package main.java.CalculusRatiocinator;

import java.util.Set;

public abstract class Affirmation{
    protected final Set<String> affirmationsVraies;
    protected final Set<String> affirmationsFausses;

    protected Affirmation(Set<String> affirmationsVraies, Set<String> affirmationsFausses) {
        this.affirmationsVraies = affirmationsVraies;
        this.affirmationsFausses = affirmationsFausses;
    }

    public boolean estVraie(String uneAffirmation) {
        return affirmationsVraies.contains(uneAffirmation);
    }

    public boolean estFausse(String uneAffirmation) {
        return affirmationsFausses.contains(uneAffirmation);
    }

    public abstract boolean estVraie();

}
