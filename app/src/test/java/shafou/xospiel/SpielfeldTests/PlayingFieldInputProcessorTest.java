package shafou.xospiel.SpielfeldTests;

import org.junit.Test;

import java.util.ArrayList;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.SpielLogik.PlayingFieldInputProcessor;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.PlayingField.FieldsCalculator;
import shafou.xospiel.PlayingField.XOPlayingFieldGenerator;

import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse testet die PlayingFieldInputProcessor Klasse.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 05.06.2017 ELF Klasse erstellt.
 */

public class PlayingFieldInputProcessorTest {

    @Test
    public void IstInputAufFeld_NichtAufFeld_False() {

        Position inputPosition = new Position(140, 120);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(false, istInputAufFeld);
    }

    @Test
    public void IstInputAufFeld_AufFeld_True() {

        Position inputPosition = new Position(78, 85);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(true, istInputAufFeld);
    }

    @Test()
    public void IstInputAufFeld_Negativ_False() {

        Position inputPosition = new Position(-2, 85);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        boolean istInputAufFeld = sIV.istEingabeAufFeld(inputPosition);

        assertEquals(false, istInputAufFeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_50_30_Bestimmt() {

        Position inputPosition = new Position(50, 30);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        Field spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Field> spielfelder = FieldsCalculator.getFields(120, 120, 3, 3);

        assertEquals(spielfelder.get(1), spielfeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_50_100_Bestimmt() {

        Position inputPosition = new Position(50, 100);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        Field spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Field> spielfelder = FieldsCalculator.getFields(120, 120, 3, 3);

        assertEquals(spielfelder.get(7), spielfeld);
    }

    @Test
    public void BestimmeSpielfeld_Input_80_80_Bestimmt() {

        Position inputPosition = new Position(80, 80);

        XOPlayingFieldGenerator xOG = new XOPlayingFieldGenerator(120, 120, 3);
        PlayingFieldInputProcessor<XOPlayingFieldGenerator> sIV = new PlayingFieldInputProcessor<>();
        sIV.setSpielfeldGenerator(xOG);
        Field spielfeld = sIV.gibSpielfeld(inputPosition);

        ArrayList<Field> spielfelder = FieldsCalculator.getFields(120, 120, 3, 3);

        assertEquals(spielfelder.get(4), spielfeld);
    }

}
