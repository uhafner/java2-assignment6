package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score of a small straight, i.e. the roll 1, 2, 3, 4 or 2, 3, 4, 5, or 3, 4, 5, 6.
 *
 * @author Ullrich Hafner
 */
public class SmallStraight extends AbstractYahtzeeEvaluator {
    @Override
    public int getScore(final int... faces) {
        FaceCounter one = new FaceCounter(1);
        FaceCounter two = new FaceCounter(2);
        FaceCounter three = new FaceCounter(3);
        FaceCounter four = new FaceCounter(4);
        FaceCounter five = new FaceCounter(5);
        FaceCounter six = new FaceCounter(6);

        if (containsBoth(three, four, faces)
                && (containsBoth(one, two, faces)
                        || containsBoth(two, five, faces)
                        || containsBoth(five, six, faces))) {
            return 30;
        }
        return 0;
    }

    private boolean containsBoth(final FaceCounter first, final FaceCounter second, final int... faces) {
        return first.computeScore(faces) > 0 && second.computeScore(faces) > 0;
    }
}
