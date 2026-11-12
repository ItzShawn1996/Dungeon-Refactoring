
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.player.Pouch;

/**
 * Unit tests for the Pouch class.
 */
public class PouchTest {

    /**
     * Verifies that a newly created pouch contains zero coins.
     */
    @Test
    void testInitialCoins() {
        Pouch pouch = new Pouch();

        assertEquals(0, pouch.getCoins());
    }

    /**
     * Verifies that adding a positive number of coins
     * correctly increases the pouch balance.
     */
    @Test
    void testAddCoins() {
        Pouch pouch = new Pouch();

        pouch.addCoins(50);

        assertEquals(50, pouch.getCoins());
    }

    /**
     * Verifies that negative coin additions are rejected
     * and do not change the existing balance.
     */
    @Test
    void testAddNegativeCoins() {
        Pouch pouch = new Pouch();

        pouch.addCoins(-10);

        assertEquals(0, pouch.getCoins());
    }

    /**
     * Verifies that removing coins correctly decreases
     * the pouch balance.
     */
    @Test
    void testRemoveCoins() {
        Pouch pouch = new Pouch();
        pouch.addCoins(100);

        pouch.removeCoins(30);

        assertEquals(70, pouch.getCoins());
    }

    /**
     * Verifies that removing more coins than available
     * does not produce a negative balance.
     *
     * Known failure: The original implementation allows
     * the balance to become negative.
     */
    @Test
    void testRemoveTooManyCoins() {
        Pouch pouch = new Pouch();
        pouch.addCoins(20);

        pouch.removeCoins(50);

        assertEquals(0, pouch.getCoins());
    }

    /**
     * Verifies that setting the coin balance directly
     * updates the pouch to the specified amount.
     */
    @Test
    void testSetCoins() {
        Pouch pouch = new Pouch();

        pouch.setCoins(200);

        assertEquals(200, pouch.getCoins());
    }

    /**
     * Verifies that attempting to set a negative balance
     * leaves the existing coin balance unchanged.
     */
    @Test
    void testSetNegativeCoins() {
        Pouch pouch = new Pouch();
        pouch.setCoins(100);

        pouch.setCoins(-50);

        assertEquals(100, pouch.getCoins());
    }
}
