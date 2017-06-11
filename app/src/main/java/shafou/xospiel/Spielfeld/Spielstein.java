package shafou.xospiel.Spielfeld;

import android.content.Context;
import android.graphics.drawable.Drawable;

import shafou.xospiel.R;

/**
 *
 * Diese Klasse stellt ein Spielstein dar.
 *
 * <p>Ein Spielstein hat eine Drawable Referenz um den Spielstein zeichnen zu
 * können.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public abstract class Spielstein{

    /** Gibt die Position des Spielsteins auf dem Spielfeld an */
    private Feld feld;

    /** Gibt die Form des Spielsteins an */
    private final Drawable spielsteinDrawable;

    Spielstein(Context context) {

        if(this instanceof XSpielstein) {

            this.spielsteinDrawable = context.getDrawable(R.drawable.x_24dp);
        } else {

            this.spielsteinDrawable = context.getDrawable(R.drawable.o_24dp);
        }
    }

    public Feld getFeld() {
        return feld;
    }

    public void setFeld(Feld feld) {
        this.feld = feld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spielstein that = (Spielstein) o;

        return feld != null ? feld.equals(that.feld) : that.feld == null;

    }

    @Override
    public int hashCode() {
        return feld != null ? feld.hashCode() : 0;
    }

    public Drawable getSpielsteinDrawable() {
        return spielsteinDrawable;
    }
}
