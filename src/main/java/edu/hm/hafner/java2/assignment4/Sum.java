package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * A sum in the score board that sums up all enclosed rows.
 *
 * @author Ullrich Hafner
 */
public class Sum extends Row {
    private final Row[] entries;

    /**
     * Creates a new sum with the specified name that dynamically computes the sum of its containing rows.
     *
     * @param displayName
     *         name of the category
     * @param entries
     *         the entries that will be summed up
     */
    public Sum(final String displayName, final Row... entries) {
        super(displayName);

        this.entries = Arrays.copyOf(entries, entries.length);
    }

    @Override
    public int getScore() {
        return Arrays.stream(entries).mapToInt(Row::getScore).sum();
    }
}
