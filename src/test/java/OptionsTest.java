import model.GameGraph;
import model.UFOQuestGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsTest {

    static GameGraph graph = new UFOQuestGraph();

    @Test
    void SHOW_QUEST1_OPTIONS() {
        String acceptOption = "Accept the challenge";
        assertEquals(acceptOption, graph.getOption(0)[0]);
        String rejectOption = "Reject the challenge";
        assertEquals(rejectOption, graph.getOption(0)[1]);
    }

    @Test
    void SHOW_QUEST2_OPTIONS() {
        String acceptOption = "Go up to the bridge";
        assertEquals(acceptOption, graph.getOption(1)[0]);
        String rejectOption = "Refuse to go up to the bridge";
        assertEquals(rejectOption, graph.getOption(1)[1]);
    }

    @Test
    void SHOW_QUEST3_OPTIONS() {
        String acceptOption = "Tell the truth about yourself";
        assertEquals(acceptOption, graph.getOption(2)[0]);
        String rejectOption = "Lie about yourself";
        assertEquals(rejectOption, graph.getOption(2)[1]);
    }
}
