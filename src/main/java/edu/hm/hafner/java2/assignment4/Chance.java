package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score by adding all dice faces.
 *
 * @author Ullrich Hafner
 */
public class Chance extends AbstractYahtzeeEvaluator {
    @Override
    public int getScore(final int... faces) {
        int sum = 0;
        for (int face : faces) {
            sum += face;
        }
        return sum;
    }
}
