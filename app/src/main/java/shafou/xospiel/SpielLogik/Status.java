package shafou.xospiel.SpielLogik;

/**
 *
 * Diese Klasse repräsentiert den Status des Spiels nach der Analyse.
 *
 * <p>Status ist immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 25.05.2017 ELF Klasse erstellt.
 */

public class Status {

    /** Gibt an ob das gespielte Spiel gewonnen ist */
    private boolean istGewonnen;

    /** Beinhaltet den zu letzt gespielten Zug */
    private Zug letzterZug;

    public Status(boolean istGewonnen, Zug letzterZug) {

        this.istGewonnen = istGewonnen;
        this.letzterZug = letzterZug;
    }

    /** Gibt zurück ob das Spiel gewonnen wurde */
    public boolean istGewonnen() {
        return istGewonnen;
    }

    /** Gibt den zu letzt gespielten Zug */
    public Zug getLetzterZug() {
        return letzterZug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (istGewonnen != status.istGewonnen) return false;
        return letzterZug != null ? letzterZug.equals(status.letzterZug) : status.letzterZug == null;

    }

    @Override
    public int hashCode() {
        int result = (istGewonnen ? 1 : 0);
        result = 31 * result + (letzterZug != null ? letzterZug.hashCode() : 0);
        return result;
    }
}
