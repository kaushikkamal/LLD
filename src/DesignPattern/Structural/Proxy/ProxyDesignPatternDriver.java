package DesignPattern.Structural.Proxy;

public class ProxyDesignPatternDriver {
    public static void execute() {
        try {
            EmployeeInterface employeeInterface = new EmployeeProxy();
            employeeInterface.create("USER", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
