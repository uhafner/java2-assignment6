package edu.hm.hafner.java2.assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.hm.hafner.java2.assignment7.ScoreBoard.Category;
import edu.hm.hafner.java2.assignment7.ScoreBoard.NameComparator;
import edu.hm.hafner.java2.assignment7.ScoreBoard.ScoreComparator;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link ScoreBoard}.
 *
 * @author Ullrich Hafner
 */
class ScoreBoardTest {
    private static final String ULLRICH_HAFNER = "Ullrich Hafner";
    private static final String BASTIAN_KATZ = "Bastian Katz";

    @Test
    void shouldPrintEmptyBoard() {
        ScoreBoard scoreBoard = createScoreBoard();

        assertThat(scoreBoard.print()).isEqualToIgnoringWhitespace("""
                Computer: 0 Punkte nach 0 Runden
                              Einser
                              Zweier
                              Dreier
                              Vierer
                              Fünfer
                             Sechser
                          Summe oben   0
                               Bonus   0
                Gesamter oberer Teil   0
                            Drilling
                            Vierling
                          Full House
                       Kleine Straße
                        Große Straße
                             Yahtzee
                              Chance
                         Summe unten   0
                         Gesamtsumme   0
                """);
        assertThat(scoreBoard.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScoreYahtzee() {
        ScoreBoard scoreBoard = createScoreBoard();

        assertThat(scoreBoard.evaluateScore(Category.YAHTZEE, 1, 1, 1, 1, 1)).isEqualTo(50);

        scoreBoard.playRound(Category.YAHTZEE, 1, 1, 1, 1, 1);
        assertThat(scoreBoard.print()).isEqualToIgnoringWhitespace("""
                Computer: 50 Punkte nach 1 Runden
                              Einser
                              Zweier
                              Dreier
                              Vierer
                              Fünfer
                             Sechser
                          Summe oben   0
                               Bonus   0
                Gesamter oberer Teil   0
                            Drilling
                            Vierling
                          Full House
                       Kleine Straße
                        Große Straße
                             Yahtzee  50
                              Chance
                         Summe unten  50
                         Gesamtsumme  50
                """);

        scoreBoard.playRound(Category.FIVES, 1, 5, 3, 5, 5);
        assertThat(scoreBoard.print()).isEqualToIgnoringWhitespace("""
                Computer: 65 Punkte nach 2 Runden
                              Einser
                              Zweier
                              Dreier
                              Vierer
                              Fünfer  15
                             Sechser
                          Summe oben  15
                               Bonus   0
                Gesamter oberer Teil  15
                            Drilling
                            Vierling
                          Full House
                       Kleine Straße
                        Große Straße
                             Yahtzee  50
                              Chance
                         Summe unten  50
                         Gesamtsumme  65
                """);
    }

    @Test
    void shouldSortByPlayerName() {
        ScoreBoard hafner = new ScoreBoard(ULLRICH_HAFNER);
        ScoreBoard katz = new ScoreBoard(BASTIAN_KATZ);

        List<ScoreBoard> boards = new ArrayList<>();
        boards.add(hafner);
        boards.add(katz);

        Collections.sort(boards);

        assertThat(boards).containsExactly(katz, hafner);

        boards.sort(new NameComparator());
        assertThat(boards).containsExactly(katz, hafner);

        boards.sort(new ScoreComparator());
        assertThat(boards).containsExactly(katz, hafner);

        hafner.playRound(Category.YAHTZEE, 1, 1, 1, 1, 1);

        boards.sort(new NameComparator());
        assertThat(boards).containsExactly(katz, hafner);

        boards.sort(new ScoreComparator());
        assertThat(boards).containsExactly(hafner, katz);
    }

    @Test
    void shouldIterateOverAllEntries() {
        ScoreBoard scoreBoard = createScoreBoard();
        Entry[] remainingEntries = scoreBoard.getRemainingEntries();

        int index = 0;
        for (Entry entry : scoreBoard) {
            assertThat(entry).isSameAs(remainingEntries[index++]);
        }
        assertThat(index).isEqualTo(13);

        scoreBoard.playRound(Category.YAHTZEE, 1, 1, 1, 1, 1);

        index = 0;
        var iterator = scoreBoard.iterator();
        for (Entry entry : remainingEntries) {
            if (entry.getScore() != 50) {
                assertThat(entry).isSameAs(iterator.next());
                index++;
            }
        }
        assertThat(index).isEqualTo(12);
    }

    @Test
    void shouldAdhereToEquals() {
        EqualsVerifier.forClass(ScoreBoard.class).verify();
    }

    private ScoreBoard createScoreBoard() {
        return new ScoreBoard("Computer");
    }
}
