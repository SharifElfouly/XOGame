package shafou.xospiel.SpielLogik;

import android.content.Context;
import android.widget.ImageView;

/**
 *
 * Diese Klasse stellt ein Spielstein auf dem Spielfeld dar.
 *
 * <p>Ein Spielstein ist ein ImageView und hat das Bild des Spielsteins als
 * Hintergrundbild.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public abstract class Spielstein extends ImageView{

    /** Gibt die Position des Spielsteins auf dem Spielfeld an */
    private Position position;

    /**
     * Ein Spielstein ist ein ImageView in einer Aktivität und besteht daher
     * nur aus dem Kontext und einer Position auf dem Spielfeld.
     *
     * @param context Kontext der Aktivität
     * @param position Position des Spielsteins
     */
    public Spielstein(Context context, Position position) {
        super(context);

        this.position = position;
    }

    /** Gibt die Position des Spielsteins zurück */
    public Position getPosition() {
        return position;
    }

    /** Setzt die Position des Spielsteins  */
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {

        Class Spielstein = this.getClass();

        return "Der Spielstein: "
                + Spielstein.getSimpleName()
                + "\n"
                + this.position.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spielstein that = (Spielstein) o;

        return position != null ? position.equals(that.position) : that.position == null;

    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
