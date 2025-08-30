package model;

import model.UFOQuestGame.UFOText;

/**
 * This class implements the GameGraph interface that provides methods to use in Servlets and jstl.
 */

public final class QGraph implements GameGraph {

    public static final String[] LEVELS = {UFOText.FIRST_QUESTION.getText(), UFOText.SECOND_QUESTION.getText(), UFOText.THIRD_QUESTION.getText()};

    public static final String[][] OPTIONS = {{UFOText.FIRST_ACCEPT.getText(), UFOText.FIRST_REJECT.getText()},
                                             {UFOText.SECOND_ACCEPT.getText(), UFOText.SECOND_REJECT.getText()},
                                             {UFOText.THIRD_ACCEPT.getText(), UFOText.THIRD_REJECT.getText()}};

    public static final String[] FINISH = {UFOText.FIRST_DEFEAT.getText(), UFOText.SECOND_DEFEAT.getText(), UFOText.THIRD_DEFEAT.getText(), UFOText.VICTORY.getText()};

    public QGraph() {
    }

    /**
     * returns true if the LEVELS array has a next element.
     * this method is called in the AnswerServlet.
     * @param level (will be a session attribut)
     */
    @Override
    public boolean hasNext(int level) {
        if (level < 0) return false;
        return level < LEVELS.length -1;
    }

    /**
     * returns a String LEVEL[level].
     * @param level (will be a session attribut)
     */
    @Override
    public String getQuestion(int level) {
        return LEVELS[level];
    }

    /**
     * returns the inner array of OPTIONS.
     * instead of branches, it uses an index.
     * @param level (will be a session attribut)
     */
    @Override
    public String[] getOption(int level) {
        return OPTIONS[level];
    }

    /**
     * returns a String FINISH[level].
     * @param level (will be a session attribut)
     */
    @Override
    public String getFinish(int level) {
        return FINISH[level];
    }

    /**
     * returns true if the clients answer to a question is correct.
     * In this specific case the first option of each question is the correct answer.

     * The game will be won if the last question is answered correctly, and there is no more questions left.
     * if isAnswerRight(2, 0) && !hasNext(2)

     * @param level (will be a session attribut)
     * @param option (will be the result of a doPost method in the WEB-INT/quest.jsp file)
     */
    @Override
    public boolean isAnswerRight(int level, int option) {
        return option == 0;
    }
}
