package UniqueNamesCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNamesTest {

    @Test
    void countUniqueNames() {
        CountNames C = new CountNames();

        System.out.println(C.countUniqueNames("Deborah", "Egli", "Deborah", "Egli", "Deborah Egli"));//1
        System.out.println(C.countUniqueNames("Deborah", "Egli", "Debbie", "Egli", "Debbie Egli"));//1
        System.out.println(C.countUniqueNames("Deborah", "Egni", "Deborah", "Egli", "Deborah Egli"));//1
        System.out.println(C.countUniqueNames("Deborah S", "Egli", "Deborah", "Egli", "Egli Deborah"));//1
        System.out.println(C.countUniqueNames("Michele", "Egli", "Deborah", "Egli", "Michele Egli"));//2

//My tests:
        System.out.println(C.countUniqueNames("MicHeLe", "egLi", "DeBorAh", "EgLi", "Michele Egli"));//2-Case sensitive
        System.out.println(C.countUniqueNames("Deborah", "Egli", "Deborh", "Egni", "Egli Deb Deborah"));//1-Middle names,typos and crossed name on card
        System.out.println(C.countUniqueNames("Deborah D", "Egli", "Deborah", "Egni", "Egli E Michele"));//2-Middle names,typos and and crossed name on card
        System.out.println(C.countUniqueNames("jane", "Smith", "janie", "Smith", "jean E Smith"));//1-Different nicknames
        System.out.println(C.countUniqueNames("Deborah", "Smith", "Michele", "Egli", "JEFF E Williams"));//3-Different people

    }
}