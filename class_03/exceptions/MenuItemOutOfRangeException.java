package class_03.exceptions;

/**
 * Генерируется для указания, что номер пункта меню находится вне диапазона.
 */
public class MenuItemOutOfRangeException extends Exception {
    private final String userInput;

    public String getUserInput() {
        return userInput;
    }

    public MenuItemOutOfRangeException(String message, String userInput) {
        super(message);
        this.userInput = userInput;
    }
}
