package designpatterns.factory.template.computerfactory;

public class Client {
    public static void main(String[] a){
        AbstractComputerFactory pcFactory=new PCFactory(8,512);
        ComputerMasterFactory.getComputer(pcFactory).getComputer();
        AbstractComputerFactory serverFactory=new PCFactory(16,1024);
        ComputerMasterFactory.getComputer(serverFactory).getComputer();
    }
}
