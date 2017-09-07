package shafou.xospiel.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.Line;
import shafou.xospiel.R;
import shafou.xospiel.SpielLogik.PlayingFieldInputProcessor;
import shafou.xospiel.SpielLogik.Position;
import shafou.xospiel.SpielLogik.Turn;
import shafou.xospiel.SpielLogik.XOGame;
import shafou.xospiel.PlayingField.XOPlayingFieldGenerator;

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
public class XOPlayingField extends View {

    @BindDrawable(R.drawable.x_24dp) Drawable xDrawable;
    @BindDrawable(R.drawable.o_24dp) Drawable oDrawable;

    /** Schwarze Farbe */
    Paint blackPaint;

    /** X/O Spielfeld Generator */
    XOPlayingFieldGenerator xOG;

    PlayingFieldInputProcessor<XOPlayingFieldGenerator> inputVerarbeiter;

    Context context;

    public XOPlayingField(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(10);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        xOG = new XOPlayingFieldGenerator(3);
        inputVerarbeiter = new PlayingFieldInputProcessor<>(xOG);
        ButterKnife.bind(this);
    }

    public XOPlayingField(Context context, int columnsAndRows) {
        super(context);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(10);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        xOG = new XOPlayingFieldGenerator(columnsAndRows);
        inputVerarbeiter = new PlayingFieldInputProcessor<>(xOG);
        ButterKnife.bind(this);
    }

    @Override
    public void onDraw(Canvas canvas) {

        xOG.setWidth(getWidth());
        xOG.setHeight(getHeight());
        xOG.berechneSpielfelder();
        inputVerarbeiter = new PlayingFieldInputProcessor<>(xOG);

        List<Line> spielfeldLinien = xOG.calculatesLines(5);

        for(Line spielfeldLine : spielfeldLinien) {

            float startX = spielfeldLine.getStart().getXPosition();
            float startY = spielfeldLine.getStart().getYPosition();
            float endX = spielfeldLine.getEnd().getXPosition();
            float endY = spielfeldLine.getEnd().getYPosition();

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

        if(XOGame.getGespielteZuege() != null) {

            for(Turn turn : XOGame.getGespielteZuege()) {

                turn.draw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        Field spielfeld = null;

        if(inputVerarbeiter != null) {

            spielfeld = inputVerarbeiter.getField(new Position(x, y));
        }

        if(spielfeld != null) {

            XOGame.zugGespielt(new Turn(XOGame.gibAktuellenSpielstein(), spielfeld));
            invalidate();
        }

        return false;
    }

    /**
     * Erstellt das Spielfeld neu
     *
     * @param columnsAndRows
     */
    public XOPlayingField restart(int columnsAndRows) {

        invalidate();
        xOG = new XOPlayingFieldGenerator(columnsAndRows);
        inputVerarbeiter = new PlayingFieldInputProcessor<>(xOG);
        return this;
    }

}
