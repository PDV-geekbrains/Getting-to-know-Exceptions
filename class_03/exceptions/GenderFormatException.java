package class_03.exceptions;

/**
 * Генерируется для указания, что формат обозначения гендера неправильный.
 */
public class GenderFormatException extends Exception {
    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public GenderFormatException(String message, String userInput) {
        super(message);
        this.userInput = userInput;
    }
}
