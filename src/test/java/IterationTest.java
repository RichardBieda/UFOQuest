import model.GameGraph;
import model.QGraph;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IterationTest {

    static GameGraph graph = new QGraph();

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "0, true",
            "1, true",
            "2, false",
            "3, false"
    })
    void HAS_NEXT_ELEMENT_TEST(int level, boolean test) {
        assertEquals(test, graph.hasNext(level));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, true",
            "0, 1, false",
            "1, 0, true",
            "1, 1, false",
            "2, 0, true",
            "2, 1, false",
    })
    void TEST_FINISH_BRANCHES(int level, int option, boolean output) {
        assertEquals(output, graph.isAnswerRight(level, option));
    }
}
