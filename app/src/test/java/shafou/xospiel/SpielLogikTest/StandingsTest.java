package shafou.xospiel.SpielLogikTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import shafou.xospiel.SpielLogik.Position;

import static com.google.common.truth.Truth.assertThat;
import static shafou.xospiel.SpielLogik.Standings.hasWon;

/**
 *
 * Diese Klasse testet die Standings Klasse
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 10.06.2017 ELF Klasse erstellt.
 */

public class StandingsTest {

    @Test
    public void HatGewonnen_Reihe_3ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(0, 0));
        zuege.add(new Position(0, 1));
        zuege.add(new Position(0, 2));

        assertThat(hasWon(zuege, 3)).isTrue();
    }

    @Test public void HatGewonnen_Spalte_3ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(1, 0));
        zuege.add(new Position(2, 0));
        zuege.add(new Position(3, 0));

        assertThat(hasWon(zuege, 3)).isTrue();
    }

    @Test public void HatGewonnen_DiagonaleRechts_3ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(4, 4));
        zuege.add(new Position(5, 5));
        zuege.add(new Position(6, 6));

        assertThat(hasWon(zuege, 3)).isTrue();
    }

    @Test public void HatGewonnen_DiagonaleLinks_3ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(14, 12));
        zuege.add(new Position(13, 13));
        zuege.add(new Position(12, 14));

        assertThat(hasWon(zuege, 3)).isTrue();
    }

    @Test
    public void HatGewonnen_Reihe_6ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(0, 0));
        zuege.add(new Position(0, 1));
        zuege.add(new Position(0, 2));

        assertThat(hasWon(zuege, 6)).isFalse();
    }

    @Test public void HatGewonnen_Spalte_6ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(1, 0));
        zuege.add(new Position(2, 0));
        zuege.add(new Position(3, 0));

        assertThat(hasWon(zuege, 6)).isFalse();
    }

    @Test public void HatGewonnen_DiagonaleRechts_6ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(4, 4));
        zuege.add(new Position(5, 5));
        zuege.add(new Position(6, 6));

        assertThat(hasWon(zuege, 6)).isFalse();
    }

    @Test public void HatGewonnen_DiagonaleLinks_6ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(14, 12));
        zuege.add(new Position(13, 13));
        zuege.add(new Position(12, 14));

        assertThat(hasWon(zuege, 6)).isFalse();
    }

    @Test
    public void HatGewonnen_Reihe_4ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(0, 0));
        zuege.add(new Position(3, 3));
        zuege.add(new Position(2, 1));
        zuege.add(new Position(1, 0));
        zuege.add(new Position(0, 1));
        zuege.add(new Position(0, 2));
        zuege.add(new Position(0, 3));

        assertThat(hasWon(zuege, 4)).isTrue();
    }

    @Test public void HatGewonnen_Spalte_4ZumSieg_Gewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(1, 1));
        zuege.add(new Position(1, 2));
        zuege.add(new Position(0, 0));
        zuege.add(new Position(1, 3));
        zuege.add(new Position(1, 4));

        assertThat(hasWon(zuege, 4)).isTrue();
    }

    @Test public void HatGewonnen_DiagonaleRechts_4ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(4, 4));
        zuege.add(new Position(5, 5));
        zuege.add(new Position(6, 6));
        zuege.add(new Position(1, 6));

        assertThat(hasWon(zuege, 4)).isFalse();
    }

    @Test public void HatGewonnen_DiagonaleLinks_4ZumSieg_NichtGewonnen() {

        List<Position> zuege = new ArrayList<>();
        zuege.add(new Position(14, 12));
        zuege.add(new Position(13, 13));
        zuege.add(new Position(0, 1));
        zuege.add(new Position(1, 1));
        zuege.add(new Position(12, 14));
        zuege.add(new Position(2, 1));

        assertThat(hasWon(zuege, 4)).isFalse();
    }
}
