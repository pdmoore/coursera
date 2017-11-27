import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolverTest {

    @Test
    public void Constructor_NullValueNotAllowed() {
        Executable constructorWithNullParamter = () -> {
            new Solver(null);
        };
        assertThrows(IllegalArgumentException.class, constructorWithNullParamter, "ctor should throw exception when passed null");
    }
}
