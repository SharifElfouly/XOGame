package shafou.xospiel.Spielfeld;

import java.util.ArrayList;

/**
 *
 * Dieses Interface gibt an welche Methoden ein Spielfeld Generator
 * implementieren muss.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 06.05.2017 ELF Interface erstellt.
 */

public interface SpielfeldGenerator {

    ArrayList<Feld> getSpielfeldFelder();

    float getBreite();

    float getHoehe();
}
