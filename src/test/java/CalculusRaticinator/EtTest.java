package test.java.CalculusRaticinator;

import main.java.CalculusRatiocinator.conjonctionsDeCoordinations.Et;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EtTest {
    @Test
    public void testEt() {
        Set<String> affirmations = new HashSet<>();
        affirmations.add("Lou est beau");
        affirmations.add("Lou est pauvre");
        affirmations.add("Lou est généreux");

        Et etAffirmation1 = new Et(affirmations, "Lou est pauvre", "Lou est généreux");
        assertTrue(etAffirmation1.estVraie());

        Et etAffirmation2 = new Et(affirmations, "Lou est pauvre", "Lou est riche");
        assertFalse(etAffirmation2.estVraie());
    }
}
