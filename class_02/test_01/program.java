package test_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        float userInput = getUserInput();
        System.out.println(userInput);
    }

    /**
     * Метод читает с консоли дробное число.
     * @return число, считанное с консоли.
     */
    private static float getUserInput() {
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);
        float result = 0;
        
        while (!isValid) {
            try {
                System.out.print("Введите дробное число: ");
                result = scanner.nextFloat();
                isValid = true;
            } catch (InputMismatchException e) {
                isValid = false;
                System.out.println("Ошибка. Введён неправильный формат данных.");
                scanner.nextLine();
            }
        }
        scanner.close();
        return result;
    }
}
