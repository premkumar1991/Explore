package designpatterns.factory.template.abstractfactory;

/**
 * This is one level abstraction of actual factory implementation to avoid type check and create instance in simple factory method
 */
public class Implementation1AbstractFactory implements AbstractFactory {
    int param1;
    String param2;
    public Implementation1AbstractFactory(int param1, String param2){
        this.param1=param1;
        this.param2=param2;
    }
    @Override
    public ImplementationFactory create() {
        return new Implementation1(param1,param2);
    }
}
