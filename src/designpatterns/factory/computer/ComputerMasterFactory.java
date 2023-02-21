package designpatterns.factory.computer;

public class ComputerMasterFactory {
    public static ComputerFactory getComputer(AbstractComputerFactory abstractComputerFactory){
        return abstractComputerFactory.createComputer();
    }
}
