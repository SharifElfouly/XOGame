package shafou.xospiel.PlayingField;

import java.util.ArrayList;
import java.util.List;

import shafou.xospiel.GameLogic.Position;

/**
 *
 * This class has methods to calculate positions and fields of a playing field.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Change log:
 * 1) 03.06.2017 ELF Class created.
 */

public final class FieldsCalculator {

    /**
     * Calculates from the given rows and columns all positions on the whole
     * field with a specific height and width.
     *
     * @param width Width of the whole field
     * @param height Height of the whole field
     * @param columns Columns on the field
     * @param rows Rows on the filed
     * @return List of all positions on the field
     */
    public static List<Position> getPositions(float width, float height, int columns, int rows) {

        /** Rows and columns must be positiv */
        if(columns <= 0 || rows <= 0) {

            throw new IllegalArgumentException("Rows and columns must be positiv");
        }

        /** List of the calculated positions */
        List<Position> positionen = new ArrayList<>();

        /** Iteration over all columns and rows */
        for(int r = 0; r <= rows; r++) {
            for(int s = 0; s <= columns; s++) {

                /** Calculation of the specific position */
                Position position
                        = new Position(((float) s / (float) columns) * width, ((float)r / (float)rows) * height);
                positionen.add(position);
            }
        }

        return positionen;
    }

    /**
     * Calculates all fields on the whole field from the positions calculated
     * {@link FieldsCalculator#getPositions(float, float, int, int)}.
     *
     * @param width Width of the whole field
     * @param height Height of the whole field
     * @param columns Columns on the field
     * @param rows Rows on the field
     * @return List of all fields in the whole field
     */
    public static List<Field> getFields(float width, float height, int columns, int rows) {

        /** Get all positions on the field */
        List<Position> positionen = getPositions(width, height, columns, rows);

        /** List of all fields in the whole field */
        List<Field> fields = new ArrayList<>();

        /** Keeps tracks of new rows */
        int newRow = 0;

        /** Holds the index of the current Column */
        int columnIndex = 1;

        /** Holds the index of the current Row */
        int rowIndex = 1;

        /** Iteration over all positions of the field */
        for(int i = 1; i <= (columns * rows); i++) {

            /** Calculates a field */
            Field field = new Field(
                    positionen.get(i + newRow - 1),
                    positionen.get(i + newRow),
                    positionen.get(i + newRow + columns + 1),
                    positionen.get(i + newRow + columns),
                    i);

            /** Is true if a new row is started */
            if(i % (columns) == 0) {

                newRow++;
            }

            /** Resets the column index */
            if(columnIndex > columns) {

                columnIndex = 1;
            }

            /** Sets the raltive position on the whole field */
            field.setPositionOnPlayingField(new Position(columnIndex, rowIndex));

            /** Is true if the end of a row is reached */
            if(columnIndex == columns) {

                rowIndex++;
            }

            columnIndex++;

            fields.add(field);
        }

        return fields;
    }
}
