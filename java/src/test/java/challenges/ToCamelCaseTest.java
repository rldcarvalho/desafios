package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToCamelCaseTest {

    @Test
    void deveriaRemoverCaracteresEspeciaisEFormatarAsStringsEmCamelCase(){
        assertEquals("theStealthWarrior", ToCamelCase.toCamelCase("the_Stealth_Warrior"));
        assertEquals("TheStealthWarrior", ToCamelCase.toCamelCase("The__stealth_warrior"));
        assertEquals("theStealthWarrior", ToCamelCase.toCamelCase("the-Stealth-Warrior"));
        assertEquals("theStealthWarrior", ToCamelCase.toCamelCase("the-stealth-warrior"));
    }

}