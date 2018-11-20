import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProcessingEmployees {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Jason", "Red", 5000, "IT"),
            new Employee("Ashley", "Green", 7600, "IT"),
            new Employee("Matthew", "Indigo", 3587.5, "Sales"),
            new Employee("James", "Indigo", 4700.77, "Marketing"),
            new Employee("Luke", "Indigo", 6200, "IT"),
            new Employee("Jason", "Blue", 3200, "Sales"),
            new Employee("Wendy", "Brown", 4236.4, "Marketing")};

            List<Employee> listOfEmployees = new ArrayList<>(Arrays.asList(employees));

            System.out.println("Complete employees list:");
            listOfEmployees.stream().forEach(System.out::println);

            Predicate<Employee> fourTwoSixThousand = (e->(e.getSalary() >= 4000)
             && (e.getSalary() <= 6000));

            System.out.println("\n\nEmployees with salary between 4000 and 6000:");
            listOfEmployees.stream().filter(fourTwoSixThousand).sorted
            (Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

            // Display first Employee with salary in the range $4000-$6000
            System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
            listOfEmployees.stream().filter(fourTwoSixThousand).findFirst().get());

            // Functions for getting first and last names from an Employee
            Function<Employee, String> byFirstName = Employee::getFirstName;
            Function<Employee, String> byLastName = Employee::getLastName;

            // Comparator for comparing Employees by first name then last name
            Comparator<Employee> lastThenFirstName = Comparator.comparing(byLastName)
            .thenComparing(byFirstName);

            // sort employees by last name, then first name
            System.out.printf("%nEmployees in ascending order by last name then first:%n");
            listOfEmployees.stream().sorted(lastThenFirstName).forEach(
              System.out::println);

             // sort employees by descending order by last name, then first name
             System.out.printf("%nEmployees in descending order by last name then first:%n");
             listOfEmployees.stream().sorted(lastThenFirstName.reversed())
             .forEach(System.out::println);

             // display unique employee last names sorted
             System.out.printf("%nUnique employee last names:%n");
             listOfEmployees.stream().map(Employee::getLastName).distinct().sorted()
             .forEach(System.out::println);

            // display only first and last names
            System.out.printf("%nEmployee names in order by last name then first name:%n");
            listOfEmployees.stream().sorted(lastThenFirstName).map(Employee::getFullName)
            .forEach(System.out::println);

            // group Employees by department
            System.out.printf("%nEmployees by department:%n");
            Map<String, List<Employee>>employeesByDepartment = listOfEmployees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

            employeesByDepartment.forEach(
                (department, employeesInTheDepartment) ->
                {
                   System.out.println(department);
                   employeesInTheDepartment.forEach(
                       employee -> System.out.printf(" %s%n", employee)
                   );
                }
            );

            // count number of Employees in each department
            System.out.printf("%n Number of the employees in each department:%n");
            Map<String, Long> numberOfEmployeeByDepartment = listOfEmployees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors
            .counting()));

            numberOfEmployeeByDepartment.forEach(
                (department, count) -> System.out.printf("(%s, %d)%n", department, count)
            );

            // sum of Employee salaries with DoubleStream sum method
            System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
            listOfEmployees.stream().mapToDouble(Employee::getSalary).sum());

            // calculate sum of Employee salaries with Stream reduce method
            System.out.printf("Sum of Employees' salaries (via reduce method): %.2f%n",
            listOfEmployees.stream().mapToDouble(Employee::getSalary)
            .reduce(0, (salaryOne, salaryTwo) -> salaryOne + salaryTwo));

            // average of Employee salaries with DoubleStream average method
            System.out.printf("Average of Employees' salaries: %.2f%n",
            listOfEmployees.stream().mapToDouble(Employee::getSalary).average().getAsDouble());
    }
}