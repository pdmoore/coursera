import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolverTest {

    @Test
    void Constructor_NullValueNotAllowed() {
        Executable constructorWithNullParameter = () -> new Solver(null);
        assertThrows(IllegalArgumentException.class, constructorWithNullParameter, "ctor should throw exception when passed null");
    }
}
