package edu.hm.hafner.java2.assignment4;

/**
 * Evaluates the dice faces of a roll. A roll contains 5 dice that will be evaluated by a given category,
 * e.g., full house, street, etc.
 *
 * @author Ullrich Hafner
 */
public interface YahtzeeEvaluator {
    /**
     * Computes the score of a Yahtzee roll.
     *
     * @param faces
     *         the dice faces of the roll
     *
     * @return the score of the roll
     * @throws IllegalArgumentException
     *         if the number of dice faces is not 5 or if one of these dice faces is not in the interval [1, 6]
     */
    int computeScore(int... faces);
}
