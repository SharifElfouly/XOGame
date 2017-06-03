package shafou.xospiel.Spielfeld;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;

/**
 *
 * Diese Klasse stellt Methoden zur Verfügung, um ein X O Spielfeld beliebiger
 * Größe zu erstellen.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 01.06.2017 ELF Klasse erstellt.
 */

public final class XOSpielfeldGenerator {

    /** Breite des Spielfeldes */
    private final float breite;

    /** Höhe des Spielfeldes */
    private final float hoehe;

    /**
     * Ein Spielfeld setzt sich aus der Höhe und der Breite zusammen
     *
     * @param breite Breite des Spielfeldes
     * @param hoehe Hoehe des Spielfeldes
     */
    public XOSpielfeldGenerator(float breite, float hoehe) {

        if(breite <= 0 || hoehe <= 0) {
            throw new IllegalArgumentException("Breite und Höhe müssen größer als 0 sein.");
        }

        this.breite = breite;
        this.hoehe = hoehe;
    }

    /**
     * Baut mithilfe der errechneten Positionen, die Linien des Spielfeldes auf.
     *
     * Gibt eine Liste von Linien zurück.
     *
     * @param spalten Anzahl der Spalten des Spielfeldes
     * @param reihen Anzahl der Reihen des Spielfeldes
     * @return Eine Liste von Linien
     */
    public ArrayList<Linie> feldlinienBerechnen(int spalten, int reihen) {

        /** Spielfeld muss mindestens 3x3 groß sein */
        if(spalten < 3 || reihen < 3) {

            throw new IllegalArgumentException("Spalten und Reihen müssen" +
                    " mindestens 3 sein.");
        }

        /** Gibt die Positionen des Spielfeldes zurück */
        ArrayList<Position> positionen = FeldRechner.positionenBerechnen(this.breite, this.hoehe, spalten, reihen);

        /** Liste mit den zu zeichnenden Linien */
        ArrayList<Linie> xOFeldLinien = new ArrayList<>();

        /** Gibt die gesamte Zahl von benötigten Linien an */
        int anzahlGesuchterLinien = spalten + reihen - 2;

        /** Anzahl der senkrechten Linien */
        int anzahlSenkrechteLinien = spalten - 1;

        /** Anzahl der horizontalen Linien */
        int anzahlHorizontaleLinien = reihen - 1;

        /** Momentane Anzahl an gefundenen Senkrechten Linien */
        int indexSenkrechterLinien = 0;

        /** Momentane Anzahl an gefundenen Horizontalen Linien */
        int indexHorizontalerLinien = 0;

        /**
         * Die Iteration wird nur solange durchgeführt bis alle Linien gefunden
         * wurden.
         */
        for(int i = 1; xOFeldLinien.size() < anzahlGesuchterLinien; i++) {

            Position aktuellePosition = positionen.get(i);

            /** Alle Senkrechten Linien haben als Startpunkt die yKoordinate 0 */
            if(aktuellePosition.getyPosition() == 0) {

                indexSenkrechterLinien++;

                /**
                 * Alle Linien werden betrachtet, außer die letzte Position die
                 * als yKoordinate eine 0 hat, da diese nicht mehr zum Spielfeld
                 * gehört.
                 */
                if(indexSenkrechterLinien != anzahlSenkrechteLinien + 1) {

                    Position startPosition
                            = new Position(aktuellePosition.getxPosition(), 0);
                    /** Der Endpunkt wird mithilfe der Höhe berechnet */
                    Position endPosition
                            = new Position(aktuellePosition.getxPosition(), this.hoehe);

                    Linie senkrechteLinie = new Linie(startPosition, endPosition);
                    xOFeldLinien.add(senkrechteLinie);
                }
            }

            /** Alle horizontalen Linien haben als Startpunkt die xKoordinate 0 */
            if(aktuellePosition.getxPosition() == 0) {

                indexHorizontalerLinien++;

                /**
                 * Alle Linien werden betrachtet, außer die letzte Position die
                 * als xKoordinate eine 0 hat, da diese nicht mehr zum Spielfeld
                 * gehört.
                 */
                if(indexHorizontalerLinien != anzahlHorizontaleLinien + 1) {

                    Position startPosition
                            = new Position(0, aktuellePosition.getyPosition());
                    /** Der Endpunkt wird mithilfe der Breite berechnet */
                    Position endPosition
                            = new Position(this.breite, aktuellePosition.getyPosition());

                    Linie horizontaleLinie = new Linie(startPosition, endPosition);
                    xOFeldLinien.add(horizontaleLinie);
                }
            }
        }

        return xOFeldLinien;
    }

