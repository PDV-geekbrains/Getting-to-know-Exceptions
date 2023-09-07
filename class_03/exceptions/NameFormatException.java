package class_03.exceptions;

/**
 * Генерируется для указания, что формат имени неправильный.
 */
public class NameFormatException extends Exception {
    private final String userInput;

    public String getUserInput() {
        return userInput;
    }

    public NameFormatException(String message, String userInput) {
        super(message);
        this.userInput = userInput;
    }

}
