package main.java.CalculusRatiocinator;

import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Donc;
import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Et;
import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Ou;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AnalyseurAffirmation {
    public static Affirmation analyser(String chaine, Set<String> vraies, Set<String> fausses) {
        String[] mots = chaine.split("\\s+");

        for (int i = 0; i < mots.length; i++) {
            if (mots[i].equals("Et")) {
                return new Et(vraies, fausses, mots[i - 1], mots[i + 1]);
            } else if (mots[i].equals("Ou")) {
                return new Ou(vraies, fausses, mots[i - 1], mots[i + 1]);
            } else if (mots[i].equals("Donc")) {
                return new Donc(vraies, fausses, mots[i - 1], mots[i + 1]);
            }
        }


        String[] parties = chaine.split("\\.");
        for (String partie : parties) {
            mots = partie.trim().split("\\s+");
            for (int i = 0; i < mots.length; i++) {
                if (mots[i].equals("Ou")) {
                    return new Ou(vraies, fausses, mots[i - 1], mots[i + 1]);
                } else if (mots[i].equals("Donc")) {
                    return new Donc(vraies, fausses, mots[i - 1], mots[i + 1]);
                }
            }
        }

        return null;
    }
}
