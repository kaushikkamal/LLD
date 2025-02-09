package DesignPattern.Structural.Proxy.Employee;

public interface EmployeeInterface {
    void create(String client, Employee employee) throws Exception;

    void delete(String client, int employeeId) throws Exception;

    Employee get(String client, int employeeId) throws Exception;
}
