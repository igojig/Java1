package lesson5.data;

public class Employee {
    private final FullName fullName;
    private final Position position;
    private final String email;
    private final String phoneNumber;
    private final int salary;
    private final int age;

    public Employee(String surname, String name, String patronymic, Position position, String email, String phoneNumber, int salary, int age) {
        this.fullName = new FullName(name, surname, patronymic);
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName.toString();
    }

    public String getPosition() {
        return position.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                fullName +
                position +
                ", email='" + email + '\'' +
                ", телефон='" + phoneNumber + '\'' +
//                ", зарплата=" + salary +
                String.format(", зарплата=%,d", salary) +
                ", возраст=" + age +
                '}';
    }
}
