import model.GameGraph;
import model.QGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestGraphTest {

    static GameGraph graph = new QGraph();

    @Test
    void TEST_QUEST_1() {
        String output = "You lost your memory.\nAccept the UFO challenge";
        assertEquals(output, graph.getQuestion(0));
    }

    @Test
    void TEST_QUEST_2() {
        String output = "You accepted the challenge.\nAre you going up to the captains bridge?";
        assertEquals(output, graph.getQuestion(1));
    }

    @Test
    void TEST_QUEST_3() {
        String output = "You've gone up to the bridge.\nWho are you?";
        assertEquals(output, graph.getQuestion(2));
    }

    @Test
    void TEST_VICTORY() {
        String output = "You've been returned home.\nVICTORY";
        assertEquals(output, graph.getFinish(3));
    }

    @Test
    void TEST_DEFEAT_1() {
        String output = "You rejected the challenge.\nDEFEAT";
        assertEquals(output, graph.getFinish(0));
    }

    @Test
    void TEST_DEFEAT_2() {
        String output = "You didn't attend the negotiations.\nDEFEAT";
        assertEquals(output, graph.getFinish(1));
    }

    @Test
    void TEST_DEFEAT_3() {
        String output = "Your lie has been revealed\nDEFEAT";
        assertEquals(output, graph.getFinish(2));
    }
}
