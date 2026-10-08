import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + "): $" + salary;
    }
}

public class EmployeeAnalytics {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000),
            new Employee("Bob", "HR", 50000),
            new Employee("Charlie", "IT", 90000),
            new Employee("David", "Finance", 65000),
            new Employee("Eva", "HR", 55000)
        );

        // 1. Filter: IT department employees with salary > 70,000
        System.out.println("--- IT Employees with High Salary ---");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT") && e.getSalary() > 70000)
                .forEach(System.out::println);

        // 2. Sort: Employees by salary in descending order
        System.out.println("\n--- Sorted by Salary (Descending) ---");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // 3. Group: Employees by Department
        System.out.println("\n--- Grouped by Department ---");
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        byDept.forEach((dept, list) -> System.out.println(dept + ": " + list));

        // 4. Summarize: Average salary across all employees
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage Salary: $" + avgSalary);
    }
}
