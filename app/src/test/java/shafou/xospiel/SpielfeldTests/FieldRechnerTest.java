package shafou.xospiel.SpielfeldTests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.GameLogic.Position;
import shafou.xospiel.PlayingField.FieldsCalculator;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse testet die Methoden des FeldRechners
 *
 * (0|0)  --------------------------------> X   (X|0)
 *        |
 *        |
 *        |
 *        |
 *        |
 *        |
 *        |
 * (0|Y)  Y                                     (X|Y)
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 03.05.2017 ELF Klasse erstellt.
 */

public class FieldRechnerTest {

    @Test
    public void PositionenBerechnen_3x3_Berechnet() {

        List<Position> generiertePositionen = FieldsCalculator.getPositions(120, 120, 3, 3);

        List<Position> testPositionen = new ArrayList<>();
        testPositionen.add(new Position(0, 0));
        testPositionen.add(new Position(40, 0));
        testPositionen.add(new Position(80, 0));
        testPositionen.add(new Position(120, 0));
        testPositionen.add(new Position(0, 40));
        testPositionen.add(new Position(40, 40));
        testPositionen.add(new Position(80, 40));
        testPositionen.add(new Position(120, 40));
        testPositionen.add(new Position(0, 80));
        testPositionen.add(new Position(40, 80));
        testPositionen.add(new Position(80, 80));
        testPositionen.add(new Position(120, 80));
        testPositionen.add(new Position(0, 120));
        testPositionen.add(new Position(40, 120));
        testPositionen.add(new Position(80, 120));
        testPositionen.add(new Position(120, 120));

        assertEquals(testPositionen, generiertePositionen);
    }

    @Test
    public void PositionenBerechnen_1x1_Berechnet() {

        List<Position> generiertePositionen = FieldsCalculator.getPositions(120, 120, 1, 1);

        List<Position> testPositionen = new ArrayList<>();
        testPositionen.add(new Position(0, 0));
        testPositionen.add(new Position(120, 0));
        testPositionen.add(new Position(0, 120));
        testPositionen.add(new Position(120, 120));

        assertEquals(testPositionen, generiertePositionen);
    }

    @Test
    public void PositionenBerechnen_1x2_Berechnet() {

        List<Position> generiertePositionen = FieldsCalculator.getPositions(120, 120, 1, 2);

        List<Position> testPositionen = new ArrayList<>();
        testPositionen.add(new Position(0, 0));
        testPositionen.add(new Position(120, 0));
        testPositionen.add(new Position(0, 60));
        testPositionen.add(new Position(120, 60));
        testPositionen.add(new Position(0, 120));
        testPositionen.add(new Position(120, 120));

        assertEquals(testPositionen, generiertePositionen);
    }

