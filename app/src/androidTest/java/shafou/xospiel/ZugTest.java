package shafou.xospiel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import shafou.xospiel.SpielLogik.OSpielstein;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.Zug;

import static org.junit.Assert.*;

/**
 *
 * Diese Klasse enthält Tests zum Zug
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 25.05.2017 ELF Klasse erstellt.
 */

@RunWith(AndroidJUnit4.class)
public class ZugTest {

    private Context appContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void zugGleichheitsTest() {

        boolean istGleich;

        Zug zug1 = new Zug(new OSpielstein(appContext, new Position(1,1)));
        Zug zug2 = new Zug(new OSpielstein(appContext, new Position(1,1)));

        istGleich = zug1.equals(zug2);

        assertEquals(true, istGleich);
    }

}
