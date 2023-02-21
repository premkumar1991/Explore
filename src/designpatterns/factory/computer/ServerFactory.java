package designpatterns.factory.computer;

public class ServerFactory implements AbstractComputerFactory{
    int ram,hdd;
    public ServerFactory(int ram,int hdd){
        this.ram=ram;
        this.hdd=hdd;
    }

    @Override
    public ComputerFactory createComputer() {
        return new Server(ram,hdd);
    }
}
