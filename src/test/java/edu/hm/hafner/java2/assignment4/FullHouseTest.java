package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link FullHouse}.
 *
 * @author Ullrich Hafner
 */
class FullHouseTest extends AbstractYahtzeeTest {
    @Test
    void shouldScoreFullHouse() {
        FullHouse counter = new FullHouse();

        assertThat(counter.computeScore(6, 6, 6, 5, 5)).isEqualTo(25);
        assertThat(counter.computeScore(1, 2, 1, 2, 1)).isEqualTo(25);
        assertThat(counter.computeScore(3, 3, 4, 4, 4)).isEqualTo(25);
    }

    @Test
    void shouldRejectFullHouse() {
        FullHouse counter = new FullHouse();

        assertThat(counter.computeScore(5, 5, 4, 4, 6)).isEqualTo(0);
        assertThat(counter.computeScore(5, 5, 5, 5, 5)).isEqualTo(0);
        assertThat(counter.computeScore(1, 5, 2, 6, 3)).isEqualTo(0);
    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new FullHouse();
    }
}
