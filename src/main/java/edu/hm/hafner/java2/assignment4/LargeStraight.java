package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * Computes the score of a large straight, i.e. the roll
 * 1, 2, 3, 4, 5 or 2, 3, 4, 5, 6.
 * The score of a large straight is 40 points.
 *
 * @author Ullrich Hafner
 */
public class LargeStraight extends AbstractYahtzeeEvaluator {
    @Override
    public int getScore(final int... faces) {
        int[] sortedFaces = Arrays.copyOf(faces, faces.length);
        Arrays.sort(sortedFaces);

        int currentFace = sortedFaces[0];
        for (int face : sortedFaces) {
            if (face != currentFace) {
                return 0;
            }
            currentFace++;
        }
        return 40;
    }
}
