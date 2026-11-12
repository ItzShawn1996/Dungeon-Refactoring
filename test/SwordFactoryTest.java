import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.swords.*;

/**
 * Unit tests for the SwordFactory class.
 *
 * Verifies that the factory creates the correct sword
 * objects based on the specified type, including
 * handling invalid and null inputs.
 */
public class SwordFactoryTest {

    /**
     * Verifies that requesting a wooden sword
     * creates an instance of WoodSword.
     */
    @Test
    void testCreateWoodSword() {
        Sword sword = SwordFactory.createSword(
                SWORD_TYPE.WOOD.getValue()
        );

        assertNotNull(sword);
        assertInstanceOf(WoodSword.class, sword);
    }

    /**
     * Verifies that requesting a metal sword
     * creates an instance of MetalSword.
     */
    @Test
    void testCreateMetalSword() {
        Sword sword = SwordFactory.createSword(
                SWORD_TYPE.METAL.getValue()
        );

        assertNotNull(sword);
        assertInstanceOf(MetalSword.class, sword);
    }

    /**
     * Verifies that requesting a gold sword
     * creates an instance of GoldSword.
     */
    @Test
    void testCreateGoldSword() {
        Sword sword = SwordFactory.createSword(
                SWORD_TYPE.GOLD.getValue()
        );

        assertNotNull(sword);
        assertInstanceOf(GoldSword.class, sword);
    }

    /**
     * Verifies that an unrecognized sword type
     * causes the factory to return a wooden sword.
     */
    @Test
    void testInvalidSwordType() {
        Sword sword = SwordFactory.createSword("INVALID");

        assertNotNull(sword);
        assertInstanceOf(WoodSword.class, sword);
    }

    /**
     * Verifies that a null input causes the factory
     * to return a wooden sword instead of throwing
     * an exception.
     */
    @Test
    void testNullSwordType() {
        Sword sword = SwordFactory.createSword(null);

        assertNotNull(sword);
        assertInstanceOf(WoodSword.class, sword);
    }
}
