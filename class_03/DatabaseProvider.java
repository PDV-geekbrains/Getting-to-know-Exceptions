package class_03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит методы для записи в файл/ чтения из файла.
 * Однофамильцы записываются в один и тот же файл, в отдельные строки.
 */
public class DatabaseProvider {
    private final String dbPath;
    private final Person person;

    public DatabaseProvider(String dbPath, Person person) {
        this.dbPath = dbPath;
        this.person = person;
    }

    /**
     * Метод сохраняет поля person в файл.
     */
    public void save() {
        String record = getRecord();
        File output = new File(this.dbPath + this.person.getLastName() + ".txt");

        try (FileWriter writer = new FileWriter(
                output,
                StandardCharsets.UTF_16,
                true)) {
            writer.write(record + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Выводит на консоль все записи из базы данных.
     */
    public void printAllDatabase() {
        File folder = new File(dbPath);
        for (File file : folder.listFiles()) {
            printAllRecordsFromFile(Paths.get(file.getAbsolutePath()));
        }
    }

    /**
     * Метод выводит персональные данные из файла на консоль.
     * 
     * @param path путь к файлу.
     */
    public void printAllRecordsFromFile(Path path) {
        List<String> lines = new LinkedList<String>();
        // Читаем весь файл.
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_16);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Построчно выводим записи на консоль.
        for (String line : lines) {
            Matcher m = Pattern.compile("<(.+?)>").matcher(line);
            while (m.find()) {
                System.out.print(m.group(1) + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * Метод формирует строку для записи в файл.
     * 
     * @return строка для записи в файл.
     */
    private String getRecord() {
        StringBuilder record = new StringBuilder()
                .append("<" + this.person.getFirstName() + ">")
                .append("<" + this.person.getSecondName() + ">")
                .append("<" + this.person.getLastName() + ">")
                .append("<" + this.person.getBirthday() + ">")
                .append("<" + this.person.getPhoneNumber() + ">")
                .append("<" + this.person.getGender() + ">");
        return record.toString();
    }

}
