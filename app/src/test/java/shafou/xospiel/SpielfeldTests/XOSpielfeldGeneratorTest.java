package shafou.xospiel.SpielfeldTests;

import org.junit.Test;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.Spielfeld.Linie;
import shafou.xospiel.Spielfeld.XOSpielfeldGenerator;

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

public class XOSpielfeldGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void SpielfeldGeneratorInitialisierung_NegativerParameter_Exception() {

        new XOSpielfeldGenerator(-100, 0, 3, 3);
    }

    @Test
    public void XOFeldlinienBerechnen_3x3_Berechnet(){

        Linie linie1 = new Linie(new Position(40, 0), new Position(40, 120));
        Linie linie2 = new Linie(new Position(80, 0), new Position(80, 120));
        Linie linie3 = new Linie(new Position(0, 40), new Position(120, 40));
        Linie linie4 = new Linie(new Position(0, 80), new Position(120, 80));

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(120, 120, 3, 3);

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.feldlinienBerechnen();

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

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(100, 100, 4, 4);

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);
        xOFeldLinienTest.add(linie5);
        xOFeldLinienTest.add(linie6);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.feldlinienBerechnen();

        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test(expected = IllegalArgumentException.class)
    public void XOFeldlinienBerechnen_2x3_Exception(){

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(120, 120, 2, 3);
        sG.feldlinienBerechnen();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_NegativerParameter_Exception() {

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(100, 100, 3, 3);
        sG.feldLinienBerechnen(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentVonLinieAbziehen_0_Parameter_Exception() {

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(100, 100, 3, 3);
        sG.feldLinienBerechnen(0);
    }

    @Test
    public void ProzentVonLinieAbziehen_10_Prozent_Berechnet() {

        XOSpielfeldGenerator sG = new XOSpielfeldGenerator(120, 120, 3, 3);

        Linie linie1 = new Linie(new Position(40, 12), new Position(40, 108));
        Linie linie2 = new Linie(new Position(80, 12), new Position(80, 108));
        Linie linie3 = new Linie(new Position(12, 40), new Position(108, 40));
        Linie linie4 = new Linie(new Position(12, 80), new Position(108, 80));

        ArrayList<Linie> xOFeldLinienTest = new ArrayList<>();
        xOFeldLinienTest.add(linie1);
        xOFeldLinienTest.add(linie2);
        xOFeldLinienTest.add(linie3);
        xOFeldLinienTest.add(linie4);

        ArrayList<Linie> xOFeldLinienGeneriert = sG.feldLinienBerechnen(10);
        assertEquals(xOFeldLinienTest, xOFeldLinienGeneriert);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_ProzentParameter_Exception() {

        XOSpielfeldGenerator.prozentBerechnen(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ProzentBerechnen_0_BetragParameter_Exception() {

        XOSpielfeldGenerator.prozentBerechnen(0, 100);
    }

    @Test
    public void ProzentBerechnen_10ProzentVon100_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(100, 10);

        assertEquals(10, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_45ProzentVon322_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(322, 45);

        assertEquals(144.9, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_3ProzentVon10_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(10, 3);

        assertEquals(0.3, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_22ProzentVon100_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(100, 22);

        assertEquals(22, berechneterBetrag, 0.0);
    }

    @Test
    public void ProzentBerechnen_200ProzentVon100_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(100, 200);
        assertEquals(200, berechneterBetrag, 0.1);
    }

    @Test
    public void ProzentBerechnen_222ProzentVon33_Berechnet() {

        double berechneterBetrag = XOSpielfeldGenerator.prozentBerechnen(33, 222);
        assertEquals(73.26, berechneterBetrag, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void XOSpielfeldGeneratorInitialisieren_UngleicheSpaltenReihen_Exception() {

        new XOSpielfeldGenerator(120, 120, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void XOSpielfeldGeneratorInitialisieren_SpaltenReihenKleiner3_Exception() {

        new XOSpielfeldGenerator(120, 120, 2, 4);
    }
}
