package designpatterns.factory.computer;

public class PC implements ComputerFactory {
    private int ram;
    private int hdd;
    public PC(int ram,int hdd){
        this.hdd=hdd;
        this.ram=ram;
    }

    @Override
    public void getComputer() {
        System.out.println("PC created with ram: "+ram +" hdd: "+hdd);
    }
}
