package class_03;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import class_03.exceptions.BirthdayFormatException;
import class_03.exceptions.GenderFormatException;
import class_03.exceptions.MenuItemOutOfRangeException;
import class_03.exceptions.NameFormatException;
import class_03.exceptions.PhoneFormatException;

public class Program {
    private final Person person;
    private final DatabaseProvider provider;
    private final PersonInfoReader reader;
    private final Scanner scanner;

    /**
     * Конструктор.
     * 
     * @param person   используется для хранения персональных данных.
     * @param scanner  читает с консоли.
     * @param provider содержит методы для записи в файл/ чтения из файла.
     */
    public Program(Person person,
            DatabaseProvider provider,
            PersonInfoReader reader,
            Scanner scanner) {
        this.person = person;
        this.provider = provider;
        this.reader = reader;
        this.scanner = scanner;
    }

    /**
     * Точка входа в программу.
     */
    public void start() {
        int menuItem = 0;

        while (menuItem != 1) {
            showMenu();
            menuItem = getMenuItem();
            switch (menuItem) {
                case 2: // Ввод персональных данных.
                    getPersonInfo();
                    printNewPersonInfo();
                    break;
                case 3: // Сохранение введённых персональных данных.
                    this.provider.save();
                    break;
                case 4: // Вывод на консоль всех персональных данных.
                    this.provider.printAllDatabase();
            }
        }
    }

    /**
     * Метод выводит меню на консоль.
     */
    private void showMenu() {
        StringBuilder menu = new StringBuilder()
                .append("\n=== Меню ===\n")
                .append("1. Выход\n")
                .append("2. Ввод персональных данных\n")
                .append("3. Сохранить\n")
                .append("4. Печать\n");
        System.out.println(menu.toString());
    }

    /**
     * Метод читает с консоли номер меню введённый пользователем.
     * 
     * @return номер меню.
     */
    private int getMenuItem() {
        int userInput = -1;
        System.out.print("Введите пункт меню: ");
        try {
            userInput = this.scanner.nextInt();
            this.scanner.nextLine(); // Удалить из буфера сканера остаток строки.
            if (userInput < 1 || userInput > 4) {
                throw new MenuItemOutOfRangeException(
                        "Ошибка. Меню не содержит такого пункта.",
                        Integer.toString(userInput));
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка. Введите корректный номер.");
        } catch (MenuItemOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
        return userInput;
    }

    /**
     * Метод читает с консоли персональные данные.
     */
    private void getPersonInfo() {
        getPersonFirstName();
        getPersonSecondName();
        getPersonLastName();
        getPersonBirthday();
        getPersonPhoneNumber();
        getPersonGender();
    }

    /**
     * Метод получает имя персоны.
     */
    private void getPersonFirstName() {
        boolean isValid = false;
        do {
            try {
                this.person.setFirstName(this.reader.getName('f'));
                isValid = true;
            } catch (NameFormatException e) {
                System.out.println(e.getMessage() + " Имя вводится в кириллице, не может " +
                        "быть пустым и должно содержать только буквы. Первая буква прописная, " +
                        "остальные строчные. Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод получает отчество персоны.
     */
    private void getPersonSecondName() {
        boolean isValid = false;
        do {
            try {
                this.person.setSecondName(this.reader.getName('s'));
                isValid = true;
            } catch (NameFormatException e) {
                System.out.println(e.getMessage() + " Отчество вводится в кириллице, не может " +
                        "быть пустым и должно содержать только буквы. Первая буква прописная, " +
                        "остальные строчные. Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод получает фамилию персоны.
     */
    private void getPersonLastName() {
        boolean isValid = false;
        do {
            try {
                this.person.setLastName(this.reader.getName('l'));
                isValid = true;
            } catch (NameFormatException e) {
                System.out.println(e.getMessage() + " Фамилия вводится в кириллице, не может " +
                        "быть пустой и должна содержать только буквы. Первая буква прописная, " +
                        "остальные строчные. Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод получает день рождения.
     */
    private void getPersonBirthday() {
        boolean isValid = false;
        do {
            try {
                this.person.setBirthday(this.reader.getBirthday());
                isValid = true;
            } catch (BirthdayFormatException e) {
                System.out.println(e.getMessage() + " Формат даты dd.mm.yyyy." +
                        " Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод получает телефонный номер.
     */
    private void getPersonPhoneNumber() {
        boolean isValid = false;
        do {
            try {
                this.person.setPhoneNumber(this.reader.getPhoneNumber());
                isValid = true;
            } catch (PhoneFormatException e) {
                System.out.println(e.getMessage() + " Формат телефонного номера - 4 цифры." +
                        "Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод получает обозначение гендера.
     */
    private void getPersonGender() {
        boolean isValid = false;
        do {
            try {
                this.person.setGender(this.reader.getGender());
                isValid = true;
            } catch (GenderFormatException e) {
                System.out.println(e.getMessage() + " Формат обозначения: 'm' - мужской, " +
                        "'f' - женский. Вы ввели: " + e.getUserInput());
            }
        } while (!isValid);
    }

    /**
     * Метод выводит на консоль текущую информацию о персоне.
     */
    private void printNewPersonInfo() {
        StringBuffer text = new StringBuffer()
                .append("\n=== Были введены персональные данные ===\n")
                .append("Имя:\t\t" + this.person.getFirstName() + "\n")
                .append("Отчество:\t" + this.person.getSecondName() + "\n")
                .append("Фамилия:\t" + this.person.getLastName() + "\n")
                .append("Дата рождения:\t" + this.person.getBirthday() + "\n")
                .append("Телефон:\t" + this.person.getPhoneNumber() + "\n")
                .append("Пол:\t\t" + this.person.getGender() + "\n");
        System.out.print(text);
    }
}
