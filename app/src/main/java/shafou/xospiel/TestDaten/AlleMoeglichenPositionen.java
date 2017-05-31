package shafou.xospiel.TestDaten;

import java.util.ArrayList;

import shafou.xospiel.SpielLogik.Position;

/**
 * 
 * Diese Klasse enthält alle möglichen Positionen die gespielt werden können.
 *  
 * @author Sharif Elfouly
 * @version 1.0
 * 
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public class AlleMoeglichenPositionen {
    
    protected static Position position1_1 = new Position(1, 1);
    protected static Position position2_1 = new Position(2, 1);
    protected static Position position3_1 = new Position(3, 1);
    protected static Position position1_2 = new Position(1, 2);
    protected static Position position2_2 = new Position(2, 2);
    protected static Position position3_2 = new Position(3, 2);
    protected static Position position1_3 = new Position(1, 3);
    protected static Position position2_3 = new Position(2, 3);
    protected static Position position3_3 = new Position(3, 3);

    public static ArrayList<Position> spielGewonnenSequenz1 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz2 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz3 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz4 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz5 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz6 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz7 = new ArrayList<>();
    public static ArrayList<Position> spielGewonnenSequenz8 = new ArrayList<>();

    public static ArrayList<ArrayList<Position>> alleGewinnSequenzen
            = new ArrayList<>();

    static {
        spielGewonnenSequenz1.add(position1_1);
        spielGewonnenSequenz1.add(position2_2);
        spielGewonnenSequenz1.add(position3_3);

        spielGewonnenSequenz2.add(position1_1);
        spielGewonnenSequenz2.add(position1_2);
        spielGewonnenSequenz2.add(position1_3);

        spielGewonnenSequenz3.add(position2_1);
        spielGewonnenSequenz3.add(position2_2);
        spielGewonnenSequenz3.add(position2_3);

        spielGewonnenSequenz4.add(position3_1);
        spielGewonnenSequenz4.add(position3_2);
        spielGewonnenSequenz4.add(position3_3);

        spielGewonnenSequenz5.add(position1_1);
        spielGewonnenSequenz5.add(position2_1);
        spielGewonnenSequenz5.add(position3_1);

        spielGewonnenSequenz6.add(position1_2);
        spielGewonnenSequenz6.add(position2_2);
        spielGewonnenSequenz6.add(position3_2);

        spielGewonnenSequenz7.add(position1_3);
        spielGewonnenSequenz7.add(position2_3);
        spielGewonnenSequenz7.add(position3_3);

        spielGewonnenSequenz8.add(position1_3);
        spielGewonnenSequenz8.add(position2_2);
        spielGewonnenSequenz8.add(position3_1);

        alleGewinnSequenzen.add(spielGewonnenSequenz1);
        alleGewinnSequenzen.add(spielGewonnenSequenz2);
        alleGewinnSequenzen.add(spielGewonnenSequenz3);
        alleGewinnSequenzen.add(spielGewonnenSequenz4);
        alleGewinnSequenzen.add(spielGewonnenSequenz5);
        alleGewinnSequenzen.add(spielGewonnenSequenz6);
        alleGewinnSequenzen.add(spielGewonnenSequenz7);
        alleGewinnSequenzen.add(spielGewonnenSequenz8);
    }
}
