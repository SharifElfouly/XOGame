package shafou.xospiel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.XSpielstein;

public class SpielActivity extends Activity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_spiel);
//        float xLayout = relativeLayout.getWidth();
//        float yLayout = relativeLayout.getHeight();
//
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;
//
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                float xPosition = event.getX();
//                float yPosition = event.getY();
//
//                return false;
//            }
//        });
//
//        relativeLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//
//
//                System.out.println();;
//            }
//        });

        // TEst
        float breite = 750;
        float hoehe = 1200;

        ArrayList<DisplayRechtecke> layoutDisplayQuadrate
                = LayoutDisplayRechteckGenerator
                    .teileDisplayInRechtecke(new LayoutDisplay(breite, hoehe), 1, 10);

        for(DisplayRechtecke displayRechtecke : layoutDisplayQuadrate) {

            XSpielstein xSpielstein = new XSpielstein(this, displayRechtecke.getX1());

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
            params.leftMargin = (int) displayRechtecke.getX1().getxPosition();
            params.topMargin = (int) displayRechtecke.getX1().getyPosition();

            relativeLayout.addView(xSpielstein, params);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        float xLayout = relativeLayout.getWidth();
        float yLayout = relativeLayout.getHeight();
    }
}
