package designpatterns.factory.template.simple;

public class GeneralFactory {
    public static IFactory getDesiredImplementation(int type){
        IFactory output = null;
        switch (type){
            case 1:
                output = new SimpleFactoryImpl();
                break;
            case 2:
                output = new ComplexFactoryImpl();
                break;
        }
        return output;
    }
}
