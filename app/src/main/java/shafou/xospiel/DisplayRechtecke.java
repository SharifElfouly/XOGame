package shafou.xospiel;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse stellt ein Quadrat aus dem dargestellten Display dar. Ein
 * LayoutDisplay Objekt stellt ein 1/9 des gesamten Layout Displays dar.
 *
 * Ein DisplayRechtecke wird aus 4 Positionen zusammengestellt.
 * Ein DisplayRechtecke ist immutable.
 *
 * x1 --------------- x2
 *    |             |
 *    |             |
 *    |             |
 *    |             |
 * x4 --------------- x3
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 26.05.2017 ELF Klasse erstellt.
 */

public class DisplayRechtecke {

    /** Position x1 */
    private final Position x1;

    /** Position x2 */
    private final Position x2;

    /** Position x3 */
    private final Position x3;

    /** Position x4 */
    private final Position x4;

    /**
     * Ein LayoutOutDisplay Objekt besteht aus der Fläche zwischen 4 Positionen
     *
     * @param x1 Position x1
     * @param x2 Position x2
     * @param x3 Position x3
     * @param x4 Position x4
     */
    public DisplayRechtecke(Position x1, Position x2, Position x3,
                            Position x4) {

        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }

    public Position getX1() {
        return x1;
    }

    public Position getX2() {
        return x2;
    }

    public Position getX3() {
        return x3;
    }

    public Position getX4() {
        return x4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisplayRechtecke that = (DisplayRechtecke) o;

        if (x1 != null ? !x1.equals(that.x1) : that.x1 != null) return false;
        if (x2 != null ? !x2.equals(that.x2) : that.x2 != null) return false;
        if (x3 != null ? !x3.equals(that.x3) : that.x3 != null) return false;
        return x4 != null ? x4.equals(that.x4) : that.x4 == null;

    }

    @Override
    public int hashCode() {
        int result = x1 != null ? x1.hashCode() : 0;
        result = 31 * result + (x2 != null ? x2.hashCode() : 0);
        result = 31 * result + (x3 != null ? x3.hashCode() : 0);
        result = 31 * result + (x4 != null ? x4.hashCode() : 0);
        return result;
    }
}
