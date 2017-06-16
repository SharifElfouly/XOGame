package shafou.xospiel.Activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewAnimator;

import com.hanks.htextview.evaporate.EvaporateTextView;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.XOGame;
import shafou.xospiel.View.StatefulButton;
import shafou.xospiel.View.StatefulButtons;
import shafou.xospiel.View.XOPlayingField;

import static shafou.xospiel.View.StatefulButton.State.SELECTED;

/**
 *
 * This class contains the game menu activity.
 * <p>
 * In this activity the player can choose one game mode and how many tokens
 * are required to win a particular game.
 * </p>
 * <p>
 * This activity also contains a small preview of the game.
 * The start Button starts the game.
 * </p>
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 11.06.2017 ELF Class created.
 */

public class GameMenuActivity extends Activity {

    /** Buttons to change the game mode */
    @BindView(R.id.change_mode_left_btn) Button changeGameModeLeftBtn;
    @BindView(R.id.change_mode_right_btn) Button changeGameModeRightBtn;

    /** TextView that shows the chosen game mode */
    @BindView(R.id.game_mode_text_view) EvaporateTextView gameModeTV;

    /** Buttons that indicate how many tokens are required to win */
    @BindView(R.id.three_tokens_btn) ImageButton threeTokensBtn;
    @BindView(R.id.four_tokens_btn) ImageButton fourTokensBtn;
    @BindView(R.id.five_tokens_btn) ImageButton fiveTokensBtn;

    /** Drawables of the tokens required to win buttons */
    @BindDrawable(R.drawable.three) Drawable drawableThree;
    @BindDrawable(R.drawable.four) Drawable drawableFour;
    @BindDrawable(R.drawable.five) Drawable drawableFive;

    /** This view animator holds X/O playing field previews */
    @BindView(R.id.playing_fields_view_animator) ViewAnimator playingFieldsViewAnimator;

    /** Index of the game mode shown in the TextView */
    private int gameModeIndex = 0;

    /** Stateful buttons that indicate how many tokens are required to win */
    private StatefulButton sThreeTokensBtn;
    private StatefulButton sFourTokensBtn;
    private StatefulButton sFiveTokensBtn;

    /** All game modes */
    final XOGame.Mode[] gameModes = XOGame.Mode.values();

    /** All game mode names */
    final List<String> gameModeNames = XOGame.Mode.getModeNames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        makeActivityFullscreen();

        setContentView(R.layout.game_menu);
        ButterKnife.bind(this);

        addViewsToViewAnimator();

        setUpChangeGameModeLeftBtn();

        setUpChangeGameModeRightBtn();

        /** Set the game mode to the first one */
        gameModeTV.setText(gameModeNames.get(0));

        setUpGameTokensBtns();
    }

    /**
     * Manages the game mode indexing.
     * The game mode indexing is limited to the very first and last one.
     *
     * @param gameModes Amount of all game modes
     */
    private void setGameModeIndex(int gameModes) {

        if(gameModeIndex <= 0) {

            gameModeIndex = 0;
        }

        if(gameModeIndex >= gameModes - 1) {

            gameModeIndex = gameModes -1;
        }
    }

    /**
     * Sets the activity to fullscreen
     */
    private void makeActivityFullscreen() {

        /** Sets the activity to fullscreen */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Adds all X/O playing field previews to the view animator.
     */
    private void addViewsToViewAnimator() {

        playingFieldsViewAnimator.addView(new XOPlayingField(this, 3));
        playingFieldsViewAnimator.addView(new XOPlayingField(this, 4));
        playingFieldsViewAnimator.addView(new XOPlayingField(this, 5));
    }

    /**
     * Implements the game mode left changer button.
     * After the button got clicked:
     *  - It decreases the game mode index
     *  - It animates the new game mode text if available
     *  - Sets the button to not selectable if necessary
     *  - Shows the new X/O playing field preview if available
     */
    private void setUpChangeGameModeLeftBtn() {

        changeGameModeLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameModeIndex--;
                setGameModeIndex(gameModeNames.size());
                gameModeTV.animateText(gameModeNames.get(gameModeIndex));
                StatefulButtons.setNotSelectableButtons(gameModes[gameModeIndex]);
                playingFieldsViewAnimator.showPrevious();
            }
        });
    }

    /**
     * Implements the game mode right changer button.
     * After the button got clicked:
     *  - It increases the game mode index
     *  - It animates the new game mode text if available
     *  - Sets the button to selectable if necessary
     *  - Shows the new X/O playing field preview if available
     */
    private void setUpChangeGameModeRightBtn() {

        changeGameModeRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameModeIndex++;
                setGameModeIndex(gameModeNames.size());
                gameModeTV.animateText(gameModeNames.get(gameModeIndex));
                StatefulButtons.setSelectableButtons(gameModes[gameModeIndex]);
                playingFieldsViewAnimator.showNext();
            }
        });
    }

    /**
     * Initialize the Token Buttons.
     * If a button is clicked it is selected if possible.
     */
    private void setUpGameTokensBtns() {

        /** 3 tokens stateful btn */
        sThreeTokensBtn = new StatefulButton(SELECTED,
                threeTokensBtn, drawableThree);

        /** 4 tokens stateful btn */
        sFourTokensBtn = new StatefulButton(fourTokensBtn, drawableFour);

        /** 5 tokens stateful btn */
        sFiveTokensBtn = new StatefulButton(fiveTokensBtn,
                drawableFive);

        /** Add all stateful buttons for management to stateful buttons */
        StatefulButtons.add(sThreeTokensBtn);
        StatefulButtons.add(sFourTokensBtn);
        StatefulButtons.add(sFiveTokensBtn);

        sThreeTokensBtn.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(sThreeTokensBtn);
            }
        });

        sFourTokensBtn.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(sFourTokensBtn);
            }
        });

        sFiveTokensBtn.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatefulButtons.setSelected(sFiveTokensBtn);
            }
        });
    }
}
