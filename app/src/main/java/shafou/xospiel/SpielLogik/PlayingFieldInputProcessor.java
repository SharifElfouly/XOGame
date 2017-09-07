package shafou.xospiel.SpielLogik;

import android.support.annotation.Nullable;

import java.util.List;

import shafou.xospiel.PlayingField.Field;
import shafou.xospiel.PlayingField.PlayingFieldGenerator;

/**
 *
 * This class represents a input processor of the playing field. Every management
 * of an interaction with the field should be implemented here.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 05.06.2017 ELF Class created.
 */

public final class PlayingFieldInputProcessor<T extends PlayingFieldGenerator> {

    /** Contains the fields of the playing field */
    private List<Field> playingFields;

    /** Breite des Spielfeldes */
    private float width;

    /** Höhe des Spielfeldes */
    private float height;

    /**
     * Creates a new Input Processor for a specific playing field generator.
     *
     * @param playingFieldGenerator Playing field generator
     */
    public PlayingFieldInputProcessor(T playingFieldGenerator) {

        this.playingFields = playingFieldGenerator.getPlayingFields();
        this.width = playingFieldGenerator.getWidth();
        this.height = playingFieldGenerator.getHeight();
    }

    /**
     * Checks if the position of the input is on the playing field at all.
     *
     * @param inputPosition position of the input
     * @return <code>true</code> if the input is on the field
     */
    public boolean isInputOnField(Position inputPosition) {

        return inputPosition.getXPosition() < width
                && inputPosition.getYPosition() < height
                && inputPosition.getXPosition() > 0
                && inputPosition.getYPosition() > 0;
    }

    /**
     * Calculates on which field of the playing field the input happened.
     *
     * @param inputPosition position of the input
     * @return One field of the playing field fields
     */
    @Nullable public Field getField(Position inputPosition) {

        /** Iterate over all fields */
        for(Field field: playingFields) {
            
            /** checks if the input is in the area of a field */
            if(inputPosition.getXPosition() >= field.getX1().getXPosition()
                    && inputPosition.getXPosition() <= field.getX2().getXPosition()
                    && inputPosition.getYPosition() >= field.getX1().getYPosition()
                    && inputPosition.getYPosition() <= field.getX4().getYPosition()) {

                return field;
            }
        }

        return null;
    }
}
