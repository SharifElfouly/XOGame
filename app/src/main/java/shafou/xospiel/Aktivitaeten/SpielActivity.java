package shafou.xospiel.Aktivitaeten;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.XSpielstein;
import shafou.xospiel.Spielfeld.Linie;
import shafou.xospiel.Spielfeld.XOSpielfeldGenerator;

public class SpielActivity extends Activity {

    Activity_View av;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        av = new Activity_View(this);

        setContentView(av);
    }
}
