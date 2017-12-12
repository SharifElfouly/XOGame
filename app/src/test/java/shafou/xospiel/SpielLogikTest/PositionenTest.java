package shafou.xospiel.SpielLogikTest;

import org.junit.Test;

import shafou.xospiel.GameLogic.Position;

import static org.junit.Assert.*;

/**
 *
 * Diese Klasse enthält die entsprechenden Tests der Positions Klasse.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public class PositionenTest {

    /** Exception Text bei falscher Angabe der X Koordinate */
    public static final String X_ILLEGAL_ARGUMENT_TEXT = "X Position ist nicht"
            + " im vorgesehenen Intervall";

    /** Exception Text bei falscher Angabe der Y Koordinate */
    public static final String Y_ILLEGAL_ARGUMENT_TEXT = "Y Position ist nicht"
            + " im vorgesehenen Intervall";

    /**
     * Testet die Initialisierung einer Position.
     */
    @Test
    public void positionInitializationTest() {

        try {

            new Position(6, 1);
        } catch(IllegalArgumentException e) {

            assertEquals(X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(-1, 1);
        } catch(IllegalArgumentException e) {

            assertEquals(X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());

        }

        try {

            new Position(1, 10);
        } catch(IllegalArgumentException e) {

            assertEquals(Y_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(6, -90);
        } catch(IllegalArgumentException e) {

            assertEquals(X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(0, 0);
        } catch(IllegalArgumentException e) {

            assertEquals(X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(0, 2);
        } catch(IllegalArgumentException e) {

            assertEquals(X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(2, 0);
        } catch(IllegalArgumentException e) {

            assertEquals(Y_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        /** Position Initialisierung zwischen den vorgegebenen Intervallen */
        assertEquals(new Position(1, 1), new Position(1,1));
        assertEquals(new Position(1, 2), new Position(1,2));
        assertEquals(new Position(3, 1), new Position(3,1));
    }

    @Test
    public void positionsGleichheitTest() {

        boolean istGleich;

        Position position1 = new Position(1,1);
        Position position2 = new Position(1,1);

        istGleich = (position1.equals(position2));

        assertEquals(true, istGleich);
    }
}
