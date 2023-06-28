package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Verifies the faces globally: the number of dice should be exactly 5. Every face must be in the range [0, ..., 6].
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractYahtzeeTest {
    @Test
    void shouldValidateFacesLargerThan6() {
        YahtzeeEvaluator counter = createYahtzeeEvaluator();

        assertThatIllegalArgumentException()
                .as("Illegal face 7")
                .isThrownBy(
                        () -> counter.computeScore(7, 1, 2, 3, 4)).withMessageContaining("7");
    }

    @Test
    void shouldValidateFacesSmallerThan1() {
        YahtzeeEvaluator counter = createYahtzeeEvaluator();

        assertThatIllegalArgumentException()
                .as("Illegal face 0")
                .isThrownBy(
                        () -> counter.computeScore(1, 1, 2, 3, 0)).withMessageContaining("0");
    }

    @Test
    void shouldValidateNumberOfDiceSmallerThan5() {
        YahtzeeEvaluator counter = createYahtzeeEvaluator();

        assertThatIllegalArgumentException()
                .as("Number of dice < 5")
                .isThrownBy(
                        () -> counter.computeScore(1, 2, 3, 4)).withMessageContainingAll("1", "2", "3", "4");
    }

    @Test
    void shouldValidateNumberOfDiceLargerThan5() {
        YahtzeeEvaluator counter = createYahtzeeEvaluator();

        assertThatIllegalArgumentException()
                .as("Number of dice > 5")
                .isThrownBy(
                        () -> counter.computeScore(1, 2, 3, 4, 5, 6)).withMessageContainingAll("1", "2", "3", "4", "5", "6");
    }

    protected abstract YahtzeeEvaluator createYahtzeeEvaluator();
}
