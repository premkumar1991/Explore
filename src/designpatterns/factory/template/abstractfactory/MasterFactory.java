package designpatterns.factory.template.abstractfactory;

public class MasterFactory {
    public static ImplementationFactory create(AbstractFactory abstractFactory){
        return abstractFactory.create();
    }
}
