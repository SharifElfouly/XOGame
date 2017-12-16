package shafou.xospiel.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.TimerTask;

import shafou.xospiel.R;

/**
 *
 * This activity starts the animation layout when first opening the app
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 16.12.2017 ELF Activity created.
 */

public final class StartAnimationActivity extends Activity {

    private static final int ANIMATION_DURATION_IN_MS = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_animation);

        new Handler().postDelayed(new TimerTask() {
            @Override
            public void run() {
                Intent openGameMenuActivity = new Intent(getApplicationContext()
                        , GameMenuActivity.class);

                startActivity(openGameMenuActivity);
            }
        }, ANIMATION_DURATION_IN_MS);
    }
}
