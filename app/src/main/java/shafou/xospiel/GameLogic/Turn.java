package shafou.xospiel.GameLogic;

import android.graphics.Canvas;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.Token;

/**
 *
 * <p>This class represents a turn in the game.
 *
 * A Turn is immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 24.05.2017 ELF Class created.
 */

public class Turn {

    /** Holds the number of the turn. */
    private int turnNumber;

    /** The token that is played this turn */
    private final Token token;

    /** The field the token is played on */
    private final Field field;

    /**
     * A turn consists of a token and a field on which the token is played on.
     *
     * @param token The played token
     * @param field The field the token is played on
     */
    public Turn(Token token, Field field) {

        this.token = token;
        this.field = field;
    }

    /**
     * Draws the token on its field
     *
     * @param canvas playing field
     */
    public void draw(Canvas canvas) {

        Position x1 = this.field.getX1();
        Position x3 = this.field.getX3();

        int topLeftX = (int) x1.getXPosition();
        int topLeftY = (int) x1.getYPosition();
        int bottomRightX = (int) x3.getXPosition();
        int bottomRightY = (int) x3.getYPosition();

        this.token.getDrawable().setBounds(
                topLeftX,
                topLeftY,
                bottomRightX,
                bottomRightY
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
    public int getTurnNumber() {
        return turnNumber;
    }

    /** Setzt die Nummer des Zuges */
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "field=" + field +
                ", turnNumber=" + turnNumber +
                ", token=" + token +
                '}';
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
