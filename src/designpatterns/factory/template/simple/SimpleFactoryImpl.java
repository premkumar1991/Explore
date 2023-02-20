package designpatterns.factory.template.simple;

public class SimpleFactoryImpl implements IFactory {
    @Override
    public void operation() {
        System.out.println("SimpleFactoryImpl operation");
    }
}
