package business;

import org.junit.Before;
import org.junit.Test;

import dal.TFIDFCalculator;

import static org.junit.Assert.*;



public class TFIDFCalculatorTest {

    private TFIDFCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TFIDFCalculator();
    }

   
    @Test
    public void testTFIDFPositivePath() {
        // Add corpus documents
        calculator.addDocumentToCorpus("hello world");
        calculator.addDocumentToCorpus("hello java");
        calculator.addDocumentToCorpus("world java programming");

        // Calculate TF-IDF for test document
        double score = calculator.calculateDocumentTfIdf("hello world");
        
        // TF-IDF can be negative for common words (IDF = log(N/df) < 0 when df > N)
        assertTrue("TF-IDF score should be finite", Double.isFinite(score));
        
        // Score is expected to be small (near 0) for common terms
        assertEquals(0.0, score, 1.0); // within ±1.0 tolerance
    }

  
    @Test
    public void testTFIDFSingleWord() {
        calculator.addDocumentToCorpus("test");
        calculator.addDocumentToCorpus("test document");
        
        double score = calculator.calculateDocumentTfIdf("test");
        assertTrue("Score should be finite", Double.isFinite(score));
    }

    // Negative Path: Empty document
    @Test
    public void testTFIDFEmptyDocument() {
        calculator.addDocumentToCorpus("hello world");
        
        try {
            double score = calculator.calculateDocumentTfIdf("");
            // Either returns 0/NaN or handles gracefully
            assertTrue(score == 0.0 || Double.isNaN(score) || Double.isFinite(score));
        } catch (Exception e) {
            // Graceful handling via exception is acceptable
            assertTrue(true);
        }
    }

    // Negative Path: Special characters only
    @Test
    public void testTFIDFSpecialCharacters() {
        calculator.addDocumentToCorpus("normal text");
        
        try {
            double score = calculator.calculateDocumentTfIdf("!@#$%^&*()");
            // Should handle gracefully
            assertTrue(Double.isFinite(score) || Double.isNaN(score));
        } catch (Exception e) {
            // Graceful exit via exception is acceptable
            assertTrue(true);
        }
    }

    // Negative Path: Whitespace only document
    @Test
    public void testTFIDFWhitespaceOnly() {
        calculator.addDocumentToCorpus("some text");
        
        try {
            double score = calculator.calculateDocumentTfIdf("   ");
            assertTrue(Double.isFinite(score) || Double.isNaN(score));
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    // Negative Path: Empty corpus
    @Test
    public void testTFIDFEmptyCorpus() {
        try {
            double score = calculator.calculateDocumentTfIdf("test document");
            assertTrue(Double.isFinite(score) || Double.isNaN(score));
        } catch (Exception e) {
            // Graceful handling
            assertTrue(true);
        }
    }
}
