
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.player.Player;

/**
 * Unit tests for the Player class.
 *
 * Verifies player initialization, health management,
 * potion usage, combat, equipment, and player statistics.
 */
public class PlayerTest {

    /**
     * Verifies that a new player starts with full health.
     */
    @Test
    void testInitialHealth() {
        Player player = new Player();

        assertEquals(100, player.health());
    }

    /**
     * Verifies that a new player starts with three potions.
     */
    @Test
    void testInitialPotions() {
        Player player = new Player();

        assertEquals(3, player.getPotions());
    }

    /**
     * Verifies that a new player has an empty default name.
     */
    @Test
    void testInitialName() {
        Player player = new Player();

        assertEquals("", player.getName());
    }

    /**
     * Verifies that a new player starts without
     * a sword or armor.
     */
    @Test
    void testInitialEquipment() {
        Player player = new Player();

        assertFalse(player.hasSword());
        assertFalse(player.hasArmour());
        assertNull(player.getSword());
        assertNull(player.getArmour());
    }

    /**
     * Verifies that the player's name can be updated.
     */
    @Test
    void testSetName() {
        Player player = new Player();

        player.setName("Hero");

        assertEquals("Hero", player.getName());
    }

    /**
     * Verifies that valid health values update
     * the player's current health.
     */
    @Test
    void testSetHealth() {
        Player player = new Player();

        player.setHealth(75);

        assertEquals(75, player.health());
    }

    /**
     * Verifies that health values outside the valid
     * range do not change the player's health.
     */
    @Test
    void testInvalidHealth() {
        Player player = new Player();

        player.setHealth(-10);
        assertEquals(100, player.health());

        player.setHealth(150);
        assertEquals(100, player.health());
    }

    /**
     * Verifies that taking positive damage reduces
     * the player's health by the specified amount.
     */
    @Test
    void testTakeDamage() {
        Player player = new Player();

        player.takeDamage(25);

        assertEquals(75, player.health());
    }

    /**
     * Verifies that using a potion restores health
     * and decreases the number of available potions.
     */
    @Test
    void testUsePotion() {
        Player player = new Player();
        player.setHealth(50);

        player.usePotion();

        assertEquals(80, player.health());
        assertEquals(2, player.getPotions());
    }

    /**
     * Verifies that attempting to use a potion when
     * none remain does not change health or potion count.
     */
    @Test
    void testCannotUsePotionWhenEmpty() {
        Player player = new Player();
        player.setHealth(50);
        player.setNumberOfPotions(0);

        player.usePotion();

        assertEquals(50, player.health());
        assertEquals(0, player.getPotions());
    }

    /**
     * Verifies that adding potions increases
     * the player's potion inventory.
     */
    @Test
    void testAddPotions() {
        Player player = new Player();

        player.addPotions(5);

        assertEquals(8, player.getPotions());
    }

    /**
     * Verifies that defeating an enemy increases
     * the player's enemy kill count.
     */
    @Test
    void testIncreaseEnemiesKilled() {
        Player player = new Player();

        player.increaseEnemiesKilled();

        assertEquals(1, player.enemiesKilled());
    }

    /**
     * Verifies that attacking without a sword produces
     * damage within the base attack damage range.
     */
    @Test
    void testAttackWithoutSword() {
        Player player = new Player();

        int damage = player.attack();

        assertTrue(damage >= 0);
        assertTrue(damage < Player.BASE_ATTACK_DAMAGE);
    }

    /**
     * Verifies that potion healing does not increase
     * the player's health beyond the maximum of 100.
     *
     * Known failure: The original implementation
     * allows health to exceed the maximum.
     */
    @Test
    void testPotionDoesNotExceedMaxHealth() {
        Player player = new Player();
        player.setHealth(90);

        player.usePotion();

        assertEquals(100, player.health());
    }

    /**
     * Verifies that receiving negative damage
     * does not increase the player's health.
     *
     * Known failure: The original implementation
     * treats negative damage as healing.
     */
    @Test
    void testNegativeDamageDoesNotHeal() {
        Player player = new Player();

        player.takeDamage(-20);

        assertEquals(100, player.health());
    }
}
