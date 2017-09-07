package shafou.xospiel.PlayingField;

import android.content.Context;
import android.graphics.drawable.Drawable;

import shafou.xospiel.R;

/**
 *
 * This class represents a token.
 *
 * <p>A token has a drawable, to be drawn on the playing field.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 23.05.2017 ELF Class created.
 */

public abstract class Token {

    /** Field on the token is on */
    private Field field;

    /** The drawable of the token to be drawn with */
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
