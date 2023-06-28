package edu.hm.hafner.java2.assignment4;

/**
 * Computes the score by summing the total number of dice faces matching that specified value.
 * Instances of this class are immutable.
 *
 * @author Ullrich Hafner
 */
public class FaceCounter extends AbstractYahtzeeEvaluator {
    private static final DiceValidator DICE_VALIDATOR = new DiceValidator();
    private final int diceFace;

    /**
     * Creates a new instance of {@link FaceCounter}.
     *
     * @param diceFace the dice face to count
     */
    public FaceCounter(final int diceFace) {
        super();

        DICE_VALIDATOR.validateFaces(diceFace);

        this.diceFace = diceFace;
    }

    @Override
    public int getScore(final int... faces) {
        int sum = 0;
        for (int face : faces) {
            if (face == diceFace) {
                sum += face;
            }
        }
        return sum;
    }
}
