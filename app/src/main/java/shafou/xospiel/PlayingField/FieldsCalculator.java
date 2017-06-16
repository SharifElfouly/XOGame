package shafou.xospiel.PlayingField;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse stellt Methoden zur Berechnungen der Spielfelder eines
 * Spielfeldes dar.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 03.06.2017 ELF Klasse erstellt.
 */

public final class FieldsCalculator {

    /**
     * Gibt anhand der Reihen und Spalten alle Positionen des Spielfeldes zurück
     *
     * @param reihen Anzahl der Reihen auf dem Spielfeld
     * @param spalten Anzahl der Spalten auf dem Spielfeld
     * @return Liste mit Positionen auf dem Spielfeld
     */
    public static ArrayList<Position> getPositions(float breite, float hoehe, int spalten, int reihen) {

        /** Spalten und Reihen müssen positiv sein */
        if(spalten <= 0 || reihen <= 0) {

            throw new IllegalArgumentException("Spalten und Reihen müssen " +
                    "positiv sein!");
        }

        /** Liste mit den errechneten Positionen */
        ArrayList<Position> positionen = new ArrayList<>();

        /** Iteration über alle Reihen und Spalten */
        for(int r = 0; r <= reihen; r++) {
            for(int s = 0; s <= spalten; s++) {

                /** Berechnung aller Positionen der aufzubauenden Rechtecke */
                Position position
                        = new Position(((float) s / (float) spalten) * breite, ((float)r / (float)reihen) * hoehe);
                positionen.add(position);
            }
        }

        return positionen;
    }

    /**
     * Gibt anhand der Anzahl von Spalten und Reihen Felder
     * zurück.
     *
     * @param spalten Anzahl der Spalten des Spielfeldes
     * @param reihen Anzahl der Zeilen des Spielfeldes
     * @return Liste von Field Objekten
     */
    public static ArrayList<Field> getFields(float breite, float hoehe, int spalten, int reihen) {

        /** Gibt die Positionen des Spielfeldes zurück */
        ArrayList<Position> positionen = getPositions(breite, hoehe, spalten, reihen);

        /** Liste von Field Objekten */
        ArrayList<Field> field
                = new ArrayList<>();

        /** Falls eine neue Reihe bearbeitet wird muss dieses separat berechnet werden */
        int neueReihe = 0;

        int spaltenIndex = 1;
        int reihenIndex = 1;

        /** Iteration über alle Positionen */
        for(int i = 1; i <= (spalten * reihen); i++) {

            /** Initialisierung der LayoutDisplayRechtecke */
            Field lDQ = new Field(
                    positionen.get(i + neueReihe - 1),
                    positionen.get(i + neueReihe),
                    positionen.get(i + neueReihe + spalten + 1),
                    positionen.get(i + neueReihe + spalten),
                    i);

            /** Falls <code>true</code> wurde eine neue Reihe begonnen */
            if(i % (spalten) == 0) {

                neueReihe++;
            }

            if(spaltenIndex > spalten) {

                spaltenIndex = 1;
            }

            lDQ.setPosition(new Position(spaltenIndex, reihenIndex));

            if(spaltenIndex == spalten) {

                reihenIndex++;
            }

            spaltenIndex++;

            field.add(lDQ);
        }

        return field;
    }
}
