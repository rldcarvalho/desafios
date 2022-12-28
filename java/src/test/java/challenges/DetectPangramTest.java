package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectPangramTest {

    @Test
    void deveriaRetornarTrueApenasAoReceberUmaStringPangram(){
        String exemple1 = "The quick brown fox jumps over the lazy dog.";
        String exemple2 = "You shall not pass!";

        assertTrue(DetectPangram.check(exemple1));
        assertFalse(DetectPangram.check(exemple2));
    }

}