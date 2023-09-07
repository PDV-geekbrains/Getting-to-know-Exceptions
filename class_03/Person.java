package class_03;

/**
 * Класс используется для хранения персональных данных.
 */
public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private String birthday;
    private int phoneNumber;
    private char gender;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}
