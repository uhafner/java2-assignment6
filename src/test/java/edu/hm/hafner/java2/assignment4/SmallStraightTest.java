package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link SmallStraight}.
 *
 * @author Ullrich Hafner
 */
class SmallStraightTest extends AbstractYahtzeeTest {
    @Test
    void testsScoreOfSmallStraight() {
        SmallStraight counter = new SmallStraight();

        assertThat(counter.computeScore(1, 2, 3, 4, 4)).isEqualTo(30);
        assertThat(counter.computeScore(1, 3, 2, 6, 4)).isEqualTo(30);
        assertThat(counter.computeScore(6, 2, 3, 4, 5)).isEqualTo(30);
        assertThat(counter.computeScore(6, 3, 1, 4, 5)).isEqualTo(30);
        assertThat(counter.computeScore(3, 4, 1, 6, 5)).isEqualTo(30);
        assertThat(counter.computeScore(2, 3, 6, 4, 5)).isEqualTo(30);
    }

    @Test
    void shouldFindLargeStraight() {
        SmallStraight counter = new SmallStraight();

        assertThat(counter.computeScore(1, 2, 3, 4, 5)).isEqualTo(30);
        assertThat(counter.computeScore(2, 3, 4, 5, 6)).isEqualTo(30);

        assertThat(counter.computeScore(1, 3, 2, 5, 4)).isEqualTo(30);
        assertThat(counter.computeScore(6, 2, 3, 4, 5)).isEqualTo(30);

        assertThat(counter.computeScore(6, 2, 4, 3, 5)).isEqualTo(30);
    }

    @Test
    void testsScoreOfNoSmallStraight() {
        SmallStraight counter = new SmallStraight();

        assertThat(counter.computeScore(5, 5, 4, 4, 6)).isEqualTo(0);
        assertThat(counter.computeScore(1, 2, 4, 5, 6)).isEqualTo(0);
    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new SmallStraight();
    }
}
