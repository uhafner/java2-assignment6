package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link FaceCounter}.
 *
 * @author Ullrich Hafner
 */
class FaceCounterTest extends AbstractYahtzeeTest {
    @Test
    void shouldCountOnlyOnes() {
        FaceCounter counter = new FaceCounter(1);

        assertThat(counter.computeScore(5, 4, 3, 2, 1)).isEqualTo(1);
        assertThat(counter.computeScore(1, 4, 3, 2, 1)).isEqualTo(2);
        assertThat(counter.computeScore(1, 4, 1, 2, 1)).isEqualTo(3);
        assertThat(counter.computeScore(1, 1, 1, 1, 1)).isEqualTo(5);
        assertThat(counter.computeScore(2, 3, 4, 5, 3)).isEqualTo(0);
    }

    @Test
    void shouldCountOnlyFives() {
        FaceCounter counter = new FaceCounter(5);

        assertThat(counter.computeScore(5, 4, 3, 2, 1)).isEqualTo(5);
        assertThat(counter.computeScore(5, 5, 5, 5, 5)).isEqualTo(25);
        assertThat(counter.computeScore(2, 3, 4, 1, 3)).isEqualTo(0);
    }

    @Test
    void shouldFailIfFaceIsInvalid() {
        assertThatIllegalArgumentException()
                .as("Illegal face")
                .isThrownBy(
                        () -> new FaceCounter(0)).withMessageContaining("0");
        assertThatIllegalArgumentException()
                .as("Illegal face")
                .isThrownBy(
                        () -> new FaceCounter(7)).withMessageContaining("7");

    }

    @Override
    protected YahtzeeEvaluator createYahtzeeEvaluator() {
        return new FaceCounter(1);
    }
}
