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
        System.out.println("=======================");

        increaseSalary(30);
        printEmployees();
        System.out.println("=======================");

        System.out.println("Сотрудник с минимальной зарплатой в отделе 3: " + findEmployeeWitchMinimumSalaryByDepartment(3));
        System.out.println("=======================");

        System.out.println("Сотрудник с максимальной зарплатой в отделе 3 : " + findEmployeeWitchMaximumSalaryByDepartment(3));
        System.out.println("=======================");

        System.out.println("Сумма всех затрат в отделе 4: "+ calculateTotalSalaryByDepartment(4));
        System.out.println("=======================");

        System.out.println("Седняя сумма всех затрат в отделе 4: "+ calculateAverageSalaryByDepartment(4));
        System.out.println("=======================");

        increaseSalaryByDepartment(40,2);
        printEmployeesByDeportment(2);
        System.out.println("=======================");

        printEmployeesWithLessSalaryThan(50_000);
        System.out.println("=======================");
        printEmployeesWithMoreSalaryThan(50_000);
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

    public static void increaseSalary(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }

    public static Employee findEmployeeWitchMinimumSalaryByDepartment(int departmentId) {
        int minSalary = Integer.MAX_VALUE;
        Employee employeeWithMinumumSalary = null;

        for (Employee employee : employees) {
            if (employee.getDepartmentId() != departmentId) {
                continue;
            }
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinumumSalary = employee;
            }
        }

        return employeeWithMinumumSalary;
    }
    public static Employee findEmployeeWitchMaximumSalaryByDepartment(int departmentId) {
        int maxSalary = Integer.MIN_VALUE;
        Employee employeeWithMaximumSalary = null;

        for (Employee employee : employees) {
            if (employee.getDepartmentId() != departmentId) {
                continue;
            }
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaximumSalary = employee;
            }
        }

        return employeeWithMaximumSalary;
    }
    public static int calculateTotalSalaryByDepartment(int departmentId) {
        int salarySum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                salarySum += employee.getSalary();
            }
        }
        return salarySum;
    }
    public static float calculateAverageSalaryByDepartment(int departmentId) {
        int salarySum = 0;
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                salarySum += employee.getSalary();
                employeesCount++;
            }
        }
        return salarySum/ (float) employeesCount;
    }
    public static void increaseSalaryByDepartment(int percent,int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (percent / 100f + 1)));

            }
        }
    }

    public static void printEmployeesByDeportment(int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                System.out.println(employee.getEmployeeInfoWithoutDepartment());
            }
        }
    }

    public static void printEmployeesWithLessSalaryThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.getEmployeeInfoWithoutDepartment());
            }
        }
    }

    public static void printEmployeesWithMoreSalaryThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getEmployeeInfoWithoutDepartment());
            }
        }
    }


}