package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link SeveralOfAKind}.
 *
 * @author Ullrich Hafner
 */
class SeveralOfAKindTest extends AbstractYahtzeeTest {
    @Test
    void shouldScoreThreeOfAKind() {
        SeveralOfAKind counter = new SeveralOfAKind(3);

        assertThat(counter.computeScore(6, 6, 6, 6, 6)).isEqualTo(30);
        assertThat(counter.computeScore(1, 1, 1, 1, 1)).isEqualTo(5);
        assertThat(counter.computeScore(1, 1, 1, 1, 2)).isEqualTo(6);
        assertThat(counter.computeScore(5, 4, 5, 4, 5)).isEqualTo(23);
        assertThat(counter.computeScore(6, 6, 6, 1, 1)).isEqualTo(20);
        assertThat(counter.computeScore(3, 2, 1, 1, 1)).isEqualTo(8);
    }

    @Test
    void shouldRejectThreeOfAKind() {
        SeveralOfAKind counter = new SeveralOfAKind(3);

        assertThat(counter.computeScore(5, 5, 6, 4, 4)).isEqualTo(0);
        assertThat(counter.computeScore(1, 2, 3, 1, 2)).isEqualTo(0);
        assertThat(counter.computeScore(5, 4, 3, 1, 2)).isEqualTo(0);
    }

    @Test
    void shouldScoreFourOfAKind() {
        SeveralOfAKind counter = new SeveralOfAKind(4);

        assertThat(counter.computeScore(6, 6, 6, 6, 6)).isEqualTo(30);
        assertThat(counter.computeScore(1, 1, 1, 1, 1)).isEqualTo(5);
        assertThat(counter.computeScore(1, 1, 1, 1, 2)).isEqualTo(6);
        assertThat(counter.computeScore(5, 5, 5, 4, 5)).isEqualTo(24);
        assertThat(counter.computeScore(6, 1, 6, 6, 6)).isEqualTo(25);
    }

    /**
     * Tests the score of four-of-a-kind.
     */
    @Test
    void shouldRejectFourOfAKind() {
        SeveralOfAKind counter = new SeveralOfAKind(4);

        assertThat(counter.computeScore(5, 5, 5, 4, 4)).isEqualTo(0);
        assertThat(counter.computeScore(5, 4, 5, 4, 5)).isEqualTo(0);
        assertThat(counter.computeScore(6, 6, 6, 1, 1)).isEqualTo(0);
        assertThat(counter.computeScore(3, 2, 1, 1, 1)).isEqualTo(0);
    }

    @Test
    void shouldValidateSequenceLessThan6() {
        assertThatIllegalArgumentException()
                .as("Illegal sequence length")
                .isThrownBy(
                        () -> new SeveralOfAKind(6)).withMessageContaining("6");
        assertThatIllegalArgumentException()
                .as("Illegal sequence length")
                .isThrownBy(
                        () -> new SeveralOfAKind(0)).withMessageContaining("0");
    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new SeveralOfAKind(4);
    }
}
