package shafou.xospiel.SpielLogik;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import shafou.xospiel.Spielfeld.OSpielstein;
import shafou.xospiel.Spielfeld.Spielstein;
import shafou.xospiel.Spielfeld.XSpielstein;
import shafou.xospiel.View.XOSpielfeldView;

/**
 *
 * Diese Klasse enthält die X/O Spiel Steuerung.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 11.06.2017 ELF Klasse erstellt.
 */

public final class XOSpiel {

    /** Die X/O Spiel Referenz */
    @SuppressLint("StaticFieldLeak")
    private static XOSpiel xOSpiel;

    /** Enthält die bereits gespielten Züge */
    private static List<Zug> gespielteZuege;

    /** Das Spielfeld View */
    private static XOSpielfeldView xOSpielView;

    /** Kontext der aufrufenden Aktivität */
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    /** Anzahl der Spalten und Reihen dieses Spiels */
    private static int spalten;

    private  XOSpiel() {}

    /** Gibt die verfügbaren Spielarten an */
    public enum Art {

        DREI("3 x 3", 3),
        VIER("4 x 4", 4),
        FUENF("5 x 5", 5);

        private final String spielArt;
        private final int reihenSpalten;

        Art(String spielArt, int reihenSpalten) {

            this.spielArt = spielArt;
            this.reihenSpalten = reihenSpalten;
        }

        public int getReihenSpalten() {
            return reihenSpalten;
        }

        public String getSpielArt() {
            return spielArt;
        }
    }

    /**
     * Das X/O Spiel wurde als Singelton implementiert.
     * Zur Laufzeit existiert nur 1 Spiel.
     *
     * @param context Kontext der aufrufenden Aktivität
     * @param spalten Anzahl der Spalten des Spiels
     * @param reihen Anzahl der Reihen des Spiels
     * @return X/O Spiel Objekt
     */
    public static XOSpiel getInstance(Context context, int spalten, int reihen) {

        if(xOSpiel == null) {

            xOSpiel = new XOSpiel();
            XOSpiel.context = context;
            xOSpielView = new XOSpielfeldView(context, spalten, reihen);
            gespielteZuege = new ArrayList<>();
            XOSpiel.spalten = spalten;
        }

        return xOSpiel;
    }

    /**
     * Wird aufgerufen wenn ein neuer Zug im Spiel gesetzt wurde.
     * Nur Züge auf neuen Spielfeldern werden akzeptiert.
     *
     * @param zug Gesetzter Zug.
     */
    public static void zugGespielt(Zug zug) {

        if(!gespielteZuege.contains(zug)) {

            gespielteZuege.add(zug);
            if(feldAuswerten()) {

                new AlertDialog.Builder(context)
                        .setTitle("Das Spiel ist vorbei")
                        .setMessage("Spiel neu starten?")
                        .setCancelable(false)
                        .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                XOSpiel.neuStarten(context, 3, 3);
                            }
                        }).show();
            }
        }
    }

    /**
     * Gibt alle Züge der X Spielsteine zurück.
     *
     * @return Liste von Zügen
     */
    private static List<Zug> getXZuege() {

        List<Zug> xZuege = new ArrayList<>();

        for(Zug zug: gespielteZuege) {

            if(zug.getSpielstein() instanceof XSpielstein) {

                xZuege.add(zug);
            }
        }

        return xZuege;
    }

    /**
     * Gibt alle Züge der O Spielsteine zurück.
     *
     * @return Liste von Zügen
     */
    private static List<Zug> getOZuege() {

        List<Zug> oZuege = new ArrayList<>();

        for(Zug zug: gespielteZuege) {

            if(zug.getSpielstein() instanceof OSpielstein) {

                oZuege.add(zug);
            }
        }

        return oZuege;
    }

    /**
     * Auswertung des aktuellen Spiels.
     *
     * @return <code>true</code> falls das Spiel gewonnen wurde.
     */
    private static boolean feldAuswerten() {

        List<Zug> gespielteZuege;

        if(gibLetztenZug().getSpielstein() instanceof XSpielstein) {

            gespielteZuege = getXZuege();
        } else {

            gespielteZuege = getOZuege();
        }

        List<Position> gespieltePositionen = new ArrayList<>();
        for(Zug zug: gespielteZuege) {

            gespieltePositionen.add(zug.getFeld().getPosition());
        }

        return Spielstand.hatGewonnen(gespieltePositionen, spalten);
    }



    /**
     * Gibt den Spielstein an, der momentan gesetzt werden kann.
     *
     * @return Aktueller Spielstein
     */
    public static Spielstein gibAktuellenSpielstein() {

        if(gespielteZuege.size() > 0) {

            if(gibLetztenZug().getSpielstein() instanceof XSpielstein) {

                return new OSpielstein(context);
            } else {

                return new XSpielstein(context);
            }
        } else {

            return gibZufaelligenSpielstein();
        }
    }

    /**
     * Gibt den zu letzt gespielten Zug zurück.
     *
     * @return Letzter Zug
     */
    public static Zug gibLetztenZug() {

        return gespielteZuege.get(gespielteZuege.size() - 1);
    }

    /**
     * Wird am Anfang jedes Spiels benutzt, um zu ermitteln welcher
     * Spielstein anfängt.
     *
     * @return Gibt einen zufäligen Spielstein zurück
     */
    private static Spielstein gibZufaelligenSpielstein() {

        List<Spielstein> spielstein = new ArrayList<>();
        spielstein.add(new XSpielstein(context));
        spielstein.add(new OSpielstein(context));

        Random random = new Random();
        return spielstein.get(random.nextInt(2));
    }

    /** Gibt das Spielfeld zurück */
    public View spielfeld() {

        return xOSpielView;
    }

    /**
     * Startet das Spiel neu.
     *
     * @param context Kontext der aufrufenden Aktivität
     * @param spalten Spalten Anzahl des neuen Spiels
     * @param reihen Reihen Anzahl des neuen Spiels
     * @return Eine neue Spiel Referenz.
     */
    public static XOSpiel neuStarten(Context context, int spalten, int reihen) {

        XOSpiel.spalten = spalten;
        gespielteZuege = new ArrayList<>();
        xOSpielView.restart(spalten, reihen);
        return getInstance(context, spalten, reihen);
    }

    public static List<Zug> getGespielteZuege() {
        return gespielteZuege;
    }
}
