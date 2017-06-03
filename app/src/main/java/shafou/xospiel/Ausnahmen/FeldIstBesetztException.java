package shafou.xospiel.Ausnahmen;

/**
 *
 * Diese Klasse bildet eine Exception dar, die ausgelöst wird, wenn versucht
 * wird Spielstein auf ein bereits besetztes Feld zu spielen.
 *
 * @author Sharif Elfouly
 * @version 1.0
 *
 * Änderungshistorie:
 * 1) 23.05.2017 ELF Klasse erstellt.
 */

public class FeldIstBesetztException extends Exception {

    public FeldIstBesetztException(String feldIstBesetztText) {
        super(feldIstBesetztText);
    }
}
