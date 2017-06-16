package shafou.xospiel.PlayingField;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse stellt eine Line dar.
 * Eine Line besteht aus einem Anfangs und einem Endpunkt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1)
 * 01.06.2017 ELF Klasse erstellt.
 */

public class Line {

    /** Stellt den Anfangspunkt der Line dar */
    private final Position start;

    /** Stellt den End Punkt der Line dar */
    private final Position end;

    public Line(Position start, Position end) {

        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (start != null ? !start.equals(line.start) : line.start != null)
            return false;
        return end != null ? end.equals(line.end) : line.end == null;

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
