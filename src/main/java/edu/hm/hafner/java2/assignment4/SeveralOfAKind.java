package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score of three-of-one-kind or four-of-a-kind. The score is the sum of all dice.
 * Instances of this class are immutable.
 *
 * @author Ullrich Hafner
 */
public class SeveralOfAKind extends AbstractYahtzeeEvaluator {
    private final int sequence;

    /**
     * Creates a new instance of {@link SeveralOfAKind}.
     *
     * @param sequence the number of dice faces of this sequence: 3=three-of-one-kind, 4=four-of-a-kind
     */
    public SeveralOfAKind(final int sequence) {
        super();

        if (sequence < 2 || sequence > 5) {
            throw new IllegalArgumentException("A sequence for 5 faces must be in range [1, 5]: " + sequence);
        }

        this.sequence = sequence;
    }

    @Override
    public int getScore(final int... faces) {
        int sum = 0;
        for (int face : faces) {
            sum += face;
        }
        for (int face = 6; face > 0; face--) {
            FaceCounter faceScore = new FaceCounter(face);
            if (faceScore.computeScore(faces) >= sequence * face) {
                return sum;
            }
        }
        return 0;
    }
}
