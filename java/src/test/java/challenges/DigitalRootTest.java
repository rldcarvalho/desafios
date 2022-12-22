package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalRootTest {

    @Test
    void deveriaRetornarARaizDigitalDoNumeroInformado(){
        assertEquals(7, DigitalRoot.digital_root(16));
        assertEquals(6, DigitalRoot.digital_root(456));
    }

}