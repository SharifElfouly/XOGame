package shafou.xospiel.SpielLogik;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 *
 * Diese Klasse stellt ein Y Spielstein dar.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 24.05.2017 ELF Klasse erstellt.
 */

public class OSpielstein extends Spielstein {

    /**
     * Ein Spielstein ist ein ImageView in einer Aktivität und besteht daher
     * nur aus dem Kontext und einer Position auf dem Spielfeld.
     *
     * @param context  Kontext der Aktivität
     * @param position Position des Spielsteins
     */
    public OSpielstein(@Nullable Context context, Position position) {
        super(context, position);
    }


}
