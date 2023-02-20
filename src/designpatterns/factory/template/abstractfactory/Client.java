package designpatterns.factory.template.abstractfactory;

import java.util.LinkedList;

public class Client {
    public static void main(String[] a) {
        AbstractFactory abstractFactory1 = new Implementation1AbstractFactory(1, "hello");
        AbstractFactory abstractFactory2 = new Implementation2AbstractFactory(new LinkedList<>() {{
            add(1);
        }});
        MasterFactory.create(abstractFactory1).operation();
        MasterFactory.create(abstractFactory2).operation();
    }
}
