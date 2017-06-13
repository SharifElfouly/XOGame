package shafou.xospiel.View;


import java.util.ArrayList;
import java.util.List;

import static shafou.xospiel.View.StatefulButton.*;

/**
 *
 * Diese Klasse stellt den Zusammenhang mehrerer Stateful Buttons dar.
 * Logische Zusammenhänge werden hier abgebildet.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 13.06.2017 ELF Klasse erstellt.
 */

public class StatefulButtons {

    /** Liste von Stateful Buttons */
    private static List<StatefulButton> list = new ArrayList<>();

    public static void add(StatefulButton button) {

        list.add(button);
    }

    /**
     * Logik, wenn ein Button selektiert wird.
     *
     * @param button Button der selektiert wurde.
     */
    public static void setSelected(StatefulButton button) {

        if(button.getState() == State.NOT_SELECTABLE) {

            return;
        }

        for(StatefulButton sButton: list) {

            switch (sButton.getState()){

                case SELECTED: sButton.setState(State.NOT_SELECTED);
                    break;
            }

            if(sButton.equals(button) && sButton.getState().equals(State.NOT_SELECTED)) {

                sButton.setState(State.SELECTED);
            }
        }
    }
}
