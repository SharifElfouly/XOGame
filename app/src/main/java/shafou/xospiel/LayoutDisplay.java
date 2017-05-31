package shafou.xospiel;

/**
 *
 * Diese Klasse stellt das gesamte Layout auf dem das Spiel stattfindet dar.
 *
 * <p>AUf dem Layout Display wird das gesamte Spiel dargestellt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 26.05.2017 ELF Klasse erstellt.
 */

public class LayoutDisplay {

    /** Breite eines Layouts */
    private float breite;

    /** Höhe eines Layouts */
    private float hoehe;

    /** Ein LayoutDisplay besteht aus Breite und Höhe des Layouts */
    public LayoutDisplay(float breite, float hoehe) {

        this.breite = breite;
        this.hoehe = hoehe;
    }

    public float getBreite() {
        return breite;
    }

    public void setBreite(float breite) {
        this.breite = breite;
    }

    public float getHoehe() {
        return hoehe;
    }

    public void setHoehe(float hoehe) {
        this.hoehe = hoehe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LayoutDisplay that = (LayoutDisplay) o;

        if (Float.compare(that.breite, breite) != 0)
            return false;
        return Float.compare(that.hoehe, hoehe) == 0;

    }

    @Override
    public int hashCode() {
        int result = (breite != +0.0f ? Float.floatToIntBits(breite) : 0);
        result = 31 * result + (hoehe != +0.0f ? Float.floatToIntBits(hoehe) : 0);
        return result;
    }
}
