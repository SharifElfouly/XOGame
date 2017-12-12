package shafou.xospiel.PlayingField;

import java.util.ArrayList;
import java.util.List;

import shafou.xospiel.GameLogic.Position;

/**
 *
 * This class is used to generate X/O playing fields.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 01.06.2017 ELF Class created erstellt.
 */

public final class XOPlayingFieldGenerator implements PlayingFieldGenerator {

    private float width;

    private float height;

    /** Amount of columns and rows of the playing field */
    private int columnsAndRows;

    /** Playing field fields */
    private List<Field> playingFields;

    /**
     * A playing field is calculated for a specific width height and columns and
     * rows.
     *
     * @param width Playing field width
     * @param height Playing field height
     * @param columnsAndRows Amount of columns and rows of the playing field
     */
    public XOPlayingFieldGenerator(float width, float height, int columnsAndRows) {

        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Columns and Rows must be positive.");
        }

        if(columnsAndRows < 3) {

            throw new IllegalArgumentException("The minimum amount of columns " +
                    "and rows required is 3.");
        }

        this.width = width;
        this.height = height;
        this.columnsAndRows = columnsAndRows;

        /** Playing fields on the field */
        playingFields = FieldsCalculator.getFields(this.width,
                this.height,
                this.columnsAndRows,
                this.columnsAndRows);
    }

    /**
     * Ein Spielfeld setzt sich aus den Spalten und Reihen zusammen.
     * @param columnsAndRows
     */
    public XOPlayingFieldGenerator(int columnsAndRows) {

        if(columnsAndRows < 3) {

            throw new IllegalArgumentException("Ein X/O Field muss die gleiche" +
                    " Anzahl von Reihen und Spalten haben und muss mindestens" +
                    " 3x3 groß sein.");
        }

        this.columnsAndRows = columnsAndRows;
    }

//    /**
//     * Instantiates a new X/O playing field generator with new columns and rows.
//     *
//     * @param columnsAndRows Amount of columns and rows of the playing field
//     * @return Updated XOPlayingFieldGenerator Instance
//     */
//    public XOPlayingFieldGenerator reInstantiateXOGenerator(int columnsAndRows) {
//
//        this.columnsAndRows = columnsAndRows;
//
//        if(width == 0F || height == 0F) {
//
//            throw new IllegalAccessError("The playing field can only be restarted" +
//                    "if a playing field was instantiated before.");
//        }
//
//        return new XOPlayingFieldGenerator(width, height, columnsAndRows);
//    }

    @Override
    public List<Field> getPlayingFields() {
        return this.playingFields;
    }

    public void berechneSpielfelder() {
        this.playingFields = FieldsCalculator.getFields(this.width,
                this.height, this.columnsAndRows, this.columnsAndRows);
    }

    /**
     * Baut mithilfe der errechneten Positionen, die Linien des Spielfeldes auf.
     *
     * Gibt eine Liste von Linien zurück.
     *
     * @return Eine Liste von Linien
     */
    public ArrayList<Line> calculatesLines() {

        /** Gibt die Positionen des Spielfeldes zurück */
        List<Position> positionen = FieldsCalculator.getPositions(this.width,
                this.height, columnsAndRows, columnsAndRows);

        int columns = columnsAndRows;
        int rows = columnsAndRows;

        /** Liste mit den zu zeichnenden Linien */
        ArrayList<Line> xOFeldLinien = new ArrayList<>();

        /** Gibt die gesamte Zahl von benötigten Linien an */
        int anzahlGesuchterLinien = columns + rows - 2;

        /** Anzahl der senkrechten Linien */
        int anzahlSenkrechteLinien = columns - 1;

        /** Anzahl der horizontalen Linien */
        int anzahlHorizontaleLinien = rows - 1;

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
                            = new Position(aktuellePosition.getXPosition(), this.height);

                    Line senkrechteLine = new Line(startPosition, endPosition);
                    xOFeldLinien.add(senkrechteLine);
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
                            = new Position(this.width, aktuellePosition.getYPosition());

                    Line horizontaleLine = new Line(startPosition, endPosition);
                    xOFeldLinien.add(horizontaleLine);
                }
            }
        }

        return xOFeldLinien;
    }

    /**
     * Für die Implementierung der Linien Berechnung { @see
     * {@link XOPlayingFieldGenerator#calculatesLines()}}
     *
     * Zusätslich können die generierten Linien mit einem Prozentsatz angepasst
     * werden.
     *
     * Beispiel: Bei der Angabe von 10% wird eine Line auf beiden Seiten um 10%
     * gekürtzt.
     *
     * @param prozent Prozent mit dem die gezeichneten Linien angepasst werden
     * @return Eine Liste von angepassten Linien, die ein X O Spielfeld darstellen
     */
    public ArrayList<Line> calculatesLines(int prozent) {

        if(prozent <= 0) {

            throw new IllegalArgumentException("Prozent muss positiv sein.");
        }

        /** Nicht angepasste Linien */
        ArrayList<Line> xOFeldLinien = calculatesLines();

        /** Liste von angepassten Linien */
        ArrayList<Line> xOFeldLinienAngepasst = new ArrayList<>();

        /** Iteration über alle nicht angepassten Linien */
        for(Line line : xOFeldLinien) {

            /**
             * Falls die Y Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine senkrechte Line
             */
            if(line.getStart().getYPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Line */
                int anfangsPositionX = (int) line.getStart().getXPosition();
                int anfangsPositionY = (int) calculatePercentage(this.height, prozent);
                int endPositionX = (int) line.getStart().getXPosition();
                int endPositionY = (int) (this.height - ((int) calculatePercentage(this.height, prozent)));

                Line angepassteLine = new Line(new Position(anfangsPositionX, anfangsPositionY), new Position(endPositionX, endPositionY));
                xOFeldLinienAngepasst.add(angepassteLine);
            }

            /**
             * Falls die X Koordinate eines Startpunktes 0 ist, handelt es sich
             * um eine horizontale Line
             */
            if(line.getStart().getXPosition() == 0) {

                /** Berechnung der neuen Start und Endpunkte der Line */
                int anfangsPositionX = (int) calculatePercentage(this.width, prozent);
                int anfangsPositionY = (int) line.getStart().getYPosition();
                int endPositionX = (int) (this.width - ((int) calculatePercentage(this.width, prozent)));
                int endPositionY = (int) line.getStart().getYPosition();

                Line angepassteLine = new Line(new Position(anfangsPositionX, anfangsPositionY), new Position(endPositionX, endPositionY));
                xOFeldLinienAngepasst.add(angepassteLine);
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
    public static double calculatePercentage(double betrag, double prozent) {

        /** Betrag und Prozent müssen positiv sein */
        if(betrag <= 0 || prozent <= 0) {

            throw new IllegalArgumentException("Prozent und Betrag müssen" +
                    " positiv sein");
        }

        double prozentQuotient = prozent / 100;

        return betrag * prozentQuotient;
    }

    public void setWidth(float width) {

        if(width <= 0) {

            throw new IllegalArgumentException("Breite muss positiv sein");
        }

        this.width = width;
    }

    public void setHeight(float height) {

        if(height <= 0) {

            throw new IllegalArgumentException("Höhe muss positiv sein");
        }

        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
