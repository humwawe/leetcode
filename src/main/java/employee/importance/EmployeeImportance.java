package employee.importance;

import java.util.List;

/**
 * @author hum
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Employee e = null;
        for (Employee employee : employees) {
            if (employee.id == id) {
                result = employee.importance;
                e = employee;
            }
        }
        if (e == null) {
            return result;
        }
        for (Integer subordinate : e.subordinates) {
            result += getImportance(employees, subordinate);
        }
        return result;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
