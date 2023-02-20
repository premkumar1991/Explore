package designpatterns.factory.template.abstractfactory;

import java.util.List;

public class Implementation2AbstractFactory implements AbstractFactory{
    private List<Integer> list;
    public Implementation2AbstractFactory(List<Integer> list){
        this.list=list;
    }
    @Override
    public ImplementationFactory create() {
        return new Implementation2(list);
    }
}
