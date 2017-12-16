package shafou.xospiel.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewAnimator;

import com.hanks.htextview.evaporate.EvaporateTextView;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import shafou.xospiel.R;
import shafou.xospiel.GameLogic.XOGame;
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
 * Change log:
 * 1) 11.06.2017 ELF class created.
 * 2) 16.12.2017 ELF fixed bug when switching between game mode previews
 */

public class GameMenuActivity extends AppCompatActivity {

    /** Buttons to change the game mode */
    @BindView(R.id.change_mode_left_btn) Button changeGameModeLeftBtn;
    @BindView(R.id.change_mode_right_btn) Button changeGameModeRightBtn;

    /** TextView that shows the chosen game mode */
    @BindView(R.id.game_mode_text_view) EvaporateTextView gameModeTV;

    /** Buttons that indicate how many tokens are required to win */
    @BindView(R.id.three_tokens_btn) ImageButton threeTokensBtn;
    @BindView(R.id.four_tokens_btn) ImageButton fourTokensBtn;
    @BindView(R.id.five_tokens_btn) ImageButton fiveTokensBtn;

    @BindView(R.id.start_btn) Button startBtn;

    /** Drawables of the tokens required to win buttons */
    @BindDrawable(R.drawable.three) Drawable drawableThree;
    @BindDrawable(R.drawable.four) Drawable drawableFour;
    @BindDrawable(R.drawable.five) Drawable drawableFive;

    /** This view animator holds X/O playing field previews */
    @BindView(R.id.playing_fields_view_animator) ViewAnimator gameModePreviewViewAnimator;

    /** Current index of the game mode */
    private int gameModeIndex = 0;

    /** Stateful buttons that indicate how many tokens are required to win */
    private StatefulButton sThreeTokensBtn;
    private StatefulButton sFourTokensBtn;
    private StatefulButton sFiveTokensBtn;

    /** All game modes */
    private final XOGame.Mode[] gameModes = XOGame.Mode.values();

    /** All game mode names */
    private final List<String> gameModeNames = XOGame.Mode.getModeNames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullscreen();

        setContentView(R.layout.game_menu);
        ButterKnife.bind(this);

        initStartBtn();

        addPreviewsToViewAnimator();

        decreaseGameModeBtn();

        increaseGameModeBtn();

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

            gameModeIndex = gameModes - 1;
        }
    }

    /**
     * Sets activity to fullscreen.
     */
    private void setFullscreen() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Adds all X/O playing field previews to the view animator.
     * For every game mode a preview of the playing field is added.
     */
    private void addPreviewsToViewAnimator() {

        for(XOGame.Mode gameMode: gameModes) {

            XOPlayingField xOPF = new XOPlayingField(this, gameMode.getColumnsAndRows());
            gameModePreviewViewAnimator.addView(xOPF);
        }
    }

    /**
     * Implements the game mode left changer button.
     * After the button got clicked:
     *  - It decreases the game mode index
     *  - It animates the new game mode text if available
     *  - Sets the button to not selectable if necessary
     *  - Shows the new X/O playing field preview if available
     */
    private void decreaseGameModeBtn() {

        changeGameModeLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setLeftToRightPreviewAnimation();
                gameModeIndex--;
                setGameModeIndex(gameModeNames.size());
                gameModeTV.animateText(gameModeNames.get(gameModeIndex));
                StatefulButtons.setNotSelectableButtons(gameModes[gameModeIndex]);
            }
        });
    }

    /**
     * Sets the animation of the game mode preview for a left change.
     */
    private void setLeftToRightPreviewAnimation() {

        if(gameModeIndex != 0){

            Animation leftIn = AnimationUtils.loadAnimation(this, R.anim.left_in);
            Animation rightOut = AnimationUtils.loadAnimation(this, R.anim.right_out);

            gameModePreviewViewAnimator.setInAnimation(leftIn);
            gameModePreviewViewAnimator.setOutAnimation(rightOut);

            gameModePreviewViewAnimator.showPrevious();
        }
    }

    /**
     * Sets the animation of the game mode preview for a right change.
     */
    private void setRightToLeftPreviewAnimation() {

        if(gameModeIndex != gameModeNames.size() - 1) {

            Animation leftOut = AnimationUtils.loadAnimation(this, R.anim.left_out);
            Animation rightIn = AnimationUtils.loadAnimation(this, R.anim.right_in);

            gameModePreviewViewAnimator.setOutAnimation(leftOut);
            gameModePreviewViewAnimator.setInAnimation(rightIn);

            gameModePreviewViewAnimator.showNext();
        }
    }

    /**
     * Implements the game mode right changer button.
     * After the button got clicked:
     *  - It increases the game mode index
     *  - It animates the new game mode text if available
     *  - Sets the button to selectable if necessary
     *  - Shows the new X/O playing field preview if available
     */
    private void increaseGameModeBtn() {

        changeGameModeRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRightToLeftPreviewAnimation();
                gameModeIndex++;
                setGameModeIndex(gameModeNames.size());
                gameModeTV.animateText(gameModeNames.get(gameModeIndex));
                StatefulButtons.setSelectableButtons(gameModes[gameModeIndex]);
            }
        });
    }

    /**
     * Initialize the Token Buttons.
     * If a button is clicked it is selected if possible.
     */
    private void setUpGameTokensBtns() {

        /** 3 tokens stateful btn is default selected */
        sThreeTokensBtn = new StatefulButton(SELECTED, threeTokensBtn,
                drawableThree);

        sFourTokensBtn = new StatefulButton(fourTokensBtn, drawableFour);

        sFiveTokensBtn = new StatefulButton(fiveTokensBtn, drawableFive);

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

    /**
     * Init start btn
     */
    private void initStartBtn() {

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    /**
     * Starts game activity
     */
    private void startGame() {

        Intent gameActivity = new Intent(this, GameActivity.class);
        gameActivity.putExtra("field_size", getFieldSize(gameModeIndex));
        gameActivity.putExtra("tokens_to_win", getTokenNumberOfSelectedButton());


        startActivity(gameActivity);
    }

    /**
     * Returns number of required tokens to win button.
     */
    @Nullable
    private Integer getTokenNumberOfSelectedButton() {

        StatefulButton button = StatefulButtons.getSelected();

        if(button != null) {

            if(button.equals(sThreeTokensBtn)) {

                return 3;
            } else if(button.equals(sFourTokensBtn)) {

                return 4;
            } else if(button.equals(sFiveTokensBtn)) {

                return 5;
            }
        } else {

            throw new NullPointerException("No required tokens to win button " +
                    "selected");
        }

        return null;
    }

    private int getFieldSize(int gameModeIndex) {

        switch (gameModeIndex){
            case 0: return 3;
            case 1: return 4;
            case 2: return 5;
        }

        return 3;
    }
}
