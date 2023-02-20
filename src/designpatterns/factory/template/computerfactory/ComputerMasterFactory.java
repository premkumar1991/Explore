package designpatterns.factory.template.computerfactory;

public class ComputerMasterFactory {
    public static ComputerFactory getComputer(AbstractComputerFactory abstractComputerFactory){
        return abstractComputerFactory.createComputer();
    }
}
