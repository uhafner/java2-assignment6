package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score of a Yahtzee roll.
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractYahtzeeEvaluator implements YahtzeeEvaluator {
    private static final DiceValidator DICE_VALIDATOR = new DiceValidator();

    @Override
    public final int computeScore(final int... faces) {
        DICE_VALIDATOR.validateRoll(faces);

        return getScore(faces);
    }

    /**
     * Computes the score of a Yahtzee roll.
     *
     * @param faces
     *         the dice faces of the roll
     *
     * @return the score of the roll
     */
    protected abstract int getScore(int... faces);
}
