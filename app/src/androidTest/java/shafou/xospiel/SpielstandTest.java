package shafou.xospiel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import shafou.xospiel.SpielLogik.FeldIstBesetztException;
import shafou.xospiel.SpielLogik.OSpielstein;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.Spielstand;
import shafou.xospiel.SpielLogik.Status;
import shafou.xospiel.SpielLogik.XSpielstein;
import shafou.xospiel.SpielLogik.Zug;

import static org.junit.Assert.assertEquals;

/**
 *
 * Diese Klasse enthält Tests zum Spielstand und dessen Auswertung.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 25.05.2017 ELF Klasse erstellt.
 */

@RunWith(AndroidJUnit4.class)
public class SpielstandTest {

    private Context appContext = InstrumentationRegistry.getTargetContext();

    @Before
    public void initialize() {

        Spielstand.starteSpiel();
    }

    @Test
    public void spielStartTest() {

        Spielstand.starteSpielNeu();

        assertEquals(0, Spielstand.getZugNummerGesamt());
    }

    @Test
    public void zugGespieltTest() {

        Spielstand.starteSpielNeu();

        assertEquals(0, Spielstand.getZugNummerGesamt());

        Zug zug1 = new Zug(new OSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug1);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(1, Spielstand.getZugNummerGesamt());

        Zug zug2 = new Zug(new OSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug2);
        } catch (FeldIstBesetztException e) {

            assertEquals(Spielstand.FELD_IST_BESETZT_TEXT, e.getMessage());
        }

        assertEquals(1, Spielstand.getZugNummerGesamt());
    }

    @Test
    public void istFeldBesetztTest() {

        Spielstand.starteSpielNeu();

        Zug zug1 = new Zug(new OSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug1);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(true,
                Spielstand.istFeldBesetzt(new Position(1, 1)));

        assertEquals(false,
                Spielstand.istFeldBesetzt(new Position(2, 1)));

        assertEquals(false,
                Spielstand.istFeldBesetzt(new Position(1, 3)));

        Zug zug2 = new Zug(new XSpielstein(appContext, new Position(2, 1)));

        try {
            Spielstand.zugGespielt(zug2);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(true,
                Spielstand.istFeldBesetzt(new Position(2, 1)));

        assertEquals(false,
                Spielstand.istFeldBesetzt(new Position(2, 2)));

        Zug zug3 = new Zug(new XSpielstein(appContext, new Position(2, 2)));

        try {
            Spielstand.zugGespielt(zug3);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(true,
                Spielstand.istFeldBesetzt(new Position(2, 2)));

        Spielstand.starteSpielNeu();

        assertEquals(false,
                Spielstand.istFeldBesetzt(new Position(2, 2)));
    }

    @Test
    public void spielAnalyseTest1() {

        Spielstand.starteSpielNeu();

        Zug zug1 = new Zug(new OSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug1);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug2 = new Zug(new XSpielstein(appContext, new Position(1, 2)));

        try {
            Spielstand.zugGespielt(zug2);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug3 = new Zug(new OSpielstein(appContext, new Position(2, 2)));

        try {
            Spielstand.zugGespielt(zug3);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug4 = new Zug(new XSpielstein(appContext, new Position(2, 1)));

        try {
            Spielstand.zugGespielt(zug4);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(false, zug4)
                , Spielstand.analyseSpiel());

        Zug zug5 = new Zug(new OSpielstein(appContext, new Position(3, 3)));

        try {
            Spielstand.zugGespielt(zug5);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(true, zug5)
                , Spielstand.analyseSpiel());
    }

    @Test
    public void spielAnalyseTest2() {

        Spielstand.starteSpielNeu();

        Zug zug1 = new Zug(new XSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug1);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug2 = new Zug(new OSpielstein(appContext, new Position(1, 2)));

        try {
            Spielstand.zugGespielt(zug2);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug3 = new Zug(new XSpielstein(appContext, new Position(2, 2)));

        try {
            Spielstand.zugGespielt(zug3);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug4 = new Zug(new OSpielstein(appContext, new Position(2, 1)));

        try {
            Spielstand.zugGespielt(zug4);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(false, zug4)
                , Spielstand.analyseSpiel());

        Zug zug5 = new Zug(new XSpielstein(appContext, new Position(3, 3)));

        try {
            Spielstand.zugGespielt(zug5);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(true, zug5)
                , Spielstand.analyseSpiel());
    }

    @Test
    public void spielAnalyseTest3() {

        Spielstand.starteSpielNeu();

        Zug zug1 = new Zug(new OSpielstein(appContext, new Position(1, 1)));

        try {
            Spielstand.zugGespielt(zug1);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug2 = new Zug(new XSpielstein(appContext, new Position(1, 2)));

        try {
            Spielstand.zugGespielt(zug2);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug3 = new Zug(new OSpielstein(appContext, new Position(1, 3)));

        try {
            Spielstand.zugGespielt(zug3);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug4 = new Zug(new XSpielstein(appContext, new Position(2, 1)));

        try {
            Spielstand.zugGespielt(zug4);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(false, zug4)
                , Spielstand.analyseSpiel());

        Zug zug5 = new Zug(new OSpielstein(appContext, new Position(2, 2)));

        try {
            Spielstand.zugGespielt(zug5);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(false, zug5)
                , Spielstand.analyseSpiel());

        Zug zug6 = new Zug(new XSpielstein(appContext, new Position(2, 3)));

        try {
            Spielstand.zugGespielt(zug6);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug7 = new Zug(new OSpielstein(appContext, new Position(3, 1)));

        try {
            Spielstand.zugGespielt(zug7);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        Zug zug8 = new Zug(new XSpielstein(appContext, new Position(3, 2)));

        try {
            Spielstand.zugGespielt(zug8);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(false, zug8)
                , Spielstand.analyseSpiel());

        Zug zug9 = new Zug(new OSpielstein(appContext, new Position(3, 3)));

        try {
            Spielstand.zugGespielt(zug9);
        } catch (FeldIstBesetztException e) {
            e.printStackTrace();
        }

        assertEquals(new Status(true, zug9)
                , Spielstand.analyseSpiel());
    }
}
