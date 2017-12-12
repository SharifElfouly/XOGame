package shafou.xospiel.GameLogic;

/**
 *
 * This class represents a position.
 * A position consists of a X and Y coordinate.
 *
 * A position is immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 23.05.2017 ELF Class created.
 */

public final class Position {

    private final float x;

    private final float y;

    public Position(float x, float y) {

        this.x = x;
        this.y = y;
    }

    public float getXPosition() {
        return x;
    }

    public float getYPosition() {
        return y;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (Float.compare(position.x, x) != 0) return false;
        return Float.compare(position.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }
}
