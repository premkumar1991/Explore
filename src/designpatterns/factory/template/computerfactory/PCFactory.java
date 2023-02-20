package designpatterns.factory.template.computerfactory;

public class PCFactory implements AbstractComputerFactory {
    private int ram, hdd;

    public PCFactory(int ram, int hdd) {
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public ComputerFactory createComputer() {
        return new PC(ram,hdd);
    }
}
