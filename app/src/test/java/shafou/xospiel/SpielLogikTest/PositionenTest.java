package shafou.xospiel.SpielLogikTest;

import org.junit.Test;

import shafou.xospiel.SpielLogik.Position;

import static org.junit.Assert.*;

/**
 *
 * Diese Klasse enthält die entsprechenden Tests der Positions Klasse.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public class PositionenTest {

    /**
     * Testet die Initialisierung einer Position.
     */
    @Test
    public void positionInitializationTest() {

        try {

            new Position(6, 1);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(-1, 1);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(1, 10);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.Y_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(6, -90);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(0, 0);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(0, 2);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.X_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
        }

        try {

            new Position(2, 0);
        } catch(IllegalArgumentException e) {

            assertEquals(Position.Y_ILLEGAL_ARGUMENT_TEXT, e.getMessage());
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
