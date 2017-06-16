package shafou.xospiel.PlayingField;

import android.content.Context;
import android.graphics.drawable.Drawable;

import shafou.xospiel.R;

/**
 *
 * Diese Klasse stellt ein Token dar.
 *
 * <p>Ein Token hat eine Drawable Referenz um den Token zeichnen zu
 * können.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public abstract class Token {

    /** Gibt die Position des Spielsteins auf dem Spielfeld an */
    private Field field;

    /** Gibt die Form des Spielsteins an */
    private final Drawable drawable;

    Token(Context context) {

        if(this instanceof XToken) {

            this.drawable = context.getDrawable(R.drawable.x_24dp);
        } else {

            this.drawable = context.getDrawable(R.drawable.o_24dp);
        }
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token that = (Token) o;

        return field != null ? field.equals(that.field) : that.field == null;

    }

    @Override
    public int hashCode() {
        return field != null ? field.hashCode() : 0;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
