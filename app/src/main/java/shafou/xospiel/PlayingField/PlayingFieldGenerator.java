package shafou.xospiel.PlayingField;

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

public interface PlayingFieldGenerator {

    ArrayList<Field> getPlayingFields();

    float getWidth();

    float getHeight();
}
