package shafou.xospiel;

import org.junit.Test;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;

import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse testet die Funktionalität des Spielfeldgenerators.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 01.06.2017 ELF Klasse erstellt.
 */

public class SpielfeldGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void SpielfeldGeneratorInitialisierung_NegativerParameter_Exception() {

        new SpielfeldGenerator(-100, 0);
    }

    @Test
    public void PositionenBerechnen_3x3_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        ArrayList<Position> generiertePositionen = sG.positionenBerechnen(3, 3);

        ArrayList<Position> testPositionen = new ArrayList<>();
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

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        ArrayList<Position> generiertePositionen = sG.positionenBerechnen(1, 1);

        ArrayList<Position> testPositionen = new ArrayList<>();
        testPositionen.add(new Position(0, 0));
        testPositionen.add(new Position(120, 0));
        testPositionen.add(new Position(0, 120));
        testPositionen.add(new Position(120, 120));

        assertEquals(testPositionen, generiertePositionen);
    }

    @Test
    public void PositionenBerechnen_1x2_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        ArrayList<Position> generiertePositionen = sG.positionenBerechnen(1, 2);

        ArrayList<Position> testPositionen = new ArrayList<>();
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

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        ArrayList<Position> generiertePositionen = sG.positionenBerechnen(2, 1);

        ArrayList<Position> testPositionen = new ArrayList<>();
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

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);
        sG.positionenBerechnen(-3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PositionenBerechnen_0_Parameter_Exception() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);
        sG.positionenBerechnen(1, 0);
    }

    @Test
    public void DisplayRechteckeBerechnen_3x3_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0,0),
                new Position(40,0),
                new Position(40,40),
                new Position(0,40)
        );

        DisplayRechtecke lDQ2 = new DisplayRechtecke(
                new Position(40,0),
                new Position(80,0),
                new Position(80,40),
                new Position(40,40)
        );

        DisplayRechtecke lDQ3 = new DisplayRechtecke(
                new Position(80,0),
                new Position(120,0),
                new Position(120,40),
                new Position(80,40)
        );

        DisplayRechtecke lDQ4 = new DisplayRechtecke(
                new Position(0,40),
                new Position(40,40),
                new Position(40,80),
                new Position(0,80)
        );

        DisplayRechtecke lDQ5 = new DisplayRechtecke(
                new Position(40,40),
                new Position(80,40),
                new Position(80,80),
                new Position(40,80)
        );

        DisplayRechtecke lDQ6 = new DisplayRechtecke(
                new Position(80,40),
                new Position(120,40),
                new Position(120,80),
                new Position(80,80)
        );

        DisplayRechtecke lDQ7 = new DisplayRechtecke(
                new Position(0,80),
                new Position(40,80),
                new Position(40,120),
                new Position(0,120)
        );

        DisplayRechtecke lDQ8 = new DisplayRechtecke(
                new Position(40,80),
                new Position(80,80),
                new Position(80,120),
                new Position(40,120)
        );

        DisplayRechtecke lDQ9 = new DisplayRechtecke(
                new Position(80,80),
                new Position(120,80),
                new Position(120,120),
                new Position(80,120)
        );

        ArrayList<DisplayRechtecke> generierteLayoutDisplayQuadrate
                = sG.displayRechteckeBerechnen(3, 3);

        ArrayList<DisplayRechtecke> testLayoutDisplayListe = new ArrayList<>();

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

        SpielfeldGenerator sG = new SpielfeldGenerator(X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0,0),
                new Position(1f/3f * X_LAYOUT_GROESSE, 0),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(0, 1f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ2 = new DisplayRechtecke(
                new Position(1f/3f * X_LAYOUT_GROESSE, 0),
                new Position(2f/3f * X_LAYOUT_GROESSE, 0),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ3 = new DisplayRechtecke(
                new Position(2f/3f * X_LAYOUT_GROESSE, 0),
                new Position(X_LAYOUT_GROESSE, 0),
                new Position(X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ4 = new DisplayRechtecke(
                new Position(0, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(0, 2f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ5 = new DisplayRechtecke(
                new Position(1f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ6 = new DisplayRechtecke(
                new Position(2f/3f * X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 1f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ7 = new DisplayRechtecke(
                new Position(0, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(0, Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ8 = new DisplayRechtecke(
                new Position(1f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(1f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE)
        );

        DisplayRechtecke lDQ9 = new DisplayRechtecke(
                new Position(2f/3f * X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, 2f/3f * Y_LAYOUT_GROESSE),
                new Position(X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE),
                new Position(2f/3f * X_LAYOUT_GROESSE, Y_LAYOUT_GROESSE)
        );

        ArrayList<DisplayRechtecke> generierteLayoutDisplayQuadrate
                = sG.displayRechteckeBerechnen(3, 3);

        ArrayList<DisplayRechtecke> testLayoutDisplayListe = new ArrayList<>();

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

        SpielfeldGenerator sG = new SpielfeldGenerator(100, 100);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0,0),
                new Position(100,0),
                new Position(100, 100),
                new Position(0, 100)
        );

        ArrayList<DisplayRechtecke> testListe = new ArrayList<>();

        testListe.add(lDQ1);

        ArrayList<DisplayRechtecke> generierteQuadrate
                = sG.displayRechteckeBerechnen(1, 1);

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_2x1_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(100, 100);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0,0),
                new Position(50,0),
                new Position(50, 100),
                new Position(0, 100)
        );

        DisplayRechtecke lDQ2 = new DisplayRechtecke(
                new Position(50,0),
                new Position(100,0),
                new Position(100, 100),
                new Position(50, 100)
        );

        ArrayList<DisplayRechtecke> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);

        ArrayList<DisplayRechtecke> generierteQuadrate
                = sG.displayRechteckeBerechnen(2, 1);

        assertEquals(testListe.get(0), generierteQuadrate.get(0));
        assertEquals(testListe.get(1), generierteQuadrate.get(1));

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_1x3_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0, 0),
                new Position(120, 0),
                new Position(120, 40),
                new Position(0, 40)
        );

        DisplayRechtecke lDQ2 = new DisplayRechtecke(
                new Position(0, 40),
                new Position(120, 40),
                new Position(120, 80),
                new Position(0, 80)
        );

        DisplayRechtecke lDQ3 = new DisplayRechtecke(
                new Position(0, 80),
                new Position(120, 80),
                new Position(120, 120),
                new Position(0, 120)
        );

        ArrayList<DisplayRechtecke> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);
        testListe.add(lDQ3);

        ArrayList<DisplayRechtecke> generierteQuadrate
                = sG.displayRechteckeBerechnen(1, 3);

        assertEquals(testListe.get(0), generierteQuadrate.get(0));
        assertEquals(testListe.get(1), generierteQuadrate.get(1));

        assertEquals(testListe, generierteQuadrate);
    }

    @Test
    public void DisplayRechteckeBerechnen_3x1_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        DisplayRechtecke lDQ1 = new DisplayRechtecke(
                new Position(0, 0),
                new Position(40, 0),
                new Position(40, 120),
                new Position(0, 120)
        );

        DisplayRechtecke lDQ2 = new DisplayRechtecke(
                new Position(40, 0),
                new Position(80, 0),
                new Position(80, 120),
                new Position(40, 120)
        );

        DisplayRechtecke lDQ3 = new DisplayRechtecke(
                new Position(80, 0),
                new Position(120, 0),
                new Position(120, 120),
                new Position(80, 120)
        );

        ArrayList<DisplayRechtecke> testListe = new ArrayList<>();

        testListe.add(lDQ1);
        testListe.add(lDQ2);
        testListe.add(lDQ3);

        ArrayList<DisplayRechtecke> generierteQuadrate
                = sG.displayRechteckeBerechnen(3, 1);

        assertEquals(testListe, generierteQuadrate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void DisplayRechteckeBerechnen_NegativerParameter_Exception() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        sG.displayRechteckeBerechnen(-3, 3);
    }

    @Test
    public void XOFeldlinienBerechnen_3x3_Berechnet(){

        Linie linie1 = new Linie(new Position(40, 0), new Position(40, 120));
        Linie linie2 = new Linie(new Position(80, 0), new Position(80, 120));
        Linie linie3 = new Linie(new Position(0, 40), new Position(120, 40));
        Linie linie4 = new Linie(new Position(0, 80), new Position(120, 80));

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.xOFeldlinienBerechnen(3, 3);

        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test
    public void XOFeldlinienBerechnen_4x4_Berechnet(){

        Linie linie1 = new Linie(new Position(25, 0), new Position(25, 100));
        Linie linie2 = new Linie(new Position(50, 0), new Position(50, 100));
        Linie linie3 = new Linie(new Position(75, 0), new Position(75, 100));
        Linie linie4 = new Linie(new Position(0, 25), new Position(100, 25));
        Linie linie5 = new Linie(new Position(0, 50), new Position(100, 50));
        Linie linie6 = new Linie(new Position(0, 75), new Position(100, 75));

        SpielfeldGenerator sG = new SpielfeldGenerator(100, 100);

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);
        xOFeldLinienTest.add(linie5);
        xOFeldLinienTest.add(linie6);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.xOFeldlinienBerechnen(4, 4);

        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test(expected = IllegalArgumentException.class)
    public void XOFeldlinienBerechnen_2x3_Exception(){

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);
        sG.xOFeldlinienBerechnen(2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_NegativerParameter_Exception() {

        SpielfeldGenerator sG = new SpielfeldGenerator(100, 100);
        sG.xOFeldLinienBerechnen(3, 3, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_0_Parameter_Exception() {

        SpielfeldGenerator sG = new SpielfeldGenerator(100, 100);
        sG.xOFeldLinienBerechnen(0, 3, 3);
    }

    @Test
    public void ProzentVonLinieAbziehen_10_Prozent_Berechnet() {

        SpielfeldGenerator sG = new SpielfeldGenerator(120, 120);

        Linie linie1 = new Linie(new Position(40, 12), new Position(40, 108));
        Linie linie2 = new Linie(new Position(80, 12), new Position(80, 108));
        Linie linie3 = new Linie(new Position(12, 40), new Position(108, 40));
        Linie linie4 = new Linie(new Position(12, 80), new Position(108, 80));

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.xOFeldLinienBerechnen(3, 3, 10);
        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_ProzentParameter_Exception() {

        SpielfeldGenerator.prozentBerechnen(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_BetragParameter_Exception() {

        SpielfeldGenerator.prozentBerechnen(0, 100);
    }

    @Test
    public void ProzentBerechnen_10ProzentVon100_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(100, 10);

        assertEquals(10, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_45ProzentVon322_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(322, 45);

        assertEquals(144.9, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_3ProzentVon10_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(10, 3);

        assertEquals(0.3, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_22ProzentVon100_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(100, 22);

        assertEquals(22, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_200ProzentVon100_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(100, 200);
        assertEquals(200, berechneterBetrag, 0.1);
    }

    @Test
    public void ProzentBerechnen_222ProzentVon33_Berechnet() {

        double berechneterBetrag = SpielfeldGenerator.prozentBerechnen(33, 222);
        assertEquals(73.26, berechneterBetrag, 0.1);
    }
}
