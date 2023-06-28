package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * A dice cup can roll a given set of dice.
 *
 * @author Ullrich Hafner
 */
public class DiceCup {
    private final Die[] dice;

    /**
     * Creates a new dice cup with the specified number of dice.
     *
     * @param number
     *         the number of dice
     */
    public DiceCup(final int number) {
        if (number < 1) {
            throw new IllegalArgumentException("At least one die is required: " + number);
        }
        dice = new Die[number];
        for (int i = 0; i < number; i++) {
            dice[i] = new RandomDie();
        }
    }

    /**
     * Creates a new dice cup with the specified dice.
     *
     * @param dice
     *         the dice for this cup
     */
    public DiceCup(final Die... dice) {
        if (dice.length < 1) {
            throw new IllegalArgumentException("At least one dice is required");
        }
        this.dice = Arrays.copyOf(dice, dice.length);
    }

    /**
     * Rolls the dice that are not part of the indices that are given by {@code unchangedPositions}.
     *
     * @param unchangedPositions
     *         the indices to retain
     *
     * @return the faces of all dice (after rolling)
     */
    public int[] roll(final int... unchangedPositions) {
        if (unchangedPositions.length >= dice.length) {
            throw new IllegalArgumentException(
                    String.format("The number %d of unchanged dice must less than %d",
                            unchangedPositions.length, dice.length));
        }
        int[] toChange = new int[dice.length];
        for (int i = 0; i < toChange.length; i++) {
            toChange[i] = i;
        }
        for (int position : unchangedPositions) {
            int remove = ArrayUtils.indexOf(toChange, position);
            if (remove == -1) {
                throw new IllegalArgumentException(
                        String.format("Can't let position %d unchanged: %s", position,
                                Arrays.toString(unchangedPositions)));
            }
            toChange = ArrayUtils.remove(toChange, remove);
        }

        for (int position : toChange) {
            dice[position].roll();
        }

        return getFaces();
    }

    /**
     * Returns the faces of all dice.
     *
     * @return the faces of all dice (in the range [1, ..., 6])
     */
    public int[] getFaces() {
        return Arrays.stream(dice).mapToInt(Die::getFace).toArray();
    }

    /**
     * Returns the faces of the selected dice given by indices in {@code selectedPositions}.
     *
     * @param selectedPositions
     *         the indices to select
     *
     * @return the faces of the selected dice (in the range [1, ..., 6])
     */
    public int[] getFaces(final int... selectedPositions) {
        int[] faces = new int[selectedPositions.length];
        for (int i = 0; i < selectedPositions.length; i++) {
            faces[i] = dice[selectedPositions[i]].getFace();
        }
        return faces;
    }

    @Override
    public String toString() {
        return Arrays.toString(getFaces());
    }
}
