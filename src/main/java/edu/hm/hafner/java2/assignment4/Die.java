package edu.hm.hafner.java2.assignment4;

/**
 * A die is a six-sided cube. A die can be rolled and has a number on each side (face), and is part of many betting
 * games and board games.
 *
 * @author Ullrich Hafner
 */
public interface Die {
    /**
     * Rolls this die.
     */
    void roll();

    /**
     * Returns the face on top of this die.
     *
     * @return the visible face (in the range [1, ..., 6])
     */
    int getFace();
}