    @Test
    public void PositionenBerechnen_2x1_Berechnet() {

        List<Position> generiertePositionen = FieldsCalculator.getPositions(120, 120, 2, 1);

        List<Position> testPositionen = new ArrayList<>();
        testPositionen.add(new Position(0, 0));
        testPositionen.add(new Position(60, 0));
        testPositionen.add(new Position(120, 0));
        testPositionen.add(new Position(0, 120));
        testPositionen.add(new Position(60, 120));
        testPositionen.add(new Position(120, 120));

        assertEquals(testPositionen, generiertePositionen);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PositionenBerechnen_NegativerParameter_Exception() {

        FieldsCalculator.getPositions(120, 120, -3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PositionenBerechnen_0_Parameter_Exception() {

        FieldsCalculator.getPositions(120, 120, 0, 3);
    }

    @Test
    public void DisplayRechteckeBerechnen_3x3_Berechnet() {

        Field lDQ1 = new Field(
                new Position(0,0),
                new Position(40,0),
                new Position(40,40),
                new Position(0,40),
                1);

        Field lDQ2 = new Field(
                new Position(40,0),
                new Position(80,0),
                new Position(80,40),
                new Position(40,40),
                2);

        Field lDQ3 = new Field(
                new Position(80,0),
                new Position(120,0),
                new Position(120,40),
                new Position(80,40),
                3);

        Field lDQ4 = new Field(
                new Position(0,40),
                new Position(40,40),
                new Position(40,80),
                new Position(0,80),
                4);

        Field lDQ5 = new Field(
                new Position(40,40),
                new Position(80,40),
                new Position(80,80),
                new Position(40,80),
                5);

        Field lDQ6 = new Field(
                new Position(80,40),
                new Position(120,40),
                new Position(120,80),
                new Position(80,80),
                6);

        Field lDQ7 = new Field(
                new Position(0,80),
                new Position(40,80),
                new Position(40,120),
                new Position(0,120),
                7);

        Field lDQ8 = new Field(
                new Position(40,80),
                new Position(80,80),
                new Position(80,120),
                new Position(40,120),
                8);

        Field lDQ9 = new Field(
                new Position(80,80),
                new Position(120,80),
                new Position(120,120),
                new Position(80,120),
                9);

        List<Field> generierteLayoutDisplayQuadrate
                = FieldsCalculator.getFields(120, 120, 3, 3);

        ArrayList<Field> testLayoutDisplayListe = new ArrayList<>();

        testLayoutDisplayListe.add(lDQ1);
        testLayoutDisplayListe.add(lDQ2);
        testLayoutDisplayListe.add(lDQ3);
        testLayoutDisplayListe.add(lDQ4);
        testLayoutDisplayListe.add(lDQ5);
        testLayoutDisplayListe.add(lDQ6);
        testLayoutDisplayListe.add(lDQ7);
        testLayoutDisplayListe.add(lDQ8);
        testLayoutDisplayListe.add(lDQ9);

        assertEquals(testLayoutDisplayListe, generierteLayoutDisplayQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_3x3MitRealistischenGroessen_Berechnet() {

        /** X Display Größe in Pixel */
        final float X_LAYOUT_GROESSE = 768;

        /** Y Display Größe in Pixel */
        final float Y_LAYOUT_GROESSE = 1280;

        Field lDQ1 = new Field(
                new Position(0,0),
                new Position(1f/3f * X_LAYOUT_GROESSE, 0),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(0, 1f/3f * Y_LAYOUT_GROESSE),
                1);

        Field lDQ2 = new Field(
                new Position(1f/3f * X_LAYOUT_GROESSE, 0),
                new Position(2f/3f * X_LAYOUT_GROESSE, 0),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                2);

        Field lDQ3 = new Field(
                new Position(2f/3f * X_LAYOUT_GROESSE, 0),
                new Position(X_LAYOUT_GROESSE, 0),
                new Position(X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                3);

        Field lDQ4 = new Field(
                new Position(0, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(0, 2f/3f * Y_LAYOUT_GROESSE),
                4);

        Field lDQ5 = new Field(
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                5);

        Field lDQ6 = new Field(
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                6);

        Field lDQ7 = new Field(
                new Position(0, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(0, Y_LAYOUT_GROESSE),
                7);

        Field lDQ8 = new Field(
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                8);

        Field lDQ9 = new Field(
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                9);

        List<Field> generierteLayoutDisplayQuadrate
                = FieldsCalculator.getFields(X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE, 3, 3);

        ArrayList<Field> testLayoutDisplayListe = new ArrayList<>();

        testLayoutDisplayListe.add(lDQ1);
        testLayoutDisplayListe.add(lDQ2);
        testLayoutDisplayListe.add(lDQ3);
        testLayoutDisplayListe.add(lDQ4);
        testLayoutDisplayListe.add(lDQ5);
        testLayoutDisplayListe.add(lDQ6);
        testLayoutDisplayListe.add(lDQ7);
        testLayoutDisplayListe.add(lDQ8);
        testLayoutDisplayListe.add(lDQ9);

        assertEquals(testLayoutDisplayListe.get(0), generierteLayoutDisplayQuadrate.get(0));
        assertEquals(testLayoutDisplayListe.get(1), generierteLayoutDisplayQuadrate.get(1));
        assertEquals(testLayoutDisplayListe.get(2), generierteLayoutDisplayQuadrate.get(2));
        assertEquals(testLayoutDisplayListe.get(3), generierteLayoutDisplayQuadrate.get(3));
        assertEquals(testLayoutDisplayListe.get(4), generierteLayoutDisplayQuadrate.get(4));
        assertEquals(testLayoutDisplayListe.get(5), generierteLayoutDisplayQuadrate.get(5));
        assertEquals(testLayoutDisplayListe.get(6), generierteLayoutDisplayQuadrate.get(6));
        assertEquals(testLayoutDisplayListe.get(7), generierteLayoutDisplayQuadrate.get(7));
        assertEquals(testLayoutDisplayListe.get(8), generierteLayoutDisplayQuadrate.get(8));

        assertEquals(testLayoutDisplayListe, generierteLayoutDisplayQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_1x1_Berechnet() {

        Field lDQ1 = new Field(
                new Position(0,0),
                new Position(100,0),
                new Position(100, 100),
                new Position(0, 100),
                1);

        ArrayList<Field> testListe = new ArrayList<>();

        testListe.add(lDQ1);

        List<Field> generierteQuadrate
                = FieldsCalculator.getFields(100, 100, 1, 1);

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_2x1_Berechnet() {

        Field lDQ1 = new Field(
                new Position(0,0),
                new Position(50,0),
                new Position(50, 100),
                new Position(0, 100),
                1);

        Field lDQ2 = new Field(
                new Position(50,0),
                new Position(100,0),
                new Position(100, 100),
                new Position(50, 100),
                2);

        ArrayList<Field> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);

        List<Field> generierteQuadrate
                = FieldsCalculator.getFields(100, 100, 2, 1);

        assertEquals(testListe.get(0), generierteQuadrate.get(0));
        assertEquals(testListe.get(1), generierteQuadrate.get(1));

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_1x3_Berechnet() {

        Field lDQ1 = new Field(
                new Position(0, 0),
                new Position(120, 0),
                new Position(120, 40),
                new Position(0, 40),
                1);

        Field lDQ2 = new Field(
                new Position(0, 40),
                new Position(120, 40),
                new Position(120, 80),
                new Position(0, 80),
                2);

        Field lDQ3 = new Field(
                new Position(0, 80),
                new Position(120, 80),
                new Position(120, 120),
                new Position(0, 120),
                3);

        ArrayList<Field> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);
        testListe.add(lDQ3);

        List<Field> generierteQuadrate
                = FieldsCalculator.getFields(120, 120, 1, 3);

        assertEquals(testListe.get(0), generierteQuadrate.get(0));
        assertEquals(testListe.get(1), generierteQuadrate.get(1));

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_3x1_Berechnet() {

        Field lDQ1 = new Field(
                new Position(0, 0),
                new Position(40, 0),
                new Position(40, 120),
                new Position(0, 120),
                1);

        Field lDQ2 = new Field(
                new Position(40, 0),
                new Position(80, 0),
                new Position(80, 120),
                new Position(40, 120),
                2);

        Field lDQ3 = new Field(
                new Position(80, 0),
                new Position(120, 0),
                new Position(120, 120),
                new Position(80, 120),
                3);

        ArrayList<Field> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);
        testListe.add(lDQ3);

        List<Field> generierteQuadrate
                = FieldsCalculator.getFields(120, 120, 3, 1);

        assertEquals(testListe, generierteQuadrate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void DisplayRechteckeBerechnen_NegativerParameter_Exception() {

        FieldsCalculator.getFields(120, 120, -3, 3);
    }

    @Test
    public void FelderIndexierung_3x1_Berechnet() {

        List<Field> generierteFelder
                = FieldsCalculator.getFields(120, 120, 3, 1);

        for(int i = 1; i < generierteFelder.size(); i++) {

            assertEquals(i, generierteFelder.get(i - 1).getIndex());
        }
    }

    @Test
    public void FelderIndexierung_5x5_Berechnet() {

        List<Field> generierteFelder
                = FieldsCalculator.getFields(120, 120, 5, 5);

        for(int i = 1; i < generierteFelder.size(); i++) {

            assertEquals(i, generierteFelder.get(i - 1).getIndex());
        }
    }

    @Test public void FelderPositionen_2x2_Bestimmt() {

        Position position1_1 = new Position(1, 1);
        Position position2_1 = new Position(2, 1);
        Position position1_2 = new Position(1, 2);
        Position position2_2 = new Position(2, 2);

        List<Field> felder;
        felder = FieldsCalculator.getFields(120, 120, 2, 2);

        assertThat(felder.get(0).getPositionOnPlayingField()).isEqualTo(position1_1);
        assertThat(felder.get(1).getPositionOnPlayingField()).isEqualTo(position2_1);
        assertThat(felder.get(2).getPositionOnPlayingField()).isEqualTo(position1_2);
        assertThat(felder.get(3).getPositionOnPlayingField()).isEqualTo(position2_2);
    }

    @Test public void FelderPositionen_2x3_Bestimmt() {

        Position position1_1 = new Position(1, 1);
        Position position2_1 = new Position(2, 1);
        Position position1_2 = new Position(1, 2);
        Position position2_2 = new Position(2, 2);
        Position position1_3 = new Position(1, 3);
        Position position3_3 = new Position(2, 3);

        List<Field> felder;
        felder = FieldsCalculator.getFields(120, 120, 2, 3);

        assertThat(felder.get(0).getPositionOnPlayingField()).isEqualTo(position1_1);
        assertThat(felder.get(1).getPositionOnPlayingField()).isEqualTo(position2_1);
        assertThat(felder.get(2).getPositionOnPlayingField()).isEqualTo(position1_2);
        assertThat(felder.get(3).getPositionOnPlayingField()).isEqualTo(position2_2);
        assertThat(felder.get(4).getPositionOnPlayingField()).isEqualTo(position1_3);
        assertThat(felder.get(5).getPositionOnPlayingField()).isEqualTo(position3_3);
    }

    @Test public void FelderPositionen_3x3_Bestimmt() {

        Position position1_1 = new Position(1, 1);
        Position position2_1 = new Position(2, 1);
        Position position3_1 = new Position(3, 1);
        Position position1_2 = new Position(1, 2);
        Position position2_2 = new Position(2, 2);
        Position position3_2 = new Position(3, 2);
        Position position1_3 = new Position(1, 3);
        Position position2_3 = new Position(2, 3);
        Position position3_3 = new Position(3, 3);

        List<Field> felder;
        felder = FieldsCalculator.getFields(120, 120, 3, 3);

        assertThat(felder.get(0).getPositionOnPlayingField()).isEqualTo(position1_1);
        assertThat(felder.get(1).getPositionOnPlayingField()).isEqualTo(position2_1);
        assertThat(felder.get(2).getPositionOnPlayingField()).isEqualTo(position3_1);
        assertThat(felder.get(3).getPositionOnPlayingField()).isEqualTo(position1_2);
        assertThat(felder.get(4).getPositionOnPlayingField()).isEqualTo(position2_2);
        assertThat(felder.get(5).getPositionOnPlayingField()).isEqualTo(position3_2);
        assertThat(felder.get(6).getPositionOnPlayingField()).isEqualTo(position1_3);
        assertThat(felder.get(7).getPositionOnPlayingField()).isEqualTo(position2_3);
        assertThat(felder.get(8).getPositionOnPlayingField()).isEqualTo(position3_3);
    }
}
