package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TribonacciSequenceTest {

    @Test
    void deveriaRetornarASequenciaDeTribonacci(){
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, TribonacciSequence.tribonacci(new double []{1,1,1},10));
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, TribonacciSequence.tribonacci(new double []{0,0,1},10));
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, TribonacciSequence.tribonacci(new double []{0,1,1},10));
    }

}