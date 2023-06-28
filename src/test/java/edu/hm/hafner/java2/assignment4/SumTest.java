package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Bonus}.
 *
 * @author Ullrich Hafner
 */
class SumTest {
    @Test
    void shouldCreateSum() {
        Entry[] entries = createEntries();

        Sum sum = new Sum("Summe oben", entries);
        assertThat(sum.getScore()).isEqualTo(0);
        assertThat(sum.printScore()).isEqualTo("0");
        assertThat(sum.getText()).isEqualTo("          Summe oben   0");

        entries[0].choose(1, 1, 1, 5, 4);
        assertThat(sum.getScore()).isEqualTo(3);
        assertThat(sum.getText()).isEqualTo("          Summe oben   3");

        entries[1].choose(2, 2, 2, 4, 4);
        assertThat(sum.getScore()).isEqualTo(9);
        assertThat(sum.getText()).isEqualTo("          Summe oben   9");

        entries[2].choose(3, 3, 3, 4, 4);
        assertThat(sum.getScore()).isEqualTo(18);
        assertThat(sum.getText()).isEqualTo("          Summe oben  18");

        entries[3].choose(1, 1, 4, 4, 4);
        assertThat(sum.getScore()).isEqualTo(30);
        assertThat(sum.getText()).isEqualTo("          Summe oben  30");

        entries[4].choose(5, 5, 5, 4, 4);
        assertThat(sum.getScore()).isEqualTo(45);
        assertThat(sum.getText()).isEqualTo("          Summe oben  45");

        entries[5].choose(6, 6, 6, 4, 4);
        assertThat(sum.getScore()).isEqualTo(63);
        assertThat(sum.getText()).isEqualTo("          Summe oben  63");

        Bonus bonus = new Bonus(entries);
        Row[] upperBoard = new Row[7];
        System.arraycopy(entries, 0, upperBoard, 0, 6);
        upperBoard[6] = bonus;

        Sum total = new Sum("Gesamtsumme oben", upperBoard);
        assertThat(total.getScore()).isEqualTo(63 + 35);
        assertThat(total.printScore()).isEqualTo("98");
        assertThat(total.getText()).isEqualTo("    Gesamtsumme oben  98");
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
