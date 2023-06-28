package edu.hm.hafner.java2.assignment4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Produces pseudo-random values in the interval [1, 6].
 *
 * @author Ullrich Hafner
 * @see Random
 */
public class RandomDie implements Die {
    private int face;

    /**
     * Creates a random dice face generator.
     */
    public RandomDie() {
        face = createRandomValue();
    }

    /**
     * Rolls this dice.
     */
    @Override
    public void roll() {
        face = createRandomValue();
    }

    @SuppressFBWarnings(value = "PREDICTABLE_RANDOM", justification = "Not that relevant for a computer game")
    private int createRandomValue() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    @Override
    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return String.valueOf(face);
    }
}
