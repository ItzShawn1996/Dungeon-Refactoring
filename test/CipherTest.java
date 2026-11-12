
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.Cipher;

/**
 * Unit tests for the Cipher class.
 *
 * Verifies encryption and decryption functionality
 * using normal text, empty strings, numbers,
 * special characters, and Unicode characters.
 */
public class CipherTest {

    /**
     * Verifies that encrypting normal text produces
     * a result different from the original message.
     */
    @Test
    void testEncryptNormalText() {
        String encrypted = Cipher.encrypt("Hello");

        assertNotEquals("Hello", encrypted);
    }

    /**
     * Verifies that decrypting encrypted text
     * restores the original message.
     */
    @Test
    void testDecryptNormalText() {
        String encrypted = Cipher.encrypt("Hello");
        String decrypted = Cipher.decrypt(encrypted);

        assertEquals("Hello", decrypted);
    }

    /**
     * Verifies that encrypting an empty string
     * returns an empty string.
     */
    @Test
    void testEncryptEmptyString() {
        assertEquals("", Cipher.encrypt(""));
    }

    /**
     * Verifies that decrypting an empty string
     * returns an empty string.
     */
    @Test
    void testDecryptEmptyString() {
        assertEquals("", Cipher.decrypt(""));
    }

    /**
     * Verifies that numeric characters can be encrypted
     * and decrypted without losing information.
     */
    @Test
    void testEncryptNumbers() {
        String original = "12345";

        String encrypted = Cipher.encrypt(original);

        assertEquals(original, Cipher.decrypt(encrypted));
    }

    /**
     * Verifies that special characters are preserved
     * after encryption and decryption.
     */
    @Test
    void testEncryptSpecialCharacters() {
        String original = "!@#$%";

        String encrypted = Cipher.encrypt(original);

        assertEquals(original, Cipher.decrypt(encrypted));
    }

    /**
     * Verifies that Unicode characters can be encrypted
     * and decrypted to recover the original text.
     */
    @Test
    void testEncryptUnicode() {
        String original = "你好";

        String encrypted = Cipher.encrypt(original);
        String decrypted = Cipher.decrypt(encrypted);

        assertEquals(original, decrypted);
    }
}
