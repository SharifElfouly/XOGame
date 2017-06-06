package shafou.xospiel.Spielfeld;

/**
 *
 * Diese Klasse stellt ein Intervall dar.
 * Das Intervall hat einen inclusiven Start und Endpunkt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 06.05.2017 ELF Klasse erstellt.
 */

public class Intervall {

    private final int start;
    private final int ende;

    public Intervall(int start, int ende) {
        this.start = start;
        this.ende = ende;
    }

    public int getEnde() {
        return ende;
    }

    public int getStart() {
        return start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Intervall intervall = (Intervall) o;

        if (start != intervall.start) return false;
        return ende == intervall.ende;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + ende;
        return result;
    }
}
