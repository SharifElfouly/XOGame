package shafou.xospiel.SpielfeldTests;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import shafou.xospiel.Aktivitaeten.SpielActivity;
import shafou.xospiel.BuildConfig;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.Spielfeld.OSpielstein;
import shafou.xospiel.Spielfeld.Spielstein;
import shafou.xospiel.Spielfeld.XSpielstein;
import shafou.xospiel.Spielfeld.Feld;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Diese Klasse testet das erstellen und zeichnen von Spielsteinen.
 *
 * Drawables können nicht mit equals() verglichen werden.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 11.06.2017 ELF Klasse erstellt.
 */

//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class SpielsteinTest {

//    /** Feld eines Spielsteins */
//    private Feld feld;
//
//    /** Aktivität auf der getestet wird */
//    private Activity activity;
//
//    @Before
//    public void setUp() {
//
//        Position x1 = new Position(0, 0);
//        Position x2 = new Position(40, 0);
//        Position x3 = new Position(40, 40);
//        Position x4 = new Position(0, 40);
//
//        feld = new Feld(x1, x2, x3, x4, 1);
//
//        activity = Robolectric.setupActivity(SpielActivity.class);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Test
//    public void SpielsteinX_Erstellung_Erstellt() {
//
//        Spielstein xSpielstein = new XSpielstein(activity, feld);
//
//        Drawable xDrawable = activity.getApplicationContext().getDrawable(R.drawable.x_24dp);
//        Drawable oDrawable = activity.getApplicationContext().getDrawable(R.drawable.o_24dp);
//
//        assert xDrawable != null;
//        assertThat(xSpielstein.getSpielsteinDrawable().getConstantState()).isEqualTo(xDrawable.getConstantState());
//        assert oDrawable != null;
//        assertThat(xSpielstein.getSpielsteinDrawable().getConstantState()).isNotEqualTo(oDrawable.getConstantState());
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Test
//    public void SpielsteinO_Erstellung_Erstellt() {
//
//        Spielstein oSpielstein = new OSpielstein(activity, feld);
//
//        Drawable xDrawable = activity.getApplicationContext().getDrawable(R.drawable.x_24dp);
//        Drawable oDrawable = activity.getApplicationContext().getDrawable(R.drawable.o_24dp);
//
//        Drawable.ConstantState xCSt = xDrawable.getConstantState();
//        Drawable.ConstantState oCSt = oDrawable.getConstantState();
//
//        Drawable.ConstantState oSpielsteinCSt = oSpielstein.getSpielsteinDrawable().getConstantState();
//
//        assertThat(xCSt).isNotEqualTo(oSpielsteinCSt);
//        assertThat(oCSt).isEqualTo(oSpielsteinCSt);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Test
//    public void VergleichDrawableTest() {
//
//        Drawable oDrawable = activity.getDrawable(R.drawable.o_24dp);
//        Drawable xDrawable = activity.getDrawable(R.drawable.x_24dp);
//
//        assert xDrawable != null;
//        assert oDrawable != null;
//        assertThat(oDrawable.getConstantState()).isNotEqualTo(xDrawable.getConstantState());
//    }
}
