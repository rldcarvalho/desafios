package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NarcissisticNumberTest {

    @Test
    void deveriaRetornarTrueSeONumeroForNarcisista(){
        assertTrue(NarcissisticNumber.isNarcissistic(153));
        assertTrue(NarcissisticNumber.isNarcissistic(1634));
        assertFalse(NarcissisticNumber.isNarcissistic(112));
    }

}