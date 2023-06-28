package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score of a Yahtzee.
 *
 * @author Ullrich Hafner
 */
public class Yahtzee extends AbstractYahtzeeEvaluator {
    @Override
    public int getScore(final int... faces) {
        SeveralOfAKind yahtzee = new SeveralOfAKind(5);
        if (yahtzee.computeScore(faces) > 0) {
            return 50;
        }
        return 0;
    }
}