    /**
     * Für die Implementierung der Linien Berechnung { @see
     * {@link XOSpielfeldGenerator#feldlinienBerechnen(int, int)}}
     *
     * Zusätslich können die generierten Linien mit einem Prozentsatz angepasst
     * werden.
     *
     * Beispiel: Bei der Angabe von 10% wird eine Linie auf beiden Seiten um 10%
     * gekürtzt.
     *
     * @param spalten Anzahl der Spalten des Spielfeldes
     * @param reihen Anzahl der Reihen des Spielfeldes
     * @param prozent Prozent mit dem die gezeichneten Linien angepasst werden
     * @return Eine Liste von angepassten Linien, die ein X O Spielfeld darstellen
     */
    public ArrayList<Linie> feldLinienBerechnen(int spalten, int reihen, int prozent) {

        if(prozent <= 0) {

            throw new IllegalArgumentException("Prozent muss positiv sein.");
        }

        /** Nicht angepasste Linien */
        ArrayList<Linie> xOFeldLinien = feldlinienBerechnen(spalten, reihen);

        /** Liste von angepassten Linien */
        ArrayList<Linie> xOFeldLinienAngepasst = new ArrayList<>();

        /** Iteration über alle nicht angepassten Linien */
        for(Linie linie: xOFeldLinien) {

            /**
             * Falls die Y Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine senkrechte Linie
             */
            if(linie.getAnfangsPosition().getyPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Linie */
                int anfangsPositionX = (int) linie.getAnfangsPosition().getxPosition();
                int anfangsPositionY = (int) prozentBerechnen(this.hoehe, prozent);
                int endPositionX = (int) linie.getAnfangsPosition().getxPosition();
                int endPositionY = (int) (this.hoehe - ((int) prozentBerechnen(this.hoehe, prozent)));

                Linie angepassteLinie = new Linie(new Position(anfangsPositionX, anfangsPositionY), new Position(endPositionX, endPositionY));
                xOFeldLinienAngepasst.add(angepassteLinie);
            }

            /**
             * Falls die X Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine horizontale Linie
             */
            if(linie.getAnfangsPosition().getxPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Linie */
                int anfangsPositionX = (int) prozentBerechnen(this.breite, prozent);
                int anfangsPositionY = (int) linie.getAnfangsPosition().getyPosition();
                int endPositionX = (int) (this.breite - ((int) prozentBerechnen(this.breite, prozent)));
                int endPositionY = (int) linie.getAnfangsPosition().getyPosition();

                Linie angepassteLinie = new Linie(new Position(anfangsPositionX, anfangsPositionY), new Position(endPositionX, endPositionY));
                xOFeldLinienAngepasst.add(angepassteLinie);
            }
        }

        return xOFeldLinienAngepasst;
    }

    /**
     * Berechnet den Prozentsatz eines Betrages.
     *
     * @param betrag Betrag
     * @param prozent Prozent
     * @return Prozentsatz
     */
    public static double prozentBerechnen(double betrag, double prozent) {

        /** Betrag und Prozent müssen positiv sein */
        if(betrag <= 0 || prozent <= 0) {

            throw new IllegalArgumentException("Prozent und Betrag müssen" +
                    " positiv sein");
        }

        double prozentQuotient = prozent / 100;

        return betrag * prozentQuotient;
    }
}
