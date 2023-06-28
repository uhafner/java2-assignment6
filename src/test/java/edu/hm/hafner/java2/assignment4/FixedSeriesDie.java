package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * A die with a predictable result that can be used in tests.
 *
 * @author Ullrich Hafner
 */
class FixedSeriesDie implements Die {
    private final int[] faces;
    private int position;

    FixedSeriesDie(final int... faces) {
        this.faces = Arrays.copyOf(faces, faces.length);
    }

    @Override
    public void roll() {
        position++;
        if (position == faces.length) {
            position = 0;
        }
    }

    @Override
    public int getFace() {
        return faces[position];
    }
}
