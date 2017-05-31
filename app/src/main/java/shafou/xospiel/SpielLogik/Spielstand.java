package shafou.xospiel.SpielLogik;

import java.util.ArrayList;
import java.util.HashSet;

import shafou.xospiel.TestDaten.AlleMoeglichenPositionen;

/**
 *
 * <p>Diese Klasse repräsentiere den Spielstand des aktuellen Spiels.
 *
 * Ein Spielstand ist ein Singelton. Zur Laufzeit existiert nur ein Spielstand
 * Objekt.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 * 1) 25.05.2017 ELF Klasse Spiel Logik hinzugefügt.
 */

public class Spielstand {

    /** Das Singelton Spielstand Objekt */
    private static Spielstand spielstand;

    /** Gibt die Anzahl der bereits gespielten Züge zurück */
    private static Integer zugNummerGesamt;

    /** Enthält die bereits gespielten Züge */
    private static HashSet<Zug> gespielteZuege;

    /** Beinhaltet den zu letzt gespielten Zug */
    private static Zug letzterZug;

    /** Die Maximale Anzahl von Zügen beträgt 9 */
    private static final int MAX_ZUG_ANZAHL = 9;

    /** Text der Exception, falls das Feld besetzt ist */
    public static final String FELD_IST_BESETZT_TEXT = "Dieses Feld ist bereits"
            + " besetzt";

    /** Spielstand kann nicht instantiiert werden */
    private Spielstand() {}

    /**
     * Gibt eine Instanz des Spielstands zurück, falls diese nicht bereits
     * existiert.
     * Mithilfe dieser Methode wird ein Spiel gestartet.
     */
    public static Spielstand starteSpiel() {

        if(spielstand == null) {

            spielstand = new Spielstand();

            Spielstand.gespielteZuege = new HashSet<>();

            /** Das Spiel startet, zur Zeit ist es Zug 0 */
            Spielstand.zugNummerGesamt = 0;
        }

        return spielstand;
    }

    /**
     * Das alte Spielstand Objekt wird null gesetzt und das Spiel neu gestartet,
     * dieses wird dann zurückgegeben.
     *
     * @return Das neue Spielstand Objekt
     */
    public static Spielstand starteSpielNeu() {

        Spielstand.spielstand = null;
        Spielstand.gespielteZuege = null;

        return Spielstand.starteSpiel();
    }

    /**
     * Wird ausgeführt wenn der Spieler sein Zug gespielt hat. Der Zug wird der
     * Züge Liste hinzugefügt.
     *
     * @param zug Der gespielte Zug
     * @return Status des aktuellen Spielfeldes
     * @throws FeldIstBesetztException Wird geworfen falls das Feld bereits
     * besetzt ist
     */
    public static Status zugGespielt(Zug zug) throws FeldIstBesetztException {

        if(istFeldBesetzt(zug.getSpielstein().getPosition())) {

            throw new FeldIstBesetztException(FELD_IST_BESETZT_TEXT);
        }

        Spielstand.gespielteZuege.add(zug);

        Spielstand.zugNummerGesamt++;

        /**
         * Wenn der Zug gespielt wurde, wird dem Zug die Nummer des Zuges
         * zugeteilt.
         */
        zug.setZugNummer(zugNummerGesamt);

        Spielstand.letzterZug = zug;

        return analyseSpiel();
    }

    /** Gibt die Anzahl der insgesamt gespielten Zügen an */
    public static int getZugNummerGesamt() {
        return Spielstand.zugNummerGesamt;
    }

    /**
     * Testet ob die übergebene Position auf dem Spielfeld bereits besetzt ist.
     *
     * Es wird über alle bereits gespielten Züge iteriert und die übergeben
     * Position mit der Position des Zuges verglichen.
     *
     * @param position Übergebene Position
     * @return <code>true</code> Falls die Position auf dem Spielfeld bereits
     * besetzt ist.
     */
    public static boolean istFeldBesetzt(Position position) {

        boolean istFeldBesetzt = false;

        for(Zug zug: gespielteZuege) {

            if(zug.getSpielstein().getPosition().equals(position)) {

                istFeldBesetzt = true;
                break;
            }
        }

        return istFeldBesetzt;
    }

    /**
     * Analysiert das aktuelle Spielfeld.
     *
     * Iteriert über das gesamte Spielfeld. Anhand des letzten Zugs werden alle
     * zugehörigen Spielsteine durchlaufen und deren Position gespeichert. Diese
     * Positionen werden mit Gewinnsequenzen verglichen.
     *
     * @return Status, der den Status des Spielfeld angibt
     */
    public static Status analyseSpiel() {

        /** Erst nach dem 5 Zug könnte eine Gewinner gefunden werden */
        if(Spielstand.zugNummerGesamt < 5) {

            return new Status(false, letzterZug);
        }

        ArrayList<Position> xPositionen = new ArrayList<>();
        ArrayList<Position> oPositionen = new ArrayList<>();

        for(Zug zug: gespielteZuege) {

            if(zug.getSpielstein() instanceof XSpielstein) {

                xPositionen.add(zug.getSpielstein().getPosition());
            } else {

                oPositionen.add(zug.getSpielstein().getPosition());
            }
        }

        if(letzterZug.getSpielstein() instanceof XSpielstein) {

            return hatXGewonnen(xPositionen);
        } else {

            return hatOGewonnen(oPositionen);
        }
    }

    /**
     * Vergleicht alle X Steine Positionen mit den Gewinnsequenzen.
     *
     * @param xPositionen X Positionen auf dem Spielfeld
     * @return Status, der den Status des Spielfeld angibt.
     */
    private static Status hatXGewonnen(ArrayList<Position> xPositionen) {

        for(ArrayList<Position> gewinnSequenzen:
                AlleMoeglichenPositionen.alleGewinnSequenzen){

            if(xPositionen.containsAll(gewinnSequenzen)) {

                return new Status(true, letzterZug);
            }
        }

        return new Status(false, letzterZug);
    }

    /**
     * Vergleicht alle O Steine Positionen mit den Gewinnsequenzen.
     *
     * @param oPositionen o Positionen auf dem Spielfeld
     * @return Status, der den Status des Spielfeld angibt.
     */
    private static Status hatOGewonnen(ArrayList<Position> oPositionen) {

        for(ArrayList<Position> gewinnSequenzen:
                AlleMoeglichenPositionen.alleGewinnSequenzen){

            if(oPositionen.containsAll(gewinnSequenzen)) {

                return new Status(true, letzterZug);
            }
        }

        return new Status(false, letzterZug);
    }
}
