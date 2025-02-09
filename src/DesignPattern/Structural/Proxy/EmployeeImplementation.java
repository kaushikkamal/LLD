package DesignPattern.Structural.Proxy;

public class EmployeeImplementation implements EmployeeInterface {
    @Override
    public void create(String client, Employee employee) {
        System.out.println("Created new employee");
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("Deleted employee with employeeId: " + employeeId);
    }

    @Override
    public Employee get(String client, int employeeId) {
        System.out.println("Fetching employee from DB");
        return new Employee();
    }
}
