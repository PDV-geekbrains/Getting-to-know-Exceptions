package class_03.exceptions;

/**
 * Генерируется для указания, что формат телефонного номера неправильный.
 */
public class PhoneFormatException extends Exception {
    private final String userInput;

    public String getUserInput() {
        return userInput;
    }

    public PhoneFormatException(String message, String userInput) {
        super(message);
        this.userInput = userInput;
    }
}
