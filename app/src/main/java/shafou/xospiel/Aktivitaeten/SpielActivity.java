package shafou.xospiel.Aktivitaeten;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.hanks.htextview.evaporate.EvaporateTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.XOSpiel;
import shafou.xospiel.View.StatefulButton;
import shafou.xospiel.View.StatefulButtons;

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

    /** Buttons um die Spiel Art zu ändern */
    @BindView(R.id.change_mode_left_btn) Button change_mode_left_btn;
    @BindView(R.id.change_mode_right_btn) Button change_mode_right_btn;

    /** Anzeige der Spiel Art */
    @BindView(R.id.game_mode_text_view) EvaporateTextView evaporateTextView;

    @BindView(R.id.game_mode_btn_3) ImageButton gameMode3btn;
    @BindView(R.id.game_mode_btn_4) ImageButton gameMode4btn;
    @BindView(R.id.game_mode_btn_5) ImageButton gameMode5btn;

    @BindDrawable(R.drawable.three_selected) Drawable threeSelectedDrawable;
    @BindDrawable(R.drawable.three_not_selected) Drawable threeNotSelectedDrawable;
    @BindDrawable(R.drawable.three_not_selectable) Drawable threeNotSelectableDrawable;

    @BindDrawable(R.drawable.four_selected) Drawable fourSelectedDrawable;
    @BindDrawable(R.drawable.four_not_selected) Drawable fourNotSelectedDrawable;
    @BindDrawable(R.drawable.four_not_selectable) Drawable fourNotSelectableDrawable;

    @BindDrawable(R.drawable.five_selected) Drawable fiveSelectedDrawable;
    @BindDrawable(R.drawable.five_not_selected) Drawable fiveNotSelectedDrawable;
    @BindDrawable(R.drawable.five_not_selectable) Drawable fiveNotSelectableDrawable;

    /** Index der angezeigten Spiel Art */
    private int gameModeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Setzt die Aktivität auf Full Screen Mode
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.spiel_menu);
        ButterKnife.bind(this);

        /** Alle verfügbaren Spielarten und deren Namen*/
        final XOSpiel.Art[] spielArten = XOSpiel.Art.values();
        final List<String> spielArtenNamen = new ArrayList<>();

        for (XOSpiel.Art aSpielArten : spielArten) {

            spielArtenNamen.add(aSpielArten.getSpielArt());
        }

        /** Setzt die Spielart auf die erste */
        evaporateTextView.setText(spielArtenNamen.get(0));

        /** Setzt die Spielart um eins nach links */
        change_mode_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameModeIndex--;
                setGameModeIndex(spielArtenNamen.size());
                evaporateTextView.animateText(spielArtenNamen.get(gameModeIndex));
            }
        });

        /** Setzt die Spielart um eins nach rechts */
        change_mode_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameModeIndex++;
                setGameModeIndex(spielArtenNamen.size());
                evaporateTextView.animateText(spielArtenNamen.get(gameModeIndex));
            }
        });

        final StatefulButton three = new StatefulButton(StatefulButton.State.SELECTED,
                gameMode3btn, threeSelectedDrawable, threeNotSelectedDrawable, threeNotSelectableDrawable);

        final StatefulButton four = new StatefulButton(StatefulButton.State.NOT_SELECTED,
                gameMode4btn, fourSelectedDrawable, fourNotSelectedDrawable, fourNotSelectableDrawable);

        final StatefulButton five = new StatefulButton(gameMode5btn,
                fiveSelectedDrawable, fiveNotSelectedDrawable, fiveNotSelectableDrawable);

        StatefulButtons.add(three);
        StatefulButtons.add(four);
        StatefulButtons.add(five);

        three.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(three);
            }
        });

        four.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(four);
            }
        });

        five.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(five);
            }
        });
    }

    /**
     * Verwaltet den Index der Spiel Art Anzeige
     *
     * @param anzahlSpielarten Anzahl der verfügbaren Spielarten
     */
    private void setGameModeIndex(int anzahlSpielarten) {

        if(gameModeIndex <= 0) {

            gameModeIndex = 0;
        }

        if(gameModeIndex >= anzahlSpielarten - 1) {

            gameModeIndex = anzahlSpielarten -1;
        }
    }


}
