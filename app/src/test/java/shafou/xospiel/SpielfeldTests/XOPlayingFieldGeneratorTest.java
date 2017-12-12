package shafou.xospiel.SpielfeldTests;

import org.junit.Test;

import java.util.ArrayList;

import shafou.xospiel.PlayingField.Line;
import shafou.xospiel.GameLogic.Position;
import shafou.xospiel.PlayingField.XOPlayingFieldGenerator;

import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse testet die Funktionalität des Spielfeldgenerators.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 01.06.2017 ELF Klasse erstellt.
 */

public class XOPlayingFieldGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void SpielfeldGeneratorInitialisierung_NegativerParameter_Exception() {

        new XOPlayingFieldGenerator(-100, 0, 3);
    }

    @Test
    public void XOFeldlinienBerechnen_3x3_Berechnet(){

        Line line1 = new Line(new Position(40, 0), new Position(40, 120));
        Line line2 = new Line(new Position(80, 0), new Position(80, 120));
        Line line3 = new Line(new Position(0, 40), new Position(120, 40));
        Line line4 = new Line(new Position(0, 80), new Position(120, 80));

        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(120, 120, 3);

        ArrayList<Line> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(line1);
        xOFeldLinienTest.add(line2);
        xOFeldLinienTest.add(line3);
        xOFeldLinienTest.add(line4);

        ArrayList<Line> xOFeldLinienGeneriert = sG.calculatesLines();

        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test
    public void XOFeldlinienBerechnen_4x4_Berechnet(){

        Line line1 = new Line(new Position(25, 0), new Position(25, 100));
        Line line2 = new Line(new Position(50, 0), new Position(50, 100));
        Line line3 = new Line(new Position(75, 0), new Position(75, 100));
        Line line4 = new Line(new Position(0, 25), new Position(100, 25));
        Line line5 = new Line(new Position(0, 50), new Position(100, 50));
        Line line6 = new Line(new Position(0, 75), new Position(100, 75));

        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(100, 100, 4);

        ArrayList<Line> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(line1);
        xOFeldLinienTest.add(line2);
        xOFeldLinienTest.add(line3);
        xOFeldLinienTest.add(line4);
        xOFeldLinienTest.add(line5);
        xOFeldLinienTest.add(line6);

        ArrayList<Line> xOFeldLinienGeneriert = sG.calculatesLines();

        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void XOFeldlinienBerechnen_2x3_Exception(){
//
//        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(120, 120, 2, 3);
//        sG.calculatesLines();
//    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_NegativerParameter_Exception() {

        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(100, 100, 3);
        sG.calculatesLines(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_0_Parameter_Exception() {

        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(100, 100, 3);
        sG.calculatesLines(0);
    }

    @Test
    public void ProzentVonLinieAbziehen_10_Prozent_Berechnet() {

        XOPlayingFieldGenerator sG = new XOPlayingFieldGenerator(120, 120, 3);

        Line line1 = new Line(new Position(40, 12), new Position(40, 108));
        Line line2 = new Line(new Position(80, 12), new Position(80, 108));
        Line line3 = new Line(new Position(12, 40), new Position(108, 40));
        Line line4 = new Line(new Position(12, 80), new Position(108, 80));

        ArrayList<Line> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(line1);
        xOFeldLinienTest.add(line2);
        xOFeldLinienTest.add(line3);
        xOFeldLinienTest.add(line4);

        ArrayList<Line> xOFeldLinienGeneriert = sG.calculatesLines(10);
        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_ProzentParameter_Exception() {

        XOPlayingFieldGenerator.calculatePercentage(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_BetragParameter_Exception() {

        XOPlayingFieldGenerator.calculatePercentage(0, 100);
    }

    @Test
    public void ProzentBerechnen_10ProzentVon100_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(100, 10);

        assertEquals(10, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_45ProzentVon322_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(322, 45);

        assertEquals(144.9, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_3ProzentVon10_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(10, 3);

        assertEquals(0.3, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_22ProzentVon100_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(100, 22);

        assertEquals(22, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_200ProzentVon100_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(100, 200);
        assertEquals(200, berechneterBetrag, 0.1);
    }

    @Test
    public void ProzentBerechnen_222ProzentVon33_Berechnet() {

        double berechneterBetrag = XOPlayingFieldGenerator.calculatePercentage(33, 222);
        assertEquals(73.26, berechneterBetrag, 0.1);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void XOSpielfeldGeneratorInitialisieren_UngleicheSpaltenReihen_Exception() {
//
//        new XOPlayingFieldGenerator(120, 120, 3, 4);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void XOSpielfeldGeneratorInitialisieren_SpaltenReihenKleiner3_Exception() {

        new XOPlayingFieldGenerator(120, 120, 2);
    }
}
