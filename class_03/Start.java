package class_03;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        // #region Инициализация
        String dbPath = System.getProperty("user.dir") + "\\class_03\\database\\";

        Person person = new Person();

        DatabaseProvider provider = new DatabaseProvider(dbPath, person);
        // Для чтения с консоли - кодировка Cp866.
        Scanner scanner = new Scanner(System.in, "Cp866");

        PersonInfoReader reader = new PersonInfoReader(scanner);
        // #endregion Инициализация

        new Program(person, provider, reader, scanner).start();
    }
}
