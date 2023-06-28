package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Bonus}.
 *
 * @author Ullrich Hafner
 */
class BonusTest {
    @Test
    void shouldFailBonus() {
        Entry[] entries = createEntries();

        Bonus bonus = new Bonus(entries);
        assertThat(bonus.getScore()).isEqualTo(0);
        assertThat(bonus.printScore()).isEqualTo("0");
        assertThat(bonus.getText()).isEqualTo("               Bonus   0");

        entries[0].choose(1, 1, 3, 4, 4);
        entries[1].choose(2, 2, 2, 4, 4);
        entries[2].choose(3, 3, 3, 4, 4);
        entries[3].choose(1, 1, 4, 4, 4);
        entries[4].choose(5, 5, 5, 4, 4);
        assertThat(bonus.getScore()).isEqualTo(0);
        assertThat(bonus.printScore()).isEqualTo("0");
        assertThat(bonus.getText()).isEqualTo("               Bonus   0");

        entries[5].choose(6, 6, 6, 4, 4);
        assertThat(bonus.getScore()).isEqualTo(0);
        assertThat(bonus.printScore()).isEqualTo("0");
        assertThat(bonus.getText()).isEqualTo("               Bonus   0");
    }

    @Test
    void shouldCreateBonus() {
        Entry[] entries = createEntries();
        Bonus bonus = new Bonus(entries);

        entries[0].choose(1, 1, 1, 5, 4);
        entries[1].choose(2, 2, 2, 4, 4);
        entries[2].choose(3, 3, 3, 4, 4);
        entries[3].choose(1, 1, 4, 4, 4);
        entries[4].choose(5, 5, 5, 4, 4);
        entries[5].choose(6, 6, 6, 4, 4);
        assertThat(bonus.getScore()).isEqualTo(35);
        assertThat(bonus.printScore()).isEqualTo("35");
        assertThat(bonus.getText()).isEqualTo("               Bonus  35");
    }

    private Entry[] createEntries() {
        return new Entry[] {
                createEntry(1),
                createEntry(2),
                createEntry(3),
                createEntry(4),
                createEntry(5),
                createEntry(6)};
    }

    private Entry createEntry(final int position) {
        return new Entry(String.valueOf(position), new FaceCounter(position));
    }
}
