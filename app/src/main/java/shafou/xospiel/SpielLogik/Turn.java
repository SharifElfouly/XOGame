package shafou.xospiel.SpielLogik;

import android.graphics.Canvas;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.Token;

/**
 *
 * <p>Diese Klasse stellt einen Turn im Spiel dar.
 *
 * Ein Turn ist immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 */

public class Turn {

    /**
     * Gibt die Nummer des Zuges zurück. Die zugNummer hat einen Wert zwischen
     * [n und m].
     */
    private int zugNummer;

    /** Ist der im jeweiligen Turn gespielte Token */
    private final Token token;

    /** Das Field auf dem sich der Token befindet */
    private final Field field;

    /**
     * Ein Turn besteht aus der jewiligen Turn Nummer und dem gespielten
     * Token.
     *
     * @param token Der gespielte Token
     * @param field Field auf dem der Token gespielt wurde
     */
    public Turn(Token token, Field field) {
        this.token = token;
        this.field = field;
    }

    /**
     * Zeichnet den Token auf das zugehörige Spielfeld.
     *
     * @param canvas Spielfeld
     */
    public void draw(Canvas canvas) {

        Position x1 = this.field.getX1();
        Position x3 = this.field.getX3();

        int linksObenX = (int) x1.getXPosition();
        int linksObenY = (int) x1.getYPosition();
        int rechtsUntenX = (int) x3.getXPosition();
        int rechtsUntenY = (int) x3.getYPosition();

        this.token.getDrawable().setBounds(
                linksObenX,
                linksObenY,
                rechtsUntenX,
                rechtsUntenY
        );
        this.token.getDrawable().draw(canvas);
    }

    /** Gibt den Token zurück */
    public Token getToken() {
        return token;
    }

    public Field getField() {
        return field;
    }

    /** Gibt die Nummer des gespielten Turn zurück */
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

            return "Dieser ist der Turn wurde noch nicht gespielt."
                    + "\n"
                    + this.token.toString();

        } else {

            return "Dieser ist der Turn Nr. "
                    + this.zugNummer
                    + "\n"
                    + this.token.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turn turn = (Turn) o;

        return field != null ? field.equals(turn.field) : turn.field == null;

    }

    @Override
    public int hashCode() {
        return field != null ? field.hashCode() : 0;
    }
}
