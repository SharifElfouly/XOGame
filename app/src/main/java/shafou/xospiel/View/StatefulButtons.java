package shafou.xospiel.View;


import java.util.ArrayList;
import java.util.List;

import shafou.xospiel.SpielLogik.XOGame;

import static shafou.xospiel.View.StatefulButton.State.*;
import static shafou.xospiel.View.StatefulButton.State.NOT_SELECTABLE;
import static shafou.xospiel.View.StatefulButton.State.SELECTED;

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

        if(button.getState() == NOT_SELECTABLE) {

            return;
        }

        for(StatefulButton sButton: list) {

            switch (sButton.getState()){

                case SELECTED: sButton.setState(NOT_SELECTED);
                    break;
            }

            if(sButton.equals(button) && sButton.getState().equals(NOT_SELECTED)) {

                sButton.setState(SELECTED);
            }
        }
    }

    public static void setSelectableButtons(XOGame.Mode spielart) {

        int[] anzahlSteineZumGewinn = spielart.getAnzahlSteineZumGewinn();

        for(int anzahlSteine: anzahlSteineZumGewinn) {

            switch (anzahlSteine){

                case 3:
                    if(list.get(0).getState() == SELECTED) {
                        break;
                    } else {

                        list.get(0).setState(NOT_SELECTED);
                        break;
                    }
                case 4:
                    if(list.get(1).getState() == SELECTED) {
                        break;
                    } else {

                        list.get(1).setState(NOT_SELECTED);
                        break;
                    }
                case 5:
                    if(list.get(2).getState() == SELECTED) {
                        break;
                    } else {

                        list.get(2).setState(NOT_SELECTED);
                        break;
                    }
            }
        }
    }

    public static void setNotSelectableButtons(XOGame.Mode spielart) {

        int[] anzahlSteineZumGewinn = spielart.getAnzahlSteineZumGewinn();

        boolean is4In = false;
        boolean is5In = false;

        for(int anzahlSteine: anzahlSteineZumGewinn) {

            switch (anzahlSteine){
                case 3:
                    break;
                case 4: is4In = true;
                    break;
                case 5: is5In = true;
                    break;
            }
        }

        if(!is4In) {

            list.get(0).setState(SELECTED);
            list.get(1).setState(NOT_SELECTABLE);
            list.get(2).setState(NOT_SELECTABLE);
            return;
        }

        if(!is5In) {

            if(list.get(0).getState() != SELECTED) {

                list.get(1).setState(SELECTED);
            }

            list.get(2).setState(NOT_SELECTABLE);
        }
    }
}
