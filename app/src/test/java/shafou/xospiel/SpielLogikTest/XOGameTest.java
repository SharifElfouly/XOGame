package shafou.xospiel.SpielLogikTest;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


import shafou.xospiel.Activities.GameMenuActivity;
import shafou.xospiel.BuildConfig;
import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.Token;
import shafou.xospiel.PlayingField.XToken;
import shafou.xospiel.SpielLogik.Turn;
import shafou.xospiel.SpielLogik.XOGame;
import shafou.xospiel.PlayingField.OToken;

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
public class XOGameTest {

    Activity activity;

    XOGame xOGame;

    @Test public void GibLetztenZug_XSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(GameMenuActivity.class);

        xOGame = XOGame.getInstance(activity, 3);
        xOGame = XOGame.neuStarten(activity, 3);

        Token tokenX = new XToken(activity);
        Token tokenO = new OToken(activity);

        Field mockedField = mock(Field.class);

        Turn turn1 = new Turn(tokenX, mockedField);
        Turn turn2 = new Turn(tokenO, mockedField);

        XOGame.zugGespielt(turn1);
        XOGame.zugGespielt(turn2);

        Turn lastTurn = XOGame.gibLetztenZug();
        assertThat(turn2).isEqualTo(lastTurn);
    }

    @Test public void GibLetztenZug_OSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(GameMenuActivity.class);

        xOGame = XOGame.getInstance(activity, 3);
        xOGame = XOGame.neuStarten(activity, 3);

        Token tokenX1 = new XToken(activity);
        Token tokenO1 = new OToken(activity);
        Token tokenX2 = new XToken(activity);

        Field mockedField = mock(Field.class);

        Turn turn1 = new Turn(tokenX1, mockedField);
        Turn turn2 = new Turn(tokenO1, mockedField);
        Turn turn3 = new Turn(tokenX2, mockedField);

        XOGame.zugGespielt(turn1);
        XOGame.zugGespielt(turn2);
        XOGame.zugGespielt(turn3);

        Turn lastTurn = XOGame.gibLetztenZug();
        assertThat(turn3).isEqualTo(lastTurn);
    }

    @Test public void GibAktuellenSpielstein_OSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(GameMenuActivity.class);

        xOGame = XOGame.getInstance(activity, 3);
        xOGame = XOGame.neuStarten(activity, 3);

        Token tokenX1 = new XToken(activity);
        Token tokenO1 = new OToken(activity);
        Token tokenX2 = new XToken(activity);

        Field mockedField = mock(Field.class);

        Turn turn1 = new Turn(tokenX1, mockedField);
        Turn turn2 = new Turn(tokenO1, mockedField);
        Turn turn3 = new Turn(tokenX2, mockedField);

        XOGame.zugGespielt(turn1);
        XOGame.zugGespielt(turn2);
        XOGame.zugGespielt(turn3);

        Token aktuellerToken = new OToken(activity);
        assertThat(new OToken(activity)).isEqualTo(aktuellerToken);
    }

    @Test public void GibAktuellenSpielstein_XSpielstein_Bestimmt() {

        activity = Robolectric.setupActivity(GameMenuActivity.class);

        xOGame = XOGame.getInstance(activity, 3);
        xOGame = XOGame.neuStarten(activity, 3);

        Token tokenX1 = new XToken(activity);
        Token tokenO1 = new OToken(activity);
        Token tokenX2 = new XToken(activity);
        Token tokenO2 = new OToken(activity);

        Field mockedField = mock(Field.class);

        Turn turn1 = new Turn(tokenX1, mockedField);
        Turn turn2 = new Turn(tokenO1, mockedField);
        Turn turn3 = new Turn(tokenX2, mockedField);
        Turn turn4 = new Turn(tokenO2, mockedField);

        XOGame.zugGespielt(turn1);
        XOGame.zugGespielt(turn2);
        XOGame.zugGespielt(turn3);
        XOGame.zugGespielt(turn4);

        Token aktuellerToken = new XToken(activity);
        assertThat(new XToken(activity)).isEqualTo(aktuellerToken);
    }

    @Test public void GeneriereGewinnMoeglichkeiten_Spielart3_1_Generiert() {

        int[] expectedGewinnMoeglichkeit = new int[1];
        expectedGewinnMoeglichkeit[0] = 3;

        XOGame.Mode mode3 = XOGame.Mode.DREI;

        int[] actualGewinnMoeglichkeit = mode3.berechneAnzahlSteineZumGewinn();

        assertThat(actualGewinnMoeglichkeit[0]).isSameAs(expectedGewinnMoeglichkeit[0]);
    }

    @Test public void GeneriereGewinnMoeglichkeiten_Spielart4_2_Generiert() {

        int[] expectedGewinnMoeglichkeit = new int[2];
        expectedGewinnMoeglichkeit[0] = 3;
        expectedGewinnMoeglichkeit[1] = 4;

        XOGame.Mode mode4 = XOGame.Mode.VIER;

        int[] actualGewinnMoeglichkeit = mode4.berechneAnzahlSteineZumGewinn();

        assertThat(actualGewinnMoeglichkeit[0]).isSameAs(expectedGewinnMoeglichkeit[0]);
        assertThat(actualGewinnMoeglichkeit[1]).isSameAs(expectedGewinnMoeglichkeit[1]);
    }

    @Test public void GeneriereGewinnMoeglichkeiten_Spielart5_3_Generiert() {

        int[] expectedGewinnMoeglichkeit = new int[3];
        expectedGewinnMoeglichkeit[0] = 3;
        expectedGewinnMoeglichkeit[1] = 4;
        expectedGewinnMoeglichkeit[2] = 5;

        XOGame.Mode mode5 = XOGame.Mode.FUENF;

        int[] actualGewinnMoeglichkeit = mode5.berechneAnzahlSteineZumGewinn();

        assertThat(actualGewinnMoeglichkeit[0]).isSameAs(expectedGewinnMoeglichkeit[0]);
        assertThat(actualGewinnMoeglichkeit[1]).isSameAs(expectedGewinnMoeglichkeit[1]);
        assertThat(actualGewinnMoeglichkeit[2]).isSameAs(expectedGewinnMoeglichkeit[2]);
    }
}
