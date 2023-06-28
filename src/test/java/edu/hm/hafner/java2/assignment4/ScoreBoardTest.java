package edu.hm.hafner.java2.assignment4;

import org.junit.jupiter.api.Test;

import edu.hm.hafner.java2.assignment4.ScoreBoard.Category;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link ScoreBoard}.
 *
 * @author Ullrich Hafner
 */
class ScoreBoardTest {
    @Test
    void shouldPrintEmptyBoard() {
        ScoreBoard scoreBoard = createScoreBoard();

        assertThat(scoreBoard.print()).isEqualToIgnoringWhitespace("""
                0 Punkte nach 0 Runden
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
                50 Punkte nach 1 Runden
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
                65 Punkte nach 2 Runden
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

    private ScoreBoard createScoreBoard() {
        return new ScoreBoard("Computer");
    }
}
