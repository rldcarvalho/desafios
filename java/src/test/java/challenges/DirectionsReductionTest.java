package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionsReductionTest {

    @Test
    void testSimpleDirReduc() {
        assertArrayEquals(new String[]{"WEST"},
                DirectionsReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals(new String[]{},
                DirectionsReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
        assertArrayEquals(new String[]{"NORTH"},
                DirectionsReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH","NORTH"}));
        assertArrayEquals(new String[]{"NORTH", "EAST"},
                DirectionsReduction.dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"}));
    }

}