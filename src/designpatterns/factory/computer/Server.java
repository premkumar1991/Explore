package designpatterns.factory.computer;

public class Server implements ComputerFactory{
    private int ram,hdd;
    public Server(int ram,int hdd){
        this.ram=ram;
        this.hdd=hdd;
    }

    @Override
    public void getComputer() {
        System.out.println("Server created with ram: "+ram +" hdd: "+hdd);
    }
}
