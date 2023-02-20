package designpatterns.factory.template.simple;

public class ComplexFactoryImpl implements IFactory {
    @Override
    public void operation() {
        System.out.println("ComplexFactoryImpl operation");
    }
}
