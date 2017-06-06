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
    private final ArrayList<Feld> spielfelder;

    /** Breite des Spielfeldes */
    private final float breite;

    /** Höhe des Spielfeldes */
    private final float hoehe;

    public SpielfeldInputVerarbeiter(T spielfeldGenerator) {

        this.spielfelder = spielfeldGenerator.getSpielfeldFelder();
        this.breite = spielfeldGenerator.getBreite();
        this.hoehe = spielfeldGenerator.getHoehe();
    }

    /**
     * Gibt an ob der Input des Spielers im Spielfeld ist
     * @param inputPosition Position des Inputs des Spielers
     * @return <code>true</code> falls sich der Input auf dem Spielfeld befindet.
     */
    public boolean istEingabeAufFeld(Position inputPosition) {

        return inputPosition.getxPosition() < breite
                && inputPosition.getyPosition() < hoehe
                && inputPosition.getxPosition() > 0
                && inputPosition.getyPosition() > 0;
    }

    /**
     * Gibt das Spielfeld an, in dem der User Input stattgefunden hat.
     *
     * @param inputPosition Position des Inputs
     * @return Das Spielfeld indem der Input war
     */
    public Feld gibSpielfeld(Position inputPosition) {

        for(Feld spielfeld: spielfelder) {

            if(inputPosition.getxPosition() >= spielfeld.getX1().getxPosition()
                    && inputPosition.getxPosition() <= spielfeld.getX2().getxPosition()
                    && inputPosition.getyPosition() >= spielfeld.getX1().getyPosition()
                    && inputPosition.getyPosition() <= spielfeld.getX4().getyPosition()) {

                return spielfeld;
            }
        }

        return null;
    }
}
