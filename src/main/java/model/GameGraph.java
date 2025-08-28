package model;

public interface GameGraph {

    boolean hasNext(int level);
    String getQuestion(int level);
    String[] getOption(int level);
    String getFinish(int level);
    boolean isAnswerRight(int level, int option);
}
