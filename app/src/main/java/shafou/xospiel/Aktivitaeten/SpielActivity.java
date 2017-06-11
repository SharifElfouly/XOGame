package shafou.xospiel.Aktivitaeten;

import android.app.Activity;
import android.os.Bundle;

import shafou.xospiel.SpielLogik.XOSpiel;

/**
 *
 * Diese Klasse beinhaltet die Spiel Aktivität.
 * In dieser Aktivität wird das Spiel Initialisiert.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 11.06.2017 ELF Klasse erstellt.
 */

public class SpielActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int spalten = 3;
        int reihen = 3;

        XOSpiel xOSpiel = XOSpiel.getInstance(this, spalten, reihen);

        /** Das Spielfeld wird als View gesetzt */
        setContentView(xOSpiel.spielfeld());
    }
}
