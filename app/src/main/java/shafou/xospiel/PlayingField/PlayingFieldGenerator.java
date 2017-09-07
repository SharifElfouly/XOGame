package shafou.xospiel.PlayingField;

import java.util.List;

/**
 *
 * This interface must be implemented for all playing field generators.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 06.05.2017 ELF Interface created.
 */

public interface PlayingFieldGenerator {

    /**
     * Calculates all fields on a playing field.
     *
     * @return List of fields
     */
    List<Field> getPlayingFields();

    /**
     * Returns the width of the playing field
     *
     * @return Width of the playing field
     */
    float getWidth();

    /**
     * Returns the height of the playing field
     *
     * @return Height of the playing field
     */
    float getHeight();
}
