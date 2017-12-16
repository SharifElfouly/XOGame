package shafou.xospiel.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import shafou.xospiel.GameLogic.XOGame;

/**
 *
 * This activity displays the game.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 07.09.2017 ELF Class created.
 */

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullscreen();

        Intent gameMenuIntent = getIntent();
        int fieldSize = gameMenuIntent.getIntExtra("field_size", 3);
        int tokens_to_win = gameMenuIntent.getIntExtra("tokens_to_win", 3);

        View gameView = XOGame.getInstance(this, fieldSize, tokens_to_win).spielfeld();
        setContentView(gameView);
    }

    /**
     * Sets activity to fullscreen.
     */
    private void setFullscreen() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
