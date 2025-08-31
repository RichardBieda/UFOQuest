package model;

import model.UFOQuestGame.UFOText;

/**
 * This class implements the GameGraph interface that provides methods to use in Servlets and jstl.
 */

public final class UFOQuestGraph implements GameGraph {

    public static final String[] LEVELS = {UFOText.FIRST_QUESTION.getText(), UFOText.SECOND_QUESTION.getText(), UFOText.THIRD_QUESTION.getText()};

    public static final String[][] OPTIONS = {{UFOText.FIRST_ACCEPT.getText(), UFOText.FIRST_REJECT.getText()},
                                             {UFOText.SECOND_ACCEPT.getText(), UFOText.SECOND_REJECT.getText()},
                                             {UFOText.THIRD_ACCEPT.getText(), UFOText.THIRD_REJECT.getText()}};

    public static final String[] FINISH = {UFOText.FIRST_DEFEAT.getText(), UFOText.SECOND_DEFEAT.getText(), UFOText.THIRD_DEFEAT.getText(), UFOText.VICTORY.getText()};

    public UFOQuestGraph() {
    }

    /***
     * Returns true if the LEVELS array has a next element.
     * This method is called in the AnswerServlet.
     * @param level (will be a session attribut)
     */
    @Override
    public boolean hasNext(int level) {
        if (level < 0) return false;
        return level < LEVELS.length -1;
    }

    /***
     * Returns a String LEVEL[level].
     * This method is called in the quest.jsp file
     * @param level (will be a session attribut)
     */
    @Override
    public String getQuestion(int level) {
        return LEVELS[level];
    }

    /***
     * Returns the inner array of OPTIONS[].
     * This method is called in the quest.jsp file.
     * Instead of branches, it uses an index.
     * @param level (will be a session attribut)
     */
    @Override
    public String[] getOption(int level) {
        return OPTIONS[level];
    }

    /***
     * Returns a String FINISH[level].
     * This method is called in the finish.jsp file.
     * @param level (will be a session attribut)
     */
    @Override
    public String getFinish(int level) {
        return FINISH[level];
    }

    /***
     * Returns true if the clients answer to a question is correct.
     * In this specific case the first option of each question is the correct answer.
     * This method is called in the Answer Servlet.

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
