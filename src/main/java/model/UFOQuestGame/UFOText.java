package model.UFOQuestGame;

public enum UFOText {

    FIRST_QUESTION("You lost your memory.\nAccept the UFO challenge"),
    SECOND_QUESTION("You accepted the challenge.\nAre you going up to the captains bridge?"),
    THIRD_QUESTION("You've gone up to the bridge.\nWho are you?"),
    FIRST_ACCEPT("Accept the challenge"),
    SECOND_ACCEPT("Go up to the bridge"),
    THIRD_ACCEPT("Tell the truth about yourself"),
    FIRST_REJECT("Reject the challenge"),
    SECOND_REJECT("Refuse to go up to the bridge"),
    THIRD_REJECT("Lie about yourself"),
    FIRST_DEFEAT("You rejected the challenge.\nDEFEAT"),
    SECOND_DEFEAT("You didn't attend the negotiations.\nDEFEAT"),
    THIRD_DEFEAT("Your lie has been revealed\nDEFEAT"),
    VICTORY("You've been returned home.\nVICTORY");

    private final String text;

    UFOText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
