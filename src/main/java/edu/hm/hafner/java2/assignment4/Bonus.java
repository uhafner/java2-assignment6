package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * A bonus for the upper board. If the six entries sum up to 63 or more, then a bonus of 35 is achieved.
 *
 * @author Ullrich Hafner
 */
public class Bonus extends Row {
    private static final int SCORE = 35;
    private static final int BONUS_LIMIT = 62;

    private final Row[] entries;

    /**
     * Creates a new bonus.
     *
     * @param entries
     *         the six entries of the upper half of the board
     */
    public Bonus(final Row... entries) {
        super("Bonus");

        this.entries = Arrays.copyOf(entries, entries.length);
    }

    @Override
    public int getScore() {
        return Arrays.stream(entries)
                .mapToInt(Row::getScore)
                .sum() > BONUS_LIMIT ? SCORE : 0;
    }
}
