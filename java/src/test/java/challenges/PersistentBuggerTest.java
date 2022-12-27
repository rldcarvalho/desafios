package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistentBuggerTest {

    @Test
    void deveriaMultiplicarOsElementosDeUmNumeroAteRetornarMenorQueDez(){
        assertEquals(3, PersistentBugger.persistence(39));
        assertEquals(0, PersistentBugger.persistence(4));
        assertEquals(2, PersistentBugger.persistence(25));
        assertEquals(4, PersistentBugger.persistence(999));
    }

}