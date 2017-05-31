package shafou.xospiel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.Spielstein;
import shafou.xospiel.SpielLogik.XSpielstein;

import static org.junit.Assert.*;

/**
 *
 * Diese Klasse beinhaltet alle Tests des Spielsteins
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 25.05.2017 ELF Klasse erstellt.
 */

@RunWith(AndroidJUnit4.class)
public class SpielsteinTest {

    private Context appContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void spielsteinGleichheitsTest() {

        boolean istGleich;

        Spielstein spielstein1 = new XSpielstein(appContext, new Position(1,1));
        Spielstein spielstein2 = new XSpielstein(appContext, new Position(1,1));

        istGleich = (spielstein1.equals(spielstein2));

        assertEquals(true, istGleich);
    }
}
