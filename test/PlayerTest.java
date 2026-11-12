
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.player.Player;

public class PlayerTest {

    @Test
    void testInitialHealth() {
        Player player = new Player();

        assertEquals(100, player.health());
    }

    @Test
    void testInitialPotions() {
        Player player = new Player();

        assertEquals(3, player.getPotions());
    }

    @Test
    void testInitialName() {
        Player player = new Player();

        assertEquals("", player.getName());
    }

    @Test
    void testInitialEquipment() {
        Player player = new Player();

        assertFalse(player.hasSword());
        assertFalse(player.hasArmour());
        assertNull(player.getSword());
        assertNull(player.getArmour());
    }

    @Test
    void testSetName() {
        Player player = new Player();

        player.setName("Hero");

        assertEquals("Hero", player.getName());
    }

    @Test
    void testSetHealth() {
        Player player = new Player();

        player.setHealth(75);

        assertEquals(75, player.health());
    }

    @Test
    void testInvalidHealth() {
        Player player = new Player();

        player.setHealth(-10);
        assertEquals(100, player.health());

        player.setHealth(150);
        assertEquals(100, player.health());
    }

    @Test
    void testTakeDamage() {
        Player player = new Player();

        player.takeDamage(25);

        assertEquals(75, player.health());
    }

    @Test
    void testUsePotion() {
        Player player = new Player();
        player.setHealth(50);

        player.usePotion();

        assertEquals(80, player.health());
        assertEquals(2, player.getPotions());
    }

    @Test
    void testCannotUsePotionWhenEmpty() {
        Player player = new Player();
        player.setHealth(50);
        player.setNumberOfPotions(0);

        player.usePotion();

        assertEquals(50, player.health());
        assertEquals(0, player.getPotions());
    }

    @Test
    void testAddPotions() {
        Player player = new Player();

        player.addPotions(5);

        assertEquals(8, player.getPotions());
    }

    @Test
    void testIncreaseEnemiesKilled() {
        Player player = new Player();

        player.increaseEnemiesKilled();

        assertEquals(1, player.enemiesKilled());
    }

    @Test
    void testAttackWithoutSword() {
        Player player = new Player();

        int damage = player.attack();

        assertTrue(damage >= 0);
        assertTrue(damage < Player.BASE_ATTACK_DAMAGE);
    }

    @Test
    void testPotionDoesNotExceedMaxHealth() {
        Player player = new Player();
        player.setHealth(90);

        player.usePotion();

        assertEquals(100, player.health());
    }

    @Test
    void testNegativeDamageDoesNotHeal() {
        Player player = new Player();

        player.takeDamage(-20);

        assertEquals(100, player.health());
    }
}
