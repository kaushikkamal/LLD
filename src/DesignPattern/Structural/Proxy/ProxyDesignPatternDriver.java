package DesignPattern.Structural.Proxy;

import DesignPattern.Structural.Proxy.Employee.Employee;
import DesignPattern.Structural.Proxy.Employee.EmployeeInterface;
import DesignPattern.Structural.Proxy.Employee.EmployeeProxy;

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
