package designpatterns.factory.template.abstractfactory;

public class Implementation1 implements ImplementationFactory {
    private int param1;
    private String param2;
    public Implementation1(int param1, String param2){
        this.param1=param1;
        this.param2=param2;
    }
    @Override
    public void operation() {
        System.out.println("Implementation1 " + " param1: "+param1 + " param2: "+param2);
    }
}
