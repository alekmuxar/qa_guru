package docs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class jUnitAnnotation {

    @BeforeAll
    void setup()

    @Test
    void someTest() {
        System.out.println("someTest here");
        assertTrue(true);
    }
}