package class_03.exceptions;

/**
 * Генерируется для указания, что формат даты рождения неправильный.
 */
public class BirthdayFormatException extends Exception {
    private final String userInput;

    public String getUserInput() {
        return userInput;
    }

    public BirthdayFormatException(String message, String userInput) {
        super(message);
        this.userInput = userInput;
    }
}
