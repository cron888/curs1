public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    // 1. Вывести всех сотрудников
    public void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.toString());
            }
        }
    }

    // 2. Подсчитать среднюю зарплату
    public double calculateAverageSalary() {
        int count = 0;
        double sum = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                sum += emp.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    // 3. Вывести налоги (PROPORTIONAL или PROGRESSIVE)
    public void printTaxes(String taxScheme) {
        for (Employee emp : employees) {
            if (emp == null) continue;

            double salary = emp.getSalary();
            double tax = 0;

            switch (taxScheme.toUpperCase()) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary < 150) {
                        tax = salary * 0.13;
                    } else if (salary < 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
                    break;
                default:
                    System.out.println("Неизвестная схема налогообложения: " + taxScheme);
                    continue;
            }
            System.out.println("Сотрудник: " + emp.getFullName() +
                    ", Зарплата: " + salary +
                    ", Налог: " + String.format("%.2f", tax));
        }
    }

    // 4. Проиндексировать зарплату по отделу
    public void indexSalariesByDepartment(int department, double percent) {
        double factor = 1 + percent / 100.0;
        for (Employee emp : employees) {
            if (emp == null) continue;
            if (emp.getDepartment() != department) continue;
            emp.setSalary(emp.getSalary() * factor);
        }
    }

    // 5. Найти первого сотрудника в отделе с зарплатой > указанной
    public void findFirstEmployeeInDepartmentWithHigherSalary(int department, double wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp == null) continue;
            if (emp.getDepartment() == department && emp.getSalary() > wage) {
                System.out.println("Найден сотрудник под индексом " + i + ":");
                emp.printShortInfo();
                break;
            }
        }
    }

    // 6. Найти первые N сотрудников с зарплатой < указанной
    public void findFirstNEmployeesWithLowerSalary(double wage, int employeeNumber) {
        int found = 0;
        int i = 0;
        while (i < employees.length && found < employeeNumber) {
            Employee emp = employees[i];
            if (emp != null && emp.getSalary() < wage) {
                System.out.println("Сотрудник #" + (found + 1) + ":");
                emp.printShortInfo();
                found++;
            }
            i++;
            if (found >= employeeNumber) break;
        }
    }

    // 7. Проверить наличие сотрудника (по зарплате через equals)
    public boolean containsEmployee(Employee target) {
        for (Employee emp : employees) {
            if (emp != null && emp.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // 8. Добавить нового сотрудника (в первую свободную ячейку)
    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    // 9. Получить сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}
