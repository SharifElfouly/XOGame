package shafou.xospiel.SpielLogik;

import java.util.ArrayList;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.PlayingFieldGenerator;

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

public final class PlayingFieldInputProcessor<T extends PlayingFieldGenerator> {

    /** Beinhaltet die Rechtecke des Spielfeldes */
    private ArrayList<Field> playingFields;

    /** Breite des Spielfeldes */
    private float width;

    /** Höhe des Spielfeldes */
    private float height;

    public PlayingFieldInputProcessor() {}

    /**
     * Gibt an ob der Input des Spielers im Spielfeld ist
     * @param inputPosition Position des Inputs des Spielers
     * @return <code>true</code> falls sich der Input auf dem Spielfeld befindet.
     */
    public boolean istEingabeAufFeld(Position inputPosition) {

        return inputPosition.getXPosition() < width
                && inputPosition.getYPosition() < height
                && inputPosition.getXPosition() > 0
                && inputPosition.getYPosition() > 0;
    }

    /**
     * Gibt das Spielfeld an, in dem der User Input stattgefunden hat.
     *
     * @param inputPosition Position des Inputs
     * @return Das Spielfeld indem der Input war
     */
    public Field gibSpielfeld(Position inputPosition) {

        for(Field spielfeld: playingFields) {

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

        this.playingFields = spielfeldGenerator.getPlayingFields();
        this.width = spielfeldGenerator.getWidth();
        this.height = spielfeldGenerator.getHeight();
    }
}
