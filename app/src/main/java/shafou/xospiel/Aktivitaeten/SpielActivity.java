package shafou.xospiel.Aktivitaeten;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.hanks.htextview.evaporate.EvaporateTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.XOSpiel;

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

    EvaporateTextView textView;

    @BindView(R.id.change_mode_left_btn) Button change_mode_left_btn;
    @BindView(R.id.change_mode_right_btn) Button change_mode_right_btn;

    @BindView(R.id.game_mode_text_view) EvaporateTextView evaporateTextView;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int spalten = 3;
        int reihen = 3;

//        XOSpiel xOSpiel = XOSpiel.getInstance(this, spalten, reihen);

        /** Das Spielfeld wird als View gesetzt */
//        setContentView(xOSpiel.spielfeld());

        setContentView(R.layout.spiel_menu);

        ButterKnife.bind(this);

        final XOSpiel.Art[] spielArten = XOSpiel.Art.values();

        final List<String> spielArtenNamen = new ArrayList<>();

        for (XOSpiel.Art aSpielArten : spielArten) {

            spielArtenNamen.add(aSpielArten.getSpielArt());
        }

        evaporateTextView.setText(spielArtenNamen.get(0));

        change_mode_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index--;
                setIndex(spielArtenNamen.size());
                evaporateTextView.animateText(spielArtenNamen.get(index));
            }
        });

        change_mode_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index++;
                setIndex(spielArtenNamen.size());
                evaporateTextView.animateText(spielArtenNamen.get(index));
            }
        });
    }

    private void setIndex(int length) {

        if(index <= 0) {

            index = 0;
        }

        if(index >= length - 1) {

            index = length -1;
        }
    }
}
