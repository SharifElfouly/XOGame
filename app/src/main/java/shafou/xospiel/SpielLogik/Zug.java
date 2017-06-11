package shafou.xospiel.SpielLogik;

import android.graphics.Canvas;

import shafou.xospiel.Spielfeld.Feld;
import shafou.xospiel.Spielfeld.Spielstein;

/**
 *
 * <p>Diese Klasse stellt einen Zug im Spiel dar.
 *
 * Ein Zug ist immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 */

public class Zug {

    /**
     * Gibt die Nummer des Zuges zurück. Die zugNummer hat einen Wert zwischen
     * [n und m].
     */
    private int zugNummer;

    /** Ist der im jeweiligen Zug gespielte Spielstein */
    private final Spielstein spielstein;

    /** Das Feld auf dem sich der Spielstein befindet */
    private final Feld feld;

    /**
     * Ein Zug besteht aus der jewiligen Zug Nummer und dem gespielten
     * Spielstein.
     *
     * @param spielstein Der gespielte Spielstein
     * @param feld Feld auf dem der Spielstein gespielt wurde
     */
    public Zug(Spielstein spielstein, Feld feld) {
        this.spielstein = spielstein;
        this.feld = feld;
    }

    /**
     * Zeichnet den Spielstein auf das zugehörige Spielfeld.
     *
     * @param canvas Spielfeld
     */
    public void draw(Canvas canvas) {

        Position x1 = this.feld.getX1();
        Position x3 = this.feld.getX3();

        int linksObenX = (int) x1.getXPosition();
        int linksObenY = (int) x1.getYPosition();
        int rechtsUntenX = (int) x3.getXPosition();
        int rechtsUntenY = (int) x3.getYPosition();

        this.spielstein.getSpielsteinDrawable().setBounds(
                linksObenX,
                linksObenY,
                rechtsUntenX,
                rechtsUntenY
        );
        this.spielstein.getSpielsteinDrawable().draw(canvas);
    }

    /** Gibt den Spielstein zurück */
    public Spielstein getSpielstein() {
        return spielstein;
    }

    public Feld getFeld() {
        return feld;
    }

    /** Gibt die Nummer des gespielten Zug zurück */
    public int getZugNummer() {
        return zugNummer;
    }

    /** Setzt die Nummer des Zuges */
    public void setZugNummer(int zugNummer) {
        this.zugNummer = zugNummer;
    }

    @Override
    public String toString() { 

        if(zugNummer == 0) {

            return "Dieser ist der Zug wurde noch nicht gespielt."
                    + "\n"
                    + this.spielstein.toString();

        } else {

            return "Dieser ist der Zug Nr. "
                    + this.zugNummer
                    + "\n"
                    + this.spielstein.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zug zug = (Zug) o;

        return feld != null ? feld.equals(zug.feld) : zug.feld == null;

    }

    @Override
    public int hashCode() {
        return feld != null ? feld.hashCode() : 0;
    }
}
