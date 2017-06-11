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

public final class XOSpielfeldGenerator implements SpielfeldGenerator{

    /** Breite des Spielfeldes */
    private float breite;

    /** Höhe des Spielfeldes */
    private float hoehe;

    /** Anzahl der Spalten des Spielfeldes */
    private final int spalten;

    /** Anzahl der Reihen des Spielfeldes */
    private final int reihen;

    /** Beinhaltet die Felder des Spielfeldes */
    private ArrayList<Feld> spielfeldFelder;

    /**
     * Ein Spielfeld setzt sich aus der Höhe und der Breite zusammen
     * @param breite Breite des Spielfeldes
     * @param hoehe Hoehe des Spielfeldes
     * @param spalten Anzahl der Spalten des Spielfeldes
     * @param reihen Anzahl der Reihen des Spielfeldes
     */
    public XOSpielfeldGenerator(float breite, float hoehe, int spalten, int reihen) {

        if(breite <= 0 || hoehe <= 0) {
            throw new IllegalArgumentException("Breite und Höhe müssen größer als 0 sein.");
        }

        if(spalten!= reihen || spalten < 3 || reihen < 3) {

            throw new IllegalArgumentException("Ein X/O Feld muss die gleiche" +
                    " Anzahl von Reihen und Spalten haben und muss mindestens" +
                    " 3x3 groß sein.");
        }

        this.breite = breite;
        this.hoehe = hoehe;
        this.spalten = spalten;
        this.reihen = reihen;

        spielfeldFelder = FeldRechner.spielfelderBerechnen(this.breite, this.hoehe, this.spalten, this.reihen);
    }

    /**
     * Ein Spielfeld setzt sich aus den Spalten und Reihen zusammen.
     * @param spalten Anzahl der Spalten des Spielfeldes
     * @param reihen Anzahl der Reihen des Spielfeldes
     */
    public XOSpielfeldGenerator(int spalten, int reihen) {

        if(spalten!= reihen || spalten < 3 || reihen < 3) {

            throw new IllegalArgumentException("Ein X/O Feld muss die gleiche" +
                    " Anzahl von Reihen und Spalten haben und muss mindestens" +
                    " 3x3 groß sein.");
        }

        this.spalten = spalten;
        this.reihen = reihen;
    }

    @Override
    public ArrayList<Feld> getSpielfeldFelder() {
        return this.spielfeldFelder;
    }

    public void berechneSpielfelder() {
        this.spielfeldFelder = FeldRechner.spielfelderBerechnen(this.breite, this.hoehe, this.spalten, this.reihen);
    }

    /**
     * Baut mithilfe der errechneten Positionen, die Linien des Spielfeldes auf.
     *
     * Gibt eine Liste von Linien zurück.
     *
     * @return Eine Liste von Linien
     */
    public ArrayList<Linie> feldlinienBerechnen() {

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
            if(aktuellePosition.getYPosition() == 0) {

                indexSenkrechterLinien++;

                /**
                 * Alle Linien werden betrachtet, außer die letzte Position die
                 * als yKoordinate eine 0 hat, da diese nicht mehr zum Spielfeld
                 * gehört.
                 */
                if(indexSenkrechterLinien != anzahlSenkrechteLinien + 1) {

                    Position startPosition
                            = new Position(aktuellePosition.getXPosition(), 0);
                    /** Der Endpunkt wird mithilfe der Höhe berechnet */
                    Position endPosition
                            = new Position(aktuellePosition.getXPosition(), this.hoehe);

                    Linie senkrechteLinie = new Linie(startPosition, endPosition);
                    xOFeldLinien.add(senkrechteLinie);
                }
            }

            /** Alle horizontalen Linien haben als Startpunkt die xKoordinate 0 */
            if(aktuellePosition.getXPosition() == 0) {

                indexHorizontalerLinien++;

                /**
                 * Alle Linien werden betrachtet, außer die letzte Position die
                 * als xKoordinate eine 0 hat, da diese nicht mehr zum Spielfeld
                 * gehört.
                 */
                if(indexHorizontalerLinien != anzahlHorizontaleLinien + 1) {

                    Position startPosition
                            = new Position(0, aktuellePosition.getYPosition());
                    /** Der Endpunkt wird mithilfe der Breite berechnet */
                    Position endPosition
                            = new Position(this.breite, aktuellePosition.getYPosition());

                    Linie horizontaleLinie = new Linie(startPosition, endPosition);
                    xOFeldLinien.add(horizontaleLinie);
                }
            }
        }

        return xOFeldLinien;
    }

    /**
     * Für die Implementierung der Linien Berechnung { @see
     * {@link XOSpielfeldGenerator#feldlinienBerechnen()}}
     *
     * Zusätslich können die generierten Linien mit einem Prozentsatz angepasst
     * werden.
     *
     * Beispiel: Bei der Angabe von 10% wird eine Linie auf beiden Seiten um 10%
     * gekürtzt.
     *
     * @param prozent Prozent mit dem die gezeichneten Linien angepasst werden
     * @return Eine Liste von angepassten Linien, die ein X O Spielfeld darstellen
     */
    public ArrayList<Linie> feldLinienBerechnen(int prozent) {

        if(prozent <= 0) {

            throw new IllegalArgumentException("Prozent muss positiv sein.");
        }

        /** Nicht angepasste Linien */
        ArrayList<Linie> xOFeldLinien = feldlinienBerechnen();

        /** Liste von angepassten Linien */
        ArrayList<Linie> xOFeldLinienAngepasst = new ArrayList<>();

        /** Iteration über alle nicht angepassten Linien */
        for(Linie linie: xOFeldLinien) {

            /**
             * Falls die Y Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine senkrechte Linie
             */
            if(linie.getAnfangsPosition().getYPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Linie */
                int anfangsPositionX = (int) linie.getAnfangsPosition().getXPosition();
                int anfangsPositionY = (int) prozentBerechnen(this.hoehe, prozent);
                int endPositionX = (int) linie.getAnfangsPosition().getXPosition();
                int endPositionY = (int) (this.hoehe - ((int) prozentBerechnen(this.hoehe, prozent)));

                Linie angepassteLinie = new Linie(new Position(anfangsPositionX, anfangsPositionY), new Position(endPositionX, endPositionY));
                xOFeldLinienAngepasst.add(angepassteLinie);
            }

            /**
             * Falls die X Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine horizontale Linie
             */
            if(linie.getAnfangsPosition().getXPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Linie */
                int anfangsPositionX = (int) prozentBerechnen(this.breite, prozent);
                int anfangsPositionY = (int) linie.getAnfangsPosition().getYPosition();
                int endPositionX = (int) (this.breite - ((int) prozentBerechnen(this.breite, prozent)));
                int endPositionY = (int) linie.getAnfangsPosition().getYPosition();

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

    public void setBreite(float breite) {

        if(breite <= 0) {

            throw new IllegalArgumentException("Breite muss positiv sein");
        }

        this.breite = breite;
    }

    public void setHoehe(float hoehe) {

        if(hoehe <= 0) {

            throw new IllegalArgumentException("Höhe muss positiv sein");
        }

        this.hoehe = hoehe;
    }

    public float getBreite() {
        return breite;
    }

    public float getHoehe() {
        return hoehe;
    }
}
