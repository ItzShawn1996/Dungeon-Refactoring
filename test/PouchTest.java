
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.player.Pouch;

public class PouchTest {

    @Test
    void testInitialCoins() {
        Pouch pouch = new Pouch();

        assertEquals(0, pouch.getCoins());
    }

    @Test
    void testAddCoins() {
        Pouch pouch = new Pouch();

        pouch.addCoins(50);

        assertEquals(50, pouch.getCoins());
    }

    @Test
    void testAddNegativeCoins() {
        Pouch pouch = new Pouch();

        pouch.addCoins(-10);

        assertEquals(0, pouch.getCoins());
    }

    @Test
    void testRemoveCoins() {
        Pouch pouch = new Pouch();
        pouch.addCoins(100);

        pouch.removeCoins(30);

        assertEquals(70, pouch.getCoins());
    }

    @Test
    void testRemoveTooManyCoins() {
        Pouch pouch = new Pouch();
        pouch.addCoins(20);

        pouch.removeCoins(50);

        assertEquals(0, pouch.getCoins());
    }

    @Test
    void testSetCoins() {
        Pouch pouch = new Pouch();

        pouch.setCoins(200);

        assertEquals(200, pouch.getCoins());
    }

    @Test
    void testSetNegativeCoins() {
        Pouch pouch = new Pouch();
        pouch.setCoins(100);

        pouch.setCoins(-50);

        assertEquals(100, pouch.getCoins());
    }
}

