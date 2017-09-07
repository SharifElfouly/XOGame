package shafou.xospiel.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.XOGame;

/**
 *
 * This activity displays the game.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 07.09.2017 ELF Class created.
 */

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View gameView = XOGame.getInstance(this, 3).spielfeld();
        setContentView(gameView);
    }
}
