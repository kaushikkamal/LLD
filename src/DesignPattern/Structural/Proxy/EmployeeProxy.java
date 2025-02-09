package DesignPattern.Structural.Proxy;

public class EmployeeProxy implements EmployeeInterface {
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";
    EmployeeInterface employeeInterface;

    public EmployeeProxy() {
        this.employeeInterface = new EmployeeImplementation();
    }

    @Override
    public void create(String client, Employee employee) throws Exception {
        if (client.equals(ROLE_ADMIN)) {
            this.employeeInterface.create(client, employee);
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if (client.equals(ROLE_ADMIN)) {
            this.employeeInterface.delete(client, employeeId);
        }
        throw new Exception("Access Denied");
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        if (client.equals(ROLE_ADMIN) || client.equals(ROLE_USER)) {
            return this.employeeInterface.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
