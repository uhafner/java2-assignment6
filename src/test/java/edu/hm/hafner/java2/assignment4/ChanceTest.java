package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Chance}.
 *
 * @author Ullrich Hafner
 */
class ChanceTest extends AbstractYahtzeeTest {
    @Test
    void shouldSumFacesForMinimum() {
        Chance counter = new Chance();

        assertThat(counter.computeScore(1, 1, 1, 1, 1)).isEqualTo(5);
    }

    @Test
    void shouldSumFacesForMaximum() {
        Chance counter = new Chance();

        assertThat(counter.computeScore(6, 6, 6, 6, 6)).isEqualTo(30);
    }

    @Test
    void shouldSumFacesForMiddle() {
        Chance counter = new Chance();

        assertThat(counter.computeScore(1, 2, 3, 4, 5)).isEqualTo(15);
    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new Chance();
    }
}
