// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final Employee[] employees = {
            new Employee("Иванов Иван Иванович", 10_000, 1),
            new Employee("Семёнов Семён Семёнович", 20_000, 2),
            new Employee("Петров Пётр Петрович", 30_000, 3),
            new Employee("Сидоров Сидр Сидорович", 40_000, 2),
            new Employee("Михаилов Михаил Михаилович", 60_000, 3),
            new Employee("Даниило Даниил Даниилович", 50_000, 1),
            new Employee("Андреев Андрей Андреевич", 40_000, 4),
            new Employee("Тимуров Тимур Тимурович", 30_000, 5),
            new Employee("Григорьев Григорий Григорьевич", 20_000, 4),
            new Employee("Дмитриев Дмитрий Дмитриевич", 5_000, 5),
    };
    public static void main(String[] args) {
        printEmployees();
        System.out.println("=======================");
        System.out.println("Сумма всех затрат: "+ calculateTotalSalary());
        System.out.println("=======================");

        System.out.println("Сотрудник с минимальной зарплатой : " + findEmployeeWitchMinimumSalary());
        System.out.println("=======================");
        System.out.println("Сотрудник с максимальной зарплатой : " + findEmployeeWitchMaximumSalary());
        System.out.println("=======================");
        System.out.println("Средняя зарплата : " + calculateAverageSalary());
        System.out.println("=======================");
        printFullNames();
    }

    public static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int calculateTotalSalary() {
        int salarySum = 0;
        for (Employee employee : employees) {
            salarySum += employee.getSalary();
        }

        return salarySum;
    }

    public static Employee findEmployeeWitchMinimumSalary() {
        Employee employeeWithMinumumSalary = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinumumSalary.getSalary()) {
                employeeWithMinumumSalary = employee;
            }
        }

        return employeeWithMinumumSalary;
    }
    public static Employee findEmployeeWitchMaximumSalary() {
        Employee employeeWithMaximumSalary = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaximumSalary.getSalary()) {
                employeeWithMaximumSalary = employee;
            }
        }

        return employeeWithMaximumSalary;
    }

    public static float calculateAverageSalary() {
        return calculateTotalSalary() / (float) employees.length;
    }

    public static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }


}