package shafou.xospiel.Aktivitaeten;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

import shafou.xospiel.Spielfeld.Linie;
import shafou.xospiel.Spielfeld.XOSpielfeldGenerator;

public class Activity_View extends View {

    Paint black_Paintbrush;

    XOSpielfeldGenerator xOG = new XOSpielfeldGenerator(750, 1100, 3, 3);

    public Activity_View(Context context) {
        super(context);

        black_Paintbrush = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        ArrayList<Linie> xOSpielfeldLinien = xOG.feldLinienBerechnen(5);


        black_Paintbrush.setColor(Color.BLACK);
        black_Paintbrush.setStyle(Paint.Style.FILL_AND_STROKE);
        black_Paintbrush.setStrokeWidth(10);

        for(Linie linie: xOSpielfeldLinien) {

            float startX = linie.getAnfangsPosition().getxPosition();
            float startY = linie.getAnfangsPosition().getyPosition();
            float endX = linie.getEndPosition().getxPosition();
            float endY = linie.getEndPosition().getyPosition();

            canvas.drawLine(startX, startY, endX, endY, black_Paintbrush);

        }
    }
}
