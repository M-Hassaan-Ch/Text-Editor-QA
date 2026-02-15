package persistence;

import org.junit.Test;
import dal.HashCalculator;
import static org.junit.Assert.*;

public class HashIntegrityTest {

    @Test
    public void hashChangesOnEdit() throws Exception {
        String original = "Hello World";
        String edited = "Hello World!";
        String originalHash = HashCalculator.calculateHash(original);
        String editedHash = HashCalculator.calculateHash(edited);
        assertNotEquals(originalHash, editedHash);
    }

    @Test
    public void hashSameForSameContent() throws Exception {
        String content = "Test Content";
        String hash1 = HashCalculator.calculateHash(content);
        String hash2 = HashCalculator.calculateHash(content);
        assertEquals(hash1, hash2);
    }

    @Test
    public void originalHashRetained() throws Exception {
        String importContent = "Original Import";
        String originalHash = HashCalculator.calculateHash(importContent);
        String editedContent = "Edited Content";
        String currentHash = HashCalculator.calculateHash(editedContent);
        assertNotNull(originalHash);
        assertNotNull(currentHash);
        assertNotEquals(originalHash, currentHash);
    }

    @Test
    public void hashNotEmpty() throws Exception {
        String hash = HashCalculator.calculateHash("test");
        assertFalse(hash.isEmpty());
    }
}
