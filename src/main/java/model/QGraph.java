package model;

import model.UFOQuestGame.UFOText;

public final class QGraph implements GameGraph {

    public static final String[] LEVELS = {UFOText.FIRST_QUESTION.getText(), UFOText.SECOND_QUESTION.getText(), UFOText.THIRD_QUESTION.getText()};

    public static final String[][] OPTIONS = {{UFOText.FIRST_ACCEPT.getText(), UFOText.FIRST_REJECT.getText()},
                                             {UFOText.SECOND_ACCEPT.getText(), UFOText.SECOND_REJECT.getText()},
                                             {UFOText.THIRD_ACCEPT.getText(), UFOText.THIRD_REJECT.getText()}};

    public static final String[] FINISH = {UFOText.FIRST_DEFEAT.getText(), UFOText.SECOND_DEFEAT.getText(), UFOText.THIRD_DEFEAT.getText(), UFOText.VICTORY.getText()};

    public QGraph() {
    }

    @Override
    public boolean hasNext(int level) {
        if (level < 0) return false;
        return level < LEVELS.length -1;
    }

    @Override
    public String getQuestion(int level) {
        return LEVELS[level];
    }

    @Override
    public String[] getOption(int level) {
        return OPTIONS[level];
    }

    @Override
    public String getFinish(int level) {
        return FINISH[level];
    }

    @Override
    public boolean isAnswerRight(int level, int option) {
        return option == 0;
    }
}
