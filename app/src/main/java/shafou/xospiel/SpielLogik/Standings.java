package shafou.xospiel.SpielLogik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>Diese Klasse repräsentiere den Standings des aktuellen Spiels.
 *
 * Ein Standings ist ein Singelton. Zur Laufzeit existiert nur ein Standings
 * Objekt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 * 1) 25.05.2017 ELF Klasse Spiel Logik hinzugefügt.
 */

public class Standings {

    /**
     * Gibt an ob die bereits gespielten Positionen zum Gewinn führen.
     *
     * @param gespieltePositionen Bereits gespielte Positionen
     * @param anzahlPositionenZumGewinn Anzahl von Positionen zum Gewinn
     * @return <code>true</code> falls die Anzahl zum Gewinnen Benötigter
     * Positionen gefunden wurde.
     */
    public static boolean hatGewonnen(List<Position> gespieltePositionen, int anzahlPositionenZumGewinn) {

        /**
         * Es müssen mindestens so viele Positionen zum Gewinn bestehen, um eine
         * Möglichkeit zu haben zu gewinnen.
         */
        if(gespieltePositionen.size() < anzahlPositionenZumGewinn) {

            return false;
        }

        if(anzahlPositionenZumGewinn < 3) {

//            throw new IllegalArgumentException("Die minimale Anzahl zum " +
//                    "gewinnen beträgt 3.");
            return false;
        }

        /** Steigung einer Reihe */
        int gRX = 1;
        int gRY = 0;

        /** Steigung einer Spalte */
        int gSX = 0;
        int gSY = 1;

        /** Steigung einer rechten Diagonalen */
        int gDrX = 1;
        int gDrY = 1;

        /** Steigung einer linken Diagonale */
        int gDlX = -1;
        int gDlY = 1;

        for (Position gespieltePosition : gespieltePositionen) {

            /** Nächste Position in der Reihe, Spalte oder Diagonalen */
            Position gleicheReihe = erstellePosition(gespieltePosition, gRX, gRY);
            Position gleicheSpalte = erstellePosition(gespieltePosition, gSX, gSY);
            Position gleicheDiagonaleR = erstellePosition(gespieltePosition, gDrX, gDrY);
            Position gleicheDiagonaleL = erstellePosition(gespieltePosition, gDlX, gDlY);

            /** Liste von nächst möglichen Positionen */
            List<Position> naechstePositionen = new ArrayList<>();
            naechstePositionen.add(gleicheReihe);
            naechstePositionen.add(gleicheSpalte);
            naechstePositionen.add(gleicheDiagonaleR);
            naechstePositionen.add(gleicheDiagonaleL);

            for (int i = 0; i < naechstePositionen.size(); i++) {

                /** Ist die nächst mögliche Position eine gespielte Position */
                if (gespieltePositionen.contains(naechstePositionen.get(i))) {

                    Position naechstePosition = naechstePositionen.get(i);
                    int anzahlGefundenerPositionen = 1;

                    /** Gibt an um welche Reihenfolge von Position es sich handelt */
                    float faktorX = naechstePosition.getXPosition() - gespieltePosition.getXPosition();
                    float faktorY = naechstePosition.getYPosition() - gespieltePosition.getYPosition();

                    /**
                     * Es wird solange nach der nächsten Position gesucht bis
                     * die Anzahl von Positionen zum gewinnen erreicht wurde.
                     */
                    for (int x = 0; x < anzahlPositionenZumGewinn - 2; x++) {

                        Position neuePosition = erstellePosition(naechstePosition, faktorX, faktorY);

                        if (gespieltePositionen.contains(neuePosition)) {

                            anzahlGefundenerPositionen++;
                            naechstePosition = erstellePosition(naechstePosition, faktorX, faktorY);
                        }

                        if (anzahlGefundenerPositionen >= anzahlPositionenZumGewinn - 1) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    /**
     * Erzeugt ein neues Positions Objekt.
     *
     * @param position alte Position
     * @param x Verschiebung der X Koordinate
     * @param y Verschiebung der Y Koordinate
     * @return Aktualisierte Position
     */
    private static Position erstellePosition(Position position, float x, float y) {

        return new Position(position.getXPosition() + x, position.getYPosition() + y);
    }
}
