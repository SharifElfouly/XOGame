package shafou.xospiel.SpielLogikTest;

import android.app.Activity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


import shafou.xospiel.Aktivitaeten.SpielActivity;
import shafou.xospiel.BuildConfig;
import shafou.xospiel.SpielLogik.XOSpiel;
import shafou.xospiel.SpielLogik.Zug;
import shafou.xospiel.Spielfeld.Feld;
import shafou.xospiel.Spielfeld.OSpielstein;
import shafou.xospiel.Spielfeld.Spielstein;
import shafou.xospiel.Spielfeld.XSpielstein;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

/**
 *
 * Diese Klasse testet die Methoden der X/O Spiel Klasse.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 11.06.2017 ELF Klasse erstellt.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class XOSpielTest {

    Activity activity;

    XOSpiel xOSpiel;

    @Test public void GibLetztenZug_XSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(SpielActivity.class);

        xOSpiel = XOSpiel.neuStarten(activity, 3, 3);

        Spielstein spielsteinX = new XSpielstein(activity);
        Spielstein spielsteinO = new OSpielstein(activity);

        Feld mockedFeld = mock(Feld.class);

        Zug zug1 = new Zug(spielsteinX, mockedFeld);
        Zug zug2 = new Zug(spielsteinO, mockedFeld);

        XOSpiel.zugGespielt(zug1);
        XOSpiel.zugGespielt(zug2);

        Zug letzterZug = XOSpiel.gibLetztenZug();
        assertThat(zug2).isEqualTo(letzterZug);
    }

    @Test public void GibLetztenZug_OSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(SpielActivity.class);

        xOSpiel = XOSpiel.neuStarten(activity, 3, 3);

        Spielstein spielsteinX1 = new XSpielstein(activity);
        Spielstein spielsteinO1 = new OSpielstein(activity);
        Spielstein spielsteinX2 = new XSpielstein(activity);

        Feld mockedFeld = mock(Feld.class);

        Zug zug1 = new Zug(spielsteinX1, mockedFeld);
        Zug zug2 = new Zug(spielsteinO1, mockedFeld);
        Zug zug3 = new Zug(spielsteinX2, mockedFeld);

        XOSpiel.zugGespielt(zug1);
        XOSpiel.zugGespielt(zug2);
        XOSpiel.zugGespielt(zug3);

        Zug letzterZug = XOSpiel.gibLetztenZug();
        assertThat(zug3).isEqualTo(letzterZug);
    }

    @Test public void GibAktuellenSpielstein_OSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(SpielActivity.class);

        xOSpiel = XOSpiel.neuStarten(activity, 3, 3);

        Spielstein spielsteinX1 = new XSpielstein(activity);
        Spielstein spielsteinO1 = new OSpielstein(activity);
        Spielstein spielsteinX2 = new XSpielstein(activity);

        Feld mockedFeld = mock(Feld.class);

        Zug zug1 = new Zug(spielsteinX1, mockedFeld);
        Zug zug2 = new Zug(spielsteinO1, mockedFeld);
        Zug zug3 = new Zug(spielsteinX2, mockedFeld);

        XOSpiel.zugGespielt(zug1);
        XOSpiel.zugGespielt(zug2);
        XOSpiel.zugGespielt(zug3);

        Spielstein aktuellerSpielstein = new OSpielstein(activity);
        assertThat(new OSpielstein(activity)).isEqualTo(aktuellerSpielstein);
    }

    @Test public void GibAktuellenSpielstein_XSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(SpielActivity.class);

        xOSpiel = XOSpiel.neuStarten(activity, 3, 3);

        Spielstein spielsteinX1 = new XSpielstein(activity);
        Spielstein spielsteinO1 = new OSpielstein(activity);
        Spielstein spielsteinX2 = new XSpielstein(activity);
        Spielstein spielsteinO2 = new OSpielstein(activity);

        Feld mockedFeld = mock(Feld.class);

        Zug zug1 = new Zug(spielsteinX1, mockedFeld);
        Zug zug2 = new Zug(spielsteinO1, mockedFeld);
        Zug zug3 = new Zug(spielsteinX2, mockedFeld);
        Zug zug4 = new Zug(spielsteinO2, mockedFeld);

        XOSpiel.zugGespielt(zug1);
        XOSpiel.zugGespielt(zug2);
        XOSpiel.zugGespielt(zug3);
        XOSpiel.zugGespielt(zug4);

        Spielstein aktuellerSpielstein = new XSpielstein(activity);
        assertThat(new XSpielstein(activity)).isEqualTo(aktuellerSpielstein);
    }

    @Test public void GibXSteine_3Spielsteine_Bestimmt() {

        // TODO
    }
}
