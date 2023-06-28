package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Yahtzee}.
 *
 * @author Ullrich Hafner
 */
class YahtzeeTest extends AbstractYahtzeeTest {
    @Test
    void testsScoreForYahtzee() {
        Yahtzee counter = new Yahtzee();

        assertThat(counter.computeScore(1, 1, 1, 1, 1)).isEqualTo(50);
        assertThat(counter.computeScore(5, 5, 5, 5, 5)).isEqualTo(50);
    }

    @Test
    void testsScoreForNoYahtzee() {
        Yahtzee counter = new Yahtzee();

        assertThat(counter.computeScore(5, 5, 5, 5, 4)).isEqualTo(0);
        assertThat(counter.computeScore(1, 2, 3, 4, 5)).isEqualTo(0);
    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new Yahtzee();
    }
}
