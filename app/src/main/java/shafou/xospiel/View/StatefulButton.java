package shafou.xospiel.View;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 *
 * Diese Klasse verwaltet Buttons, zur Auswahl wie viele Steine benötigt werden
 * um das Spiel zu gewinnen;
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 13.06.2017 ELF Klasse erstellt.
 */

public class StatefulButton {

    /** Status des Buttons */
    private State state;

    /** Button */
    private final ImageButton button;

    /** Angezeigtes Drawable wenn der Button selektiert wurde */
    private final Drawable selected;

    /** Angezeigtes Drawable wenn der Button nicht selektiert ist */
    private final Drawable notSelected;

    /** Angezeigtes Drawable wenn der Button nicht selektiert werden kann */
    private final Drawable notSelectable;

    /**
     * Ein Button mit einem zugeordneten status
     *
     * @param state Status in dem sich der Button befindet
     * @param button Der Button
     * @param selected Drawable, der angezeigt werden soll, wenn der Button
     *                 selektiert ist.
     * @param notSelected Drawable, der angezeigt wird, wenn der Button nicht
     *                    selektiert ist.
     * @param notSelectable Drawable, der angezeigt wird, wenn der Button nicht
     *                      selektierbar ist.
     */
    public StatefulButton(State state, ImageButton button, Drawable selected,
                          Drawable notSelected, Drawable notSelectable) {

        this.state = state;
        this.button = button;
        this.selected = selected;
        this.notSelected = notSelected;
        this.notSelectable = notSelectable;

        setButtonSize();
        updateDrawable();
    }

    /** Wird kein Status gesetzt wird dieser auf nicht selektierbar gestellt */
    public StatefulButton(ImageButton button, Drawable selected,
                          Drawable notSelected, Drawable notSelectable) {

        this(State.NOT_SELECTABLE, button, selected, notSelected, notSelectable);
    }

    /** Status die ein Button annehmen kann */
     public enum State {

        SELECTED,
        NOT_SELECTED,
        NOT_SELECTABLE
    }

    /**
     * Setzt dem Button einen neuen Status.
     *
     * @param state Der neue Status
     */
    void setState(State state) {

        this.state = state;

        /**
         * Wenn der Status gewächselt wird, muss der Drawable aktualisiert
         * werden
         */
        updateDrawable();
    }

    /**
     * Aktualisiert den Drawable des Buttons.
     */
    private void updateDrawable() {

        switch (state){
            case SELECTED: button.setImageDrawable(selected);
                break;
            case NOT_SELECTED: button.setImageDrawable(notSelected);
                break;
            case NOT_SELECTABLE: button.setImageDrawable(notSelectable);
        }
    }

    /**
     * Setzt die Größe des Buttons.
     */
    private void setButtonSize() {

        ViewGroup.LayoutParams buttonLayout = button.getLayoutParams();
        buttonLayout.height = 130;
        buttonLayout.width = 130;
        button.setLayoutParams(buttonLayout);
    }

    public ImageButton getButton() {
        return button;
    }

    State getState() {
        return state;
    }


    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatefulButton button1 = (StatefulButton) o;

        if (button != null ? !button.equals(button1.button) : button1.button != null)
            return false;
        if (selected != null ? !selected.equals(button1.selected) : button1.selected != null)
            return false;
        if (notSelected != null ? !notSelected.equals(button1.notSelected) : button1.notSelected != null)
            return false;
        return notSelectable != null ? notSelectable.equals(button1.notSelectable) : button1.notSelectable == null;

    }

    @Override
    public int hashCode() {
        int result = button != null ? button.hashCode() : 0;
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        result = 31 * result + (notSelected != null ? notSelected.hashCode() : 0);
        result = 31 * result + (notSelectable != null ? notSelectable.hashCode() : 0);
        return result;
    }
}
