package shafou.xospiel.SpielLogik;

import java.util.ArrayList;

import shafou.xospiel.Spielfeld.Feld;
import shafou.xospiel.Spielfeld.SpielfeldGenerator;

/**
 *
 * Diese Klasse verwaltet die Spieler Inputs auf dem Spielfeld.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 05.06.2017 ELF Klasse erstellt.
 */

public final class SpielfeldInputVerarbeiter<T extends SpielfeldGenerator> {

    /** Beinhaltet die Rechtecke des Spielfeldes */
    private ArrayList<Feld> spielfelder;

    /** Breite des Spielfeldes */
    private float breite;

    /** Höhe des Spielfeldes */
    private float hoehe;

    public SpielfeldInputVerarbeiter() {}

    /**
     * Gibt an ob der Input des Spielers im Spielfeld ist
     * @param inputPosition Position des Inputs des Spielers
     * @return <code>true</code> falls sich der Input auf dem Spielfeld befindet.
     */
    public boolean istEingabeAufFeld(Position inputPosition) {

        return inputPosition.getXPosition() < breite
                && inputPosition.getYPosition() < hoehe
                && inputPosition.getXPosition() > 0
                && inputPosition.getYPosition() > 0;
    }

    /**
     * Gibt das Spielfeld an, in dem der User Input stattgefunden hat.
     *
     * @param inputPosition Position des Inputs
     * @return Das Spielfeld indem der Input war
     */
    public Feld gibSpielfeld(Position inputPosition) {

        for(Feld spielfeld: spielfelder) {

            if(inputPosition.getXPosition() >= spielfeld.getX1().getXPosition()
                    && inputPosition.getXPosition() <= spielfeld.getX2().getXPosition()
                    && inputPosition.getYPosition() >= spielfeld.getX1().getYPosition()
                    && inputPosition.getYPosition() <= spielfeld.getX4().getYPosition()) {

                return spielfeld;
            }
        }

        return null;
    }

    /**
     * Setzt den Spielfeld Generator
     * @param spielfeldGenerator Spielfeld Generator
     */
    public void setSpielfeldGenerator(T spielfeldGenerator) {

        this.spielfelder = spielfeldGenerator.getSpielfeldFelder();
        this.breite = spielfeldGenerator.getBreite();
        this.hoehe = spielfeldGenerator.getHoehe();
    }
}
