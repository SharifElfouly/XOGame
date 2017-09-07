package shafou.xospiel.SpielLogik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>This class has methods to analyze a current game.
 *
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 24.05.2017 ELF Class created.
 * 1) 25.05.2017 ELF Logic implemented.
 */

public class Standings {

    /** Steigung einer Reihe */
    private static final int gRX = 1;
    private static final int gRY = 0;

    /** Steigung einer Spalte */
    private static final int gSX = 0;
    private static final int gSY = 1;

    /** Steigung einer rechten Diagonalen */
    private static final int gDrX = 1;
    private static final int gDrY = 1;

    /** Steigung einer linken Diagonale */
    private static final int gDlX = -1;
    private static final int gDlY = 1;

    /**
     * Calculates if the positions played win a game.
     *
     * @param playedPositions Played positions
     * @param tokensToWin Tokens to win this game
     * @return <code>true</code> if the played positions win this game
     */
    public static boolean hasWon(List<Position> playedPositions, int tokensToWin) {

        /**
         * The played positions size must equal or exceed the tokens required to
         * win.
         */
        if(playedPositions.size() < tokensToWin) {

            return false;
        }
        
        for (Position playedPosition : playedPositions) {

            /** Next position in the row, column or diagonal */
            Position sameRow = createUpdatedPosition(playedPosition, gRX, gRY);
            Position sameColumn = createUpdatedPosition(playedPosition, gSX, gSY);
            Position sameDiagonalR = createUpdatedPosition(playedPosition, gDrX, gDrY);
            Position sameDiagonalL = createUpdatedPosition(playedPosition, gDlX, gDlY);

            /** List of all possible next positions  */
            List<Position> nextPositions = new ArrayList<>();
            nextPositions.add(sameRow);
            nextPositions.add(sameColumn);
            nextPositions.add(sameDiagonalR);
            nextPositions.add(sameDiagonalL);

            for (int i = 0; i < nextPositions.size(); i++) {

                /** Checks if the next possible position was played */
                if (playedPositions.contains(nextPositions.get(i))) {

                    Position nextPosition = nextPositions.get(i);
                    int numberOfFoundPositions = 1;

                    /** Indicated which sequence of position this is */
                    float factorX = nextPosition.getXPosition() - playedPosition.getXPosition();
                    float factorY = nextPosition.getYPosition() - playedPosition.getYPosition();

                    /**
                     * The next position is so long searched for until the amount
                     * of positions to win is reached.
                     */
                    for (int x = 0; x < tokensToWin - 2; x++) {

                        Position newPosition = createUpdatedPosition(nextPosition, factorX, factorY);

                        if (playedPositions.contains(newPosition)) {

                            numberOfFoundPositions++;
                            nextPosition = createUpdatedPosition(nextPosition, factorX, factorY);
                        }

                        if (numberOfFoundPositions >= tokensToWin - 1) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    /**
     * Creates from an old position a new updated position.
     *
     * @param position old Position
     * @param x new X coordinate
     * @param y new y coordinate
     * @return updated position
     */
    private static Position createUpdatedPosition(Position position, float x, float y) {

        return new Position(position.getXPosition() + x, position.getYPosition() + y);
    }
}
