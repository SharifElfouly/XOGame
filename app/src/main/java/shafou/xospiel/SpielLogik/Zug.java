package shafou.xospiel.SpielLogik;

/**
 *
 * <p>Diese Klasse stellt einen Zug im Spiel dar.
 *
 * Ein Zug ist immutable.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 */

public class Zug {

    /**
     * Gibt die Nummer des Zuges zurück. Die zugNummer hat einen Wert von
     * [1 und 9]. Falls der Zug noch nicht gespielt wurde, enthält er den Wert 0
     */
    private int zugNummer;

    /** Ist der im jeweiligen Zug gespielte Spielstein */
    private final Spielstein spielstein;

    /**
     * Ein Zug besteht aus der jewiligen Zug Nummer und dem gespielten
     * Spielstein.
     *
     * @param spielstein Der gespielte Spielstein
     */
    public Zug(Spielstein spielstein) {
        this.spielstein = spielstein;
    }

    /** Gibt den Spielstein zurück */
    public Spielstein getSpielstein() {
        return spielstein;
    }

    /** Gibt die Nummer des gespielten Zug zurück */
    public int getZugNummer() {
        return zugNummer;
    }

    /** Setzt die Nummer des Zuges */
    public void setZugNummer(int zugNummer) {
        this.zugNummer = zugNummer;
    }

    @Override
    public String toString() {

        if(zugNummer == 0) {

            return "Dieser ist der Zug wurde noch nicht gespielt."
                    + "\n"
                    + this.spielstein.toString();

        } else {

            return "Dieser ist der Zug Nr. "
                    + this.zugNummer
                    + "\n"
                    + this.spielstein.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zug zug = (Zug) o;

        return spielstein != null ? spielstein.equals(zug.spielstein) : zug.spielstein == null;

    }

    @Override
    public int hashCode() {
        return spielstein != null ? spielstein.hashCode() : 0;
    }
}
