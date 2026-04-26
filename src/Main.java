public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        // Создаем 11 сотрудников
        Employee[] testEmployees = {
            new Employee("Иван Иванов", 1, 100),
            new Employee("Петр Петров", 2, 200),
            new Employee("Сидор Сидоров", 1, 120),
            new Employee("Анна Смирнова", 3, 300),
            new Employee("Елена Козлова", 2, 400),
            new Employee("Дмитрий Медведев", 4, 180),
            new Employee("Ольга Орлова", 5, 250),
            new Employee("Алексей Алексеев", 1, 90),
            new Employee("Мария Федорова", 3, 320),
            new Employee("Виктор Лебедев", 2, 150),
            new Employee("Татьяна Волкова", 4, 380)
        };

        // Добавляем в книгу
        for (Employee emp : testEmployees) {
            boolean added = book.addEmployee(emp);
            System.out.println("Сотрудник " + emp.getFullName() + " добавлен: " + added);
        }

        // Попытка добавить 11-го — должно быть false
        Employee extra = new Employee("Лишний Сотрудник", 1, 200);
        System.out.println("Добавление 11-го: " + book.addEmployee(extra));

        System.out.println("\n--- Все сотрудники ---");
        book.printAllEmployees();

        System.out.println("\n--- Средняя зарплата: " + String.format("%.2f", book.calculateAverageSalary()));

        System.out.println("\n--- Налоги (пропорциональные) ---");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n--- Налоги (прогрессивные) ---");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n--- Индексация зарплат отдела 1 на 10% ---");
        book.indexSalariesByDepartment(1, 10);
        book.printAllEmployees();

        System.out.println("\n--- Первый сотрудник в отделе 2 с зарплатой > 190 ---");
        book.findFirstEmployeeInDepartmentWithHigherSalary(2, 190);

        System.out.println("\n--- Первые 3 сотрудника с зарплатой < 200 ---");
        book.findFirstNEmployeesWithLowerSalary(200, 3);

        System.out.println("\n--- Проверка наличия сотрудника с зарплатой 200 ---");
        Employee sample = new Employee("Шаблон", 1, 200);
        System.out.println("Сотрудник с такой зарплатой есть: " + book.containsEmployee(sample));

        System.out.println("\n--- Получение сотрудника по ID=3 ---");
        Employee found = book.getEmployeeById(3);
        if (found != null) {
            found.printShortInfo();
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }
}