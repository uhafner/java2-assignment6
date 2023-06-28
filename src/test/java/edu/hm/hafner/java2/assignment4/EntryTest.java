package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Entry}.
 *
 * @author Ullrich Hafner
 */
class EntryTest {
    @Test
    void shouldCreateYahtzee() {
        Entry yahtzee = createYahtzee();

        assertThat(yahtzee.isChosen()).isFalse();
        assertThat(yahtzee.getScore()).isEqualTo(0);
        assertThat(yahtzee.getText()).isEqualTo("             Yahtzee    ");

        yahtzee.choose(5, 5, 5, 5, 5);
        assertThat(yahtzee.isChosen()).isTrue();
        assertThat(yahtzee.getScore()).isEqualTo(50);
        assertThat(yahtzee.getText()).isEqualTo("             Yahtzee  50");
    }

    @Test
    void shouldFailYahtzee() {
        Entry yahtzee = createYahtzee();

        assertThat(yahtzee.isChosen()).isFalse();
        assertThat(yahtzee.getScore()).isEqualTo(0);
        assertThat(yahtzee.getText()).isEqualTo("             Yahtzee    ");

        yahtzee.choose(5, 5, 4, 5, 5);
        assertThat(yahtzee.isChosen()).isTrue();
        assertThat(yahtzee.getScore()).isEqualTo(0);
        assertThat(yahtzee.getText()).isEqualTo("             Yahtzee   0");
    }

    @Test
    void shouldNotAllowMultipleWrites() {
        Entry yahtzee = createYahtzee();
        yahtzee.choose(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException().isThrownBy(() -> yahtzee.choose(5, 5, 5, 5, 5));
    }

    private Entry createYahtzee() {
        Entry yahtzee = new Entry("Yahtzee", new Yahtzee());
        assertThat(yahtzee.getDisplayName()).isEqualTo("Yahtzee");
        return yahtzee;
    }

    @Test
    void shouldReturnScoreForFaces() {
        Entry yahtzee = createYahtzee();

        assertThat(yahtzee.evaluateScore(5, 5, 5, 5, 5)).isEqualTo(50);
        assertThat(yahtzee.evaluateScore(5, 5, 4, 5, 5)).isEqualTo(0);
    }
}
