package shafou.xospiel.PlayingField;

import shafou.xospiel.GameLogic.Position;

/**
 *
 * This class represents a field on the playing field.
 *
 * One field is constructed of 4 points.
 * A field is immutable.
 *
 * x1 --------------- x2
 *    |             |
 *    |             |
 *    |             |
 *    |             |
 * x4 --------------- x3
 *
 * A field can have an index in relation to the whole playing field. In this
 * example this field could have the positionOnPlayingField 1/1 or 2/1.
 * --------------------
 * |        |         |
 * |   1/1  |   2/1   |
 * |        |         |
 * --------------------
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 26.05.2017 Class created.
 * 2) 11.06.2017 ELF Relative positionOnPlayingField added.
 */

public class Field {

    private final Position x1;

    private final Position x2;

    private final Position x3;

    private final Position x4;

    /** Every field has an unique index. */
    private final int index;

    /** Relative positionOnPlayingField on the field */
    private Position positionOnPlayingField;

    /**
     * A field is constructed from 4 positions and an index.
     *
     * @param x1 Position x1
     * @param x2 Position x2
     * @param x3 Position x3
     * @param x4 Position x4
     * @param index Index des Spielfeldes
     */
    public Field(Position x1, Position x2, Position x3,
                 Position x4, int index) {

        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.index = index;
    }

    public void setPositionOnPlayingField(Position positionOnPlayingField) {
        this.positionOnPlayingField = positionOnPlayingField;
    }

    public Position getPositionOnPlayingField() {
        return positionOnPlayingField;
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

    public int getIndex() {
        return index;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (index != field.index) return false;
        if (x1 != null ? !x1.equals(field.x1) : field.x1 != null) return false;
        if (x2 != null ? !x2.equals(field.x2) : field.x2 != null) return false;
        if (x3 != null ? !x3.equals(field.x3) : field.x3 != null) return false;
        return x4 != null ? x4.equals(field.x4) : field.x4 == null;

    }

    @Override
    public int hashCode() {
        int result = x1 != null ? x1.hashCode() : 0;
        result = 31 * result + (x2 != null ? x2.hashCode() : 0);
        result = 31 * result + (x3 != null ? x3.hashCode() : 0);
        result = 31 * result + (x4 != null ? x4.hashCode() : 0);
        result = 31 * result + index;
        return result;
    }
}
