package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * Convenience method to validate dice faces.
 *
 * @author Ullrich Hafner
 */
public class DiceValidator {
    private static final int DICE_CUP_LENGTH = 5;
    private static final int ONE = 1;
    private static final int SIX = 6;

    /**
     * Validates the provided dice faces.
     *
     * @param faces
     *         the faces to validate
     *
     * @throws NullPointerException
     *         if the faces are {@code null}
     * @throws IllegalArgumentException
     *         if the number of dice is not 5, or a dice face is not in the interval [1, 6]
     */
    public void validateRoll(final int... faces) {
        if (faces.length != DICE_CUP_LENGTH) {
            throw new IllegalArgumentException("Yahtzee is played with 5 dice: " + Arrays.toString(faces));
        }
        validateFaces(faces);
    }

    /**
     * Validates the provided dice faces.
     *
     * @param faces
     *         the faces to validate
     *
     * @throws NullPointerException
     *         if the faces are {@code null}
     * @throws IllegalArgumentException
     *         if a dice face is not in the interval [1, 6]
     */
    public void validateFaces(final int... faces) {
        for (int face : faces) {
            if (face < ONE || face > SIX) {
                throw new IllegalArgumentException("A dice face must be in range [1, 6]: " + face);
            }
        }
    }
}
