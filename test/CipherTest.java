import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.Cipher;

public class CipherTest {

    @Test
    void testEncryptNormalText() {
        String encrypted = Cipher.encrypt("Hello");

        assertNotEquals("Hello", encrypted);
    }

    @Test
    void testDecryptNormalText() {
        String encrypted = Cipher.encrypt("Hello");
        String decrypted = Cipher.decrypt(encrypted);

        assertEquals("Hello", decrypted);
    }

    @Test
    void testEncryptEmptyString() {
        assertEquals("", Cipher.encrypt(""));
    }

    @Test
    void testDecryptEmptyString() {
        assertEquals("", Cipher.decrypt(""));
    }

    @Test
    void testEncryptNumbers() {
        String original = "12345";

        String encrypted = Cipher.encrypt(original);

        assertEquals(original, Cipher.decrypt(encrypted));
    }

    @Test
    void testEncryptSpecialCharacters() {
        String original = "!@#$%";

        String encrypted = Cipher.encrypt(original);

        assertEquals(original, Cipher.decrypt(encrypted));
    }

    @Test
    void testEncryptUnicode() {
        String original = "你好";

        String encrypted = Cipher.encrypt(original);
        String decrypted = Cipher.decrypt(encrypted);

        assertEquals(original, decrypted);
    }
}
