package shafou.xospiel.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.SpielfeldInputVerarbeiter;
import shafou.xospiel.SpielLogik.XOSpiel;
import shafou.xospiel.SpielLogik.Zug;
import shafou.xospiel.Spielfeld.Feld;
import shafou.xospiel.Spielfeld.Linie;
import shafou.xospiel.Spielfeld.XOSpielfeldGenerator;

/**
 *
 * Diese Klasse generiert das Spielfeld View.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 10.06.2017 ELF Klasse erstellt.
 */

@SuppressLint("ViewConstructor")
public class XOSpielfeldView extends View {

    /** Schwarze Farbe */
    Paint blackPaint;

    /** X/O Spielfeld Generator */
    XOSpielfeldGenerator xOG;

    SpielfeldInputVerarbeiter<XOSpielfeldGenerator> inputVerarbeiter;

    @BindDrawable(R.drawable.x_24dp) Drawable xDrawable;
    @BindDrawable(R.drawable.o_24dp) Drawable oDrawable;
    public XOSpielfeldView(Context context, int spalten, int reihen) {
        super(context);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(10);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        xOG = new XOSpielfeldGenerator(spalten, reihen);
        inputVerarbeiter = new SpielfeldInputVerarbeiter<>();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        xOG.setBreite(getWidth());
        xOG.setHoehe(getHeight());
        xOG.berechneSpielfelder();
        inputVerarbeiter.setSpielfeldGenerator(xOG);

        List<Linie> spielfeldLinien = xOG.feldLinienBerechnen(5);

        for(Linie spielfeldLinie: spielfeldLinien) {

            float startX = spielfeldLinie.getAnfangsPosition().getXPosition();
            float startY = spielfeldLinie.getAnfangsPosition().getYPosition();
            float endX = spielfeldLinie.getEndPosition().getXPosition();
            float endY = spielfeldLinie.getEndPosition().getYPosition();

            canvas.drawLine(startX, startY, endX, endY, blackPaint);
        }

        drawSteine(canvas);
    }

    /**
     * Zeichnet die einzelnen Spielsteine auf dem Canvas.
     *
     * @param canvas Canvas auf dem gezeichnet wird.
     */
    private void drawSteine(Canvas canvas) {

        if(XOSpiel.getGespielteZuege() != null) {

            for(Zug zug: XOSpiel.getGespielteZuege()) {

                zug.draw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        Feld spielfeld = inputVerarbeiter.gibSpielfeld(new Position(x, y));

        if(spielfeld != null) {

            XOSpiel.zugGespielt(new Zug(XOSpiel.gibAktuellenSpielstein(), spielfeld));
            invalidate();
        }

        return false;
    }

    /**
     * Erstellt das Spielfeld neu
     *
     * @param spalten Spalten des neuen Spielfeldes
     * @param reihen Reihen des Spielfeldes
     */
    public void restart(int spalten, int reihen) {

        invalidate();
        inputVerarbeiter = new SpielfeldInputVerarbeiter<>();
        xOG = new XOSpielfeldGenerator(spalten, reihen);
    }

}
