package test_04;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку символов: ");
        String userInput = scanner.nextLine();
        scanner.close();
        
        // Если строка ввода пустая - вывести предупреждение на консоль.
        if(userInput == "")
            throw new RuntimeException("Ошибка. Пустые строки вводить нельзя.");
        
        System.out.println("Вы ввели: " + userInput);
    }
}
