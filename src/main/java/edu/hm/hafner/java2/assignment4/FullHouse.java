package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score of a full house.
 *
 * @author Ullrich Hafner
 */
public class FullHouse extends AbstractYahtzeeEvaluator {
    private static final int THREE_OF_KIND = 3;
    private static final int PAIR = 2;

    @Override
    public int getScore(final int... faces) {
        int[] faceCount = new int[6];
        for (int face : faces) {
            faceCount[face - 1]++;
        }
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for (int i : faceCount) {
            if (i == THREE_OF_KIND) {
                hasThreeOfAKind = true;
            }
            if (i == PAIR) {
                hasPair = true;
            }
        }

        if (hasThreeOfAKind && hasPair) {
            return 25;
        }
        return 0;
    }
}
