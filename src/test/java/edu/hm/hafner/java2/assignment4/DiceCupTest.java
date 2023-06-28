package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link DiceCup}.
 *
 * @author Ullrich Hafner
 */
class DiceCupTest {
    @Test
    void shouldForceAtLeastOneDice() {
        assertThatIllegalArgumentException().isThrownBy(DiceCup::new);
        assertThatIllegalArgumentException().isThrownBy(() -> new DiceCup(0));
    }

    @Test
    void shouldHandleOneDice() {
        FixedSeriesDie dice = new FixedSeriesDie(1, 3);

        DiceCup diceCup = new DiceCup(dice);
        assertThat(diceCup.getFaces()).containsExactly(1);
        assertThat(diceCup).hasToString("[1]");

        assertThat(diceCup.roll()).containsExactly(3);
        assertThat(diceCup.getFaces()).containsExactly(3);
        assertThat(diceCup).hasToString("[3]");

        assertThat(diceCup.roll()).containsExactly(1);
        assertThat(diceCup.getFaces()).containsExactly(1);

        assertThat(diceCup.roll()).containsExactly(3);
        assertThat(diceCup.getFaces()).containsExactly(3);
        assertThat(diceCup.getFaces(0)).containsExactly(3);
    }

    @Test
    void shouldHandleTwoDice() {
        FixedSeriesDie first = new FixedSeriesDie(1, 3);
        FixedSeriesDie second = new FixedSeriesDie(2, 4, 6);

        DiceCup diceCup = new DiceCup(first, second);
        assertThat(diceCup.getFaces()).containsExactly(1, 2);
        assertThat(diceCup).hasToString("[1, 2]");
        assertThat(diceCup.getFaces(0)).containsExactly(1);
        assertThat(diceCup.getFaces(1)).containsExactly(2);
        assertThat(diceCup.getFaces(0, 1)).containsExactly(1, 2);

        assertThat(diceCup.roll()).containsExactly(3, 4);
        assertThat(diceCup.roll(0)).containsExactly(3, 6);
        assertThat(diceCup.roll(0)).containsExactly(3, 2);
        assertThat(diceCup.roll(1)).containsExactly(1, 2);
        assertThat(diceCup.roll(1)).containsExactly(3, 2);
    }

    @Test
    void shouldRollAtLeastOneDice() {
        DiceCup diceCup = new DiceCup(5);

        assertThatIllegalArgumentException().isThrownBy(
                () -> diceCup.roll(0, 1, 2, 3, 4)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> diceCup.roll(-1)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> diceCup.roll(5)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> diceCup.roll(2, 2)
        );
    }
}
