package lesson5;

import lesson5.data.Employee;
import lesson5.data.Position;

import java.util.ArrayList;
import java.util.List;

public class Lesson5 {
    public static void main(String[] args) {
        array();
        System.out.println();
        arrayList();
    }

    private static void arrayList() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Иванов", "Петр", "Иванович",
                Position.DIRECTOR, "ivanov@mail.ru", "805-347-45-23", 50_000, 67));
        employeeList.add(new Employee("Смирнов", "Иван", "Федорович",
                Position.ACCAUNTANT, "smirnoff_23@yandex.ru", "911-356-12-08", 20_000, 44));
        employeeList.add(new Employee("Сидоров", "Николай", "Егорович",
                Position.DRIVER, "sid_nik@gmail.com", "802-954-13-21", 30_000, 34));
        employeeList.add(new Employee("Хмельницкая", "Яна", "Петровна",
                Position.PROGRAMMER, "yanpetr@mail.ru", "905-856-39-23", 80_000, 32));
        employeeList.add(new Employee("Соколова", "Ольга", "Игоревна",
                Position.MANAGER, "sok_ig@yandex.ru", "923-344-16-47", 60_000, 46));

        employeeList.stream()
                .filter(emp -> emp.getAge() > 40)
                .forEach(System.out::println);
    }

    private static void array() {
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Иванов", "Петр", "Иванович",
                Position.DIRECTOR, "ivanov@mail.ru", "805-347-45-23", 50_000, 67);
        employeeArray[1] = new Employee("Смирнов", "Иван", "Федорович",
                Position.ACCAUNTANT, "smirnoff_23@yandex.ru", "911-356-12-08", 20_000, 44);
        employeeArray[2] = new Employee("Сидоров", "Николай", "Егорович",
                Position.DRIVER, "sid_nik@gmail.com", "802-954-13-21", 30_000, 34);
        employeeArray[3] = new Employee("Хмельницкая", "Яна", "Петровна",
                Position.PROGRAMMER, "yanpetr@mail.ru", "905-856-39-23", 80_000, 32);
        employeeArray[4] = new Employee("Соколова", "Ольга", "Игоревна",
                Position.MANAGER, "sok_ig@yandex.ru", "923-344-16-47", 60_000, 46);

        for (Employee emp : employeeArray) {
            if (emp.getAge() > 40) {
                System.out.println(emp);
            }
        }
    }
}
