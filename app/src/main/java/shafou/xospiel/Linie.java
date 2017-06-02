package shafou.xospiel;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse stellt eine Linie dar.
 * Eine Linie besteht aus einem Anfangs und einem Endpunkt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1)
 * 01.06.2017 ELF Klasse erstellt.
 */

public class Linie {

    /** Stellt den Anfangspunkt der Linie dar */
    private final Position anfangsPosition;

    /** Stellt den End Punkt der Linie dar */
    private final Position endPosition;

    public Linie(Position anfangsPosition, Position endPosition) {

        this.anfangsPosition = anfangsPosition;
        this.endPosition = endPosition;
    }

    public Position getAnfangsPosition() {
        return anfangsPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    @Override
    public String toString() {
        return "Linie{" +
                "anfangsPosition=" + anfangsPosition +
                ", endPosition=" + endPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linie linie = (Linie) o;

        if (anfangsPosition != null ? !anfangsPosition.equals(linie.anfangsPosition) : linie.anfangsPosition != null)
            return false;
        return endPosition != null ? endPosition.equals(linie.endPosition) : linie.endPosition == null;

    }

    @Override
    public int hashCode() {
        int result = anfangsPosition != null ? anfangsPosition.hashCode() : 0;
        result = 31 * result + (endPosition != null ? endPosition.hashCode() : 0);
        return result;
    }
}
