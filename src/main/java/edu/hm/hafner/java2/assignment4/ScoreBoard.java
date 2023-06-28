package edu.hm.hafner.java2.assignment4;

import java.util.Arrays;

/**
 * A score board for a Yahtzee player.
 *
 * @author Ullrich Hafner
 */
@SuppressWarnings("checkstyle:ClassDataAbstractionCoupling")
public class ScoreBoard {
    /**
     * The available categories in Yahtzee.
     */
    public enum Category {
        ONES("Einser"), TWOS("Zweier"), THREES("Dreier"),
        FOURS("Vierer"), FIVES("Fünfer"), SIXES("Sechser"),
        THREE_OF_A_KIND("Drilling"), FOUR_OF_A_KIND("Vierling"),
        FULL_HOUSE("Full House"),
        SMALL_STRAIGHT("Kleine Straße"), LARGE_STRAIGHT("Große Straße"),
        YAHTZEE("Yahtzee"), CHANCE("Chance");

        private final String displayName;

        Category(final String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private final Entry[] entries = new Entry[Category.values().length];
    private final Row[] rows = new Row[Category.values().length + 3 + 2];

    /**
     * Creates a new score board.
     */
    public ScoreBoard(final String player) {
        createSelectableEntries();
        createPrintableEntries();
    }

    private void createSelectableEntries() {
        int index = 0;

        entries[index++] = new Entry(Category.ONES.getDisplayName(), new FaceCounter(1));
        entries[index++] = new Entry(Category.TWOS.getDisplayName(), new FaceCounter(2));
        entries[index++] = new Entry(Category.THREES.getDisplayName(), new FaceCounter(3));
        entries[index++] = new Entry(Category.FOURS.getDisplayName(), new FaceCounter(4));
        entries[index++] = new Entry(Category.FIVES.getDisplayName(), new FaceCounter(5));
        entries[index++] = new Entry(Category.SIXES.getDisplayName(), new FaceCounter(6));

        entries[index++] = new Entry(Category.THREE_OF_A_KIND.getDisplayName(), new SeveralOfAKind(3)
        );
        entries[index++] = new Entry(Category.FOUR_OF_A_KIND.getDisplayName(), new SeveralOfAKind(4)
        );
        entries[index++] = new Entry(Category.FULL_HOUSE.getDisplayName(), new FullHouse());
        entries[index++] = new Entry(Category.SMALL_STRAIGHT.getDisplayName(), new SmallStraight()
        );
        entries[index++] = new Entry(Category.LARGE_STRAIGHT.getDisplayName(), new LargeStraight()
        );
        entries[index++] = new Entry(Category.YAHTZEE.getDisplayName(), new Yahtzee());
        entries[index++] = new Entry(Category.CHANCE.getDisplayName(), new Chance());
    }

    private void createPrintableEntries() {
        int rowIndex = 0;
        int entryIndex = 0;

        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];

        rows[rowIndex++] = new Sum("Summe oben",
                entries[0], entries[1], entries[2], entries[3], entries[4], entries[5]);
        rows[rowIndex++] = new Bonus(entries[0], entries[1], entries[2], entries[3], entries[4], entries[5]);
        rows[rowIndex++] = new Sum("Gesamter oberer Teil", rows[6], rows[7]);

        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];
        rows[rowIndex++] = entries[entryIndex++];

        rows[rowIndex++] = new Sum("Summe unten",
                entries[6], entries[7], entries[8], entries[9], entries[10], entries[11], entries[12]);
        rows[rowIndex] = new Sum("Gesamtsumme", rows[8], rows[16]);
    }

    /**
     * Prints this board as a formatted string.
     *
     * @return this board as a {@link String} value
     */
    public String print() {
        StringBuilder board = new StringBuilder(1024);
        board.append(String.format("%d Punkte nach %d Runden%n", getScore(), getPlayedRounds()));
        for (Row entry : rows) {
            board.append(entry.getText());
            board.append('\n');
        }
        return board.toString();
    }

    private int getPlayedRounds() {
        return Arrays.stream(entries)
                .map(Entry::isChosen)
                .mapToInt(value -> value ? 1 : 0)
                .sum();
    }

    public int getScore() {
        return rows[rows.length - 1].getScore();
    }

    /**
     * Plays a new round. Chooses the specified position of this score board with the given faces.
     *
     * @param category
     *         the position to choose
     * @param faces
     *         the faces of the dice cup
     */
    public void playRound(final Category category, final int... faces) {
        entries[category.ordinal()].choose(faces);
    }

    /**
     * Plays a new round. Chooses the specified position of this score board with the given faces.
     *
     * @param category
     *         the position to choose
     * @param faces
     *         the faces of the dice cup
     * @return the score for the specified category and faces
     */
    public int evaluateScore(final Category category, final int... faces) {
        return entries[category.ordinal()].evaluateScore(faces);
    }
}
