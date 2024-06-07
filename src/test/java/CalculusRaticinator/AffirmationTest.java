package test.java.CalculusRaticinator;

import main.java.CalculusRatiocinator.Affirmation;
import main.java.CalculusRatiocinator.AnalyseurAffirmation;
import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Donc;
import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Et;
import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Ou;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AffirmationTest {
    @Test
    public void testAffirmation1() {
        Set<String> vraies = new HashSet<>();
        vraies.add("Lou est pauvre");
        vraies.add("Lou est généreux");

        Set<String> fausses = new HashSet<>();

        // Affirmation 1: "Lou est pauvre et Lou est généreux."
        Affirmation affirmation1 = new Et(vraies, fausses, "Lou est pauvre", "Lou est généreux");
        assertTrue(affirmation1.estVraie());
    }

    @Test
    public void testAffirmation2() {
        Set<String> vraies = new HashSet<>();
        vraies.add("Lou est beau");

        Set<String> fausses = new HashSet<>();
        fausses.add("Lou est pauvre");

        // Affirmation 2: "Lou est beau. Donc Lou est pauvre."
        Affirmation affirmation2 = new Donc(vraies, fausses, "Lou est beau", "Lou est pauvre");
        assertFalse(affirmation2.estVraie());
    }

    @Test
    public void testAffirmation3() {
        Set<String> vraies = new HashSet<>();
        vraies.add("Lou est pauvre");

        Set<String> fausses = new HashSet<>();
        fausses.add("Lou est généreux");

        // Affirmation 3: "Lou est pauvre. Donc Lou est généreux."
        Affirmation affirmation3 = new Donc(vraies, fausses, "Lou est pauvre", "Lou est généreux");
        assertFalse(affirmation3.estVraie());
    }

    @Test
    public void testAffirmation4() {
        Set<String> vraies = new HashSet<>();
        vraies.add("Lou est beau");
        vraies.add("Lou est généreux");

        Set<String> fausses = new HashSet<>();
        fausses.add("Lou est pauvre");

        // Affirmation 4: "Lou est beau ou Lou est généreux. Donc Lou est pauvre."
        Affirmation affirmation4 = new Donc(vraies, fausses, "Lou est beau ou Lou est généreux", "Lou est pauvre");
        assertTrue(affirmation4.estVraie());
    }

    @Test
    public void testAffirmation5() {
        Set<String> vraies = new HashSet<>();
        vraies.add("Lou est beau");
        vraies.add("Lou est généreux");

        Set<String> fausses = new HashSet<>();
        fausses.add("Lou est pauvre");

        // Affirmation 5: "Premièrement : « Lou est beau ou Lou est généreux. Donc Lou est pauvre. » Et deuxièmement : Lou est pauvre ou Lou est généreux »."
        Affirmation affirmation5 = AnalyseurAffirmation.analyser("Premièrement : « Lou est beau ou Lou est généreux. Donc Lou est pauvre. » Et deuxièmement : Lou est pauvre ou Lou est généreux ».", vraies, fausses);
        assertNotNull(affirmation5);

        // Vérification de la première partie de l'affirmation 5
        assertTrue(affirmation5 instanceof Donc);
        assertTrue(affirmation5.estVraie());

        // Vérification de la deuxième partie de l'affirmation 5
        assertEquals(2, ((ListeAffirmation) affirmation5).getAffirmations().size());
        for (Affirmation sousAffirmation : ((ListeAffirmation) affirmation5).getAffirmations()) {
            assertTrue(sousAffirmation instanceof Ou);
            assertFalse(sousAffirmation.estVraie());
        }
    }
}
