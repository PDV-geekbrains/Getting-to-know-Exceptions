package class_03;

import java.util.Scanner;
import java.util.regex.Pattern;

import class_03.exceptions.*;

/**
 * Класс содержит методы для считывания с консоли персональных данных.
 */
public class PersonInfoReader {
    private final Scanner scanner;

    public PersonInfoReader(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Метод читает с консоли имя или отчество или фамилию.
     * Шрифт строки: кириллица. Строка не может быть пустой и должна содержать
     * только буквы. Первая буква прописная, остальные строчные.
     * 
     * @param flag    'f' - читать имя, 's' - читать отчество, 'l' - читать фамилию.
     * @param scanner сканер текста с консоли.
     * @return имя или отчество или фамилия.
     * @throws WrongNameFormatException неправильный формат строки.
     */
    public String getName(char flag) throws NameFormatException {
        String userInput = "";
        String template = "[А-ЯЁ][а-яё]+";
        switch (flag) {
            case 'f':
                System.out.print("Введите имя: ");
                break;
            case 's':
                System.out.print("Введите отчество: ");
                break;
            case 'l':
                System.out.print("Введите фамилию: ");
        }
        userInput = scanner.nextLine().replaceAll("\n", "");

        // Проверить ввод пользователя на соответствие формату.
        if (!Pattern.matches(template, userInput))
            throw new NameFormatException(
                    "Ошибка. Неправильный формат строки.",
                    userInput);
        return userInput;
    }

    /**
     * Метод читает с консоли дату рождения. Формат даты dd.mm.yyyy.
     * 
     * @return дата рождения.
     * @throws BirthdayFormatException неправильный формат даты рождения.
     */
    public String getBirthday() throws BirthdayFormatException {
        String userInput = "";
        String template = "\\d{2}\\.\\d{2}\\.\\d{4}"; // dd.dd.dddd
        System.out.print("Введите дату рождения в формате dd.mm.yyyy: ");
        userInput = scanner.nextLine().replaceAll("\n", "");
        // Проверка ввода на соответствие ввода формату.
        if (!Pattern.matches(template, userInput))
            throw new BirthdayFormatException(
                    "Ошибка. Неправильный формат даты рождения.",
                    userInput);
        return userInput;
    }

    /**
     * Метод читает с консоли телефонный номер. Формат номера dddd.
     * 
     * @return телефонный номер.
     * @throws PhoneFormatException неправильный формат телефонного номера.
     */
    public int getPhoneNumber() throws PhoneFormatException {
        String userInput = "";
        String template = "\\d{4}";
        System.out.print("Введите 4-значный номер телефона: ");
        userInput = scanner.nextLine().replaceAll("\n", "");
        // Проверка на соответствие ввода формату.
        if (!Pattern.matches(template, userInput))
            throw new PhoneFormatException(
                    "Ошибка. Неправильный формат телефонного номера.",
                    userInput);
        return Integer.parseInt(userInput);
    }

    /**
     * Метод читает с консоли обозначение гендера. Обозначение: 'm' - мужчина,
     * 'f' - женщина.
     * 
     * @return обозначение гендера.
     * @throws GenderFormatException неправильный формат обозначения гендера.
     */
    public char getGender() throws GenderFormatException {
        String userInput = "";
        String template = "[f,m]";
        System.out.print("Введите пол. Мужской - 'm', женский - 'f': ");
        userInput = scanner.nextLine().replaceAll("\n", "");
        if (!Pattern.matches(template, userInput))
            throw new GenderFormatException(
                    "Ошибка. Неправильный формат обозначения гендера.",
                    userInput);
        return userInput.charAt(0);
    }
}
