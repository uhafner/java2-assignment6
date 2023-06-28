package edu.hm.hafner.java2.assignment4;

/**
 * An entry in the score board that holds an instance of {@link YahtzeeEvaluator}.
 *
 * @author Ullrich Hafner
 */
public class Entry extends Row {
    private final YahtzeeEvaluator evaluator;

    private int score;
    private boolean chosen;

    /**
     * Creates a new entry for the score board.
     *
     * @param displayName
     *         the display name
     * @param evaluator
     *         the score evaluator
     */
    public Entry(final String displayName, final YahtzeeEvaluator evaluator) {
        super(displayName);

        this.evaluator = evaluator;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String printScore() {
        if (isChosen()) {
            return super.printScore();
        }
        return EMPTY;
    }

    public boolean isChosen() {
        return chosen;
    }

    /**
     * Choose this entry and create the score from the specified faces. Afterward, this entry is marked as chosen and
     * cannot be chosen again.
     *
     * @param faces
     *         the faces to use
     *
     * @throws IllegalArgumentException
     *         if the entry has been used already
     */
    public void choose(final int... faces) {
        if (chosen) {
            throw new IllegalArgumentException("This entry is already chosen: " + this);
        }
        score = evaluator.computeScore(faces);
        chosen = true;
    }

    /**
     * Returns the possible score for this entry for the given faces.
     *
     * @param faces
     *         the faces of the roll
     *
     * @return the possible score
     */
    public int evaluateScore(final int... faces) {
        if (chosen) {
            throw new IllegalArgumentException("This entry is already chosen: " + this);
        }

        return evaluator.computeScore(faces);
    }
}
