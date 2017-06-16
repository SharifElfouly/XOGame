package shafou.xospiel.Exceptions;

/**
 *
 * Diese Klasse bildet eine Exception dar, die ausgelöst wird, wenn versucht
 * wird ein Token auf ein bereits besetztes Field zu spielen.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public class FieldIsOccupiedException extends Exception {

    public FieldIsOccupiedException(String feldIstBesetztText) {
        super(feldIstBesetztText);
    }
}
