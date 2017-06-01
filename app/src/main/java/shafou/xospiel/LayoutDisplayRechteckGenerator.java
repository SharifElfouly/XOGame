package shafou.xospiel;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse ist ein Generator der ein Display in beliebig viele Reihen und
 * Spalten aufteilt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 26.05.2017 ELF Klasse erstellt.
 */

public class LayoutDisplayRechteckGenerator {

    /**
     * Teilt ein LayoutDisplay Objekt in gleich große Rechtecke je nach Anzahl
     * der Spalten und Reihen.
     *
     * Für den Aufbau eines LayoutDisplayRechtecks siehe
     * {@link DisplayRechtecke}.
     *
     * @param layoutDisplay LayoutDisplayObjekt
     * @param spalten Anzahl der Spalten
     * @param reihen Anzahl der Reihen
     * @return Eine Liste von DisplayRechtecke Objekten
     */
    public static ArrayList<DisplayRechtecke> teileDisplayInRechtecke
            (LayoutDisplay layoutDisplay, int spalten, int reihen) {

        /** Spalten und Reihen müssen positiv sein */
        if(spalten < 0 || reihen < 0) {

            throw new IllegalArgumentException("Spalten und Reihen müssen " +
                    "positiv sein!");
        }

        /** Liste von DisplayRechtecke Objekten */
        ArrayList<DisplayRechtecke> layoutDisplayQuadrate
                = new ArrayList<>();

        /** Breite und Höhe des übergebene LayoutDisplay Objektes */
        float breite = layoutDisplay.getBreite();
        float hoehe = layoutDisplay.getHoehe();

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

        /** Falls eine neue Reihe bearbeitet wird muss dieses separat berechnet werden */
        int neueReihe = 0;

        /** Iteration über alle Positionen */
        for(int i = 1; i <= (spalten * reihen); i++) {

            /** Initialisierung der LayoutDisplayRechtecke */
            DisplayRechtecke lDQ = new DisplayRechtecke(
                    positionen.get(i + neueReihe - 1),
                    positionen.get(i + neueReihe),
                    positionen.get(i + neueReihe + spalten + 1),
                    positionen.get(i + neueReihe + spalten)
            );

            /** Falls <code>true</code> wurde eine neue Reihe begonnen */
            if(i % (spalten) == 0) {

                neueReihe++;
            }

            layoutDisplayQuadrate.add(lDQ);
        }

        return layoutDisplayQuadrate;
    }
}
