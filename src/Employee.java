public class Employee {
    private static int nextId = 1;

    private final int id;
    private String fullName;
    private int department;
    private double salary;

    // Конструктор
    public Employee(String fullName, int department, double salary) {
        this.id = nextId++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Переопределение equals — по зарплате (по условию бухгалтерии)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0;
    }

    // toString — вывод всех данных
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    // Вывод краткой информации: имя и зарплата
    public void printShortInfo() {
        System.out.println("Имя: " + fullName + ", Зарплата: " + salary);
    }
}
