package shafou.xospiel.SpielfeldTests;

import org.junit.Test;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.SpielfeldInputVerarbeiter;
import shafou.xospiel.Spielfeld.Feld;
import shafou.xospiel.Spielfeld.FeldRechner;
import shafou.xospiel.Spielfeld.XOSpielfeldGenerator;

import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse testet die SpielfeldInputVerarbeiter Klasse.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 05.06.2017 ELF Klasse erstellt.
 */

public class SpielfeldInputVerarbeiterTest {

    @Test
    public void IstInputAufFeld_NichtAufFeld_False() {

        Position inputPosition = new Position(140, 120);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(false, istInputAufFeld);
    }

    @Test
    public void IstInputAufFeld_AufFeld_True() {

        Position inputPosition = new Position(78, 85);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(true, istInputAufFeld);
    }

    @Test()
    public void IstInputAufFeld_Negativ_False() {

        Position inputPosition = new Position(-2, 85);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(false, istInputAufFeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_50_30_Bestimmt() {

        Position inputPosition = new Position(50, 30);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        Feld spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Feld> spielfelder = FeldRechner.spielfelderBerechnen(120, 120, 3, 3);

        assertEquals(spielfelder.get(1), spielfeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_50_100_Bestimmt() {

        Position inputPosition = new Position(50, 100);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        Feld spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Feld> spielfelder = FeldRechner.spielfelderBerechnen(120, 120, 3, 3);

        assertEquals(spielfelder.get(7), spielfeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_80_80_Bestimmt() {

        Position inputPosition = new Position(80, 80);

        XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(120, 120, 3, 3);
        SpielfeldInputVerarbeiter<XOSpielfeldGenerator> sIV = new SpielfeldInputVerarbeiter<>();
        sIV.setSpielfeldGenerator(xOG);
        Feld spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Feld> spielfelder = FeldRechner.spielfelderBerechnen(120, 120, 3, 3);

        assertEquals(spielfelder.get(4), spielfeld);
    }

}
