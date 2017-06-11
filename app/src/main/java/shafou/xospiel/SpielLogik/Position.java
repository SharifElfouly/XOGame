package shafou.xospiel.SpielLogik;

/**
 *
 * Diese Klasse stellt die Position auf dem Spielfeld dar.
 *
 * <p>Die X und Y Koordinaten werden niemals von außen gesetzt, daher werden
 * keine Setter benötigt.
 *
 * <p>Eine Position ist immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 23.05.2017 ELF Klasse angelegt.
 */

public final class Position {

    /** X Koordinate auf dem Spielfeld */
    private final float xPosition;

    /** Y Koordinate auf dem Spielfeld */
    private final float yPosition;

    /** Exception Text bei falscher Angabe der X Koordinate */
    public static final String X_ILLEGAL_ARGUMENT_TEXT = "X Position ist nicht"
            + " im vorgesehenen Intervall";

    /** Exception Text bei falscher Angabe der Y Koordinate */
    public static final String Y_ILLEGAL_ARGUMENT_TEXT = "Y Position ist nicht"
            + " im vorgesehenen Intervall";

    /**
     * Eine Position auf dem Spielfeld besteht aus einer X und einer Y
     * Koordinate.
     *
     * Eine Exception wird aufgerufen falls sich die X Koordinate nicht in den
     * Intervallen MAX_X_POSITION und MIN_X_POSITION befindet. Das gleiche gilt
     * für die Y Koordinate und deren korrespondierenden Intervall.
     *
     * Die Initialisierung wird bereits bei einem Fehler der X Koordinate
     * abgebrochen.
     *
     * @param xPosition X Koordinate
     * @param yPosition Y Koordinate
     */
    public Position(float xPosition, float yPosition) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (Float.compare(position.xPosition, xPosition) != 0) return false;
        return Float.compare(position.yPosition, yPosition) == 0;

    }

    @Override
    public int hashCode() {
        int result = (xPosition != +0.0f ? Float.floatToIntBits(xPosition) : 0);
        result = 31 * result + (yPosition != +0.0f ? Float.floatToIntBits(yPosition) : 0);
        return result;
    }
}
