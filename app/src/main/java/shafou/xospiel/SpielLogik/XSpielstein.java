package shafou.xospiel.SpielLogik;

import android.content.Context;

import shafou.xospiel.R;

/**
 *
 * Diese Klasse stellt ein X Spielstein dar.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 */

public class XSpielstein extends Spielstein {

    /**
     * Ein Spielstein ist ein ImageView in einer Aktivität und besteht daher
     * nur aus dem Kontext und einer Position auf dem Spielfeld.
     *
     * @param context  Kontext der Aktivität
     * @param position Position des Spielsteins
     */
    public XSpielstein(Context context, Position position) {
        super(context, position);

        setImageResource(R.mipmap.ic_launcher);
        setBackgroundResource(R.color.colorPrimary);
    }


}
