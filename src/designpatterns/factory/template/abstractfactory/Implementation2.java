package designpatterns.factory.template.abstractfactory;

import java.util.List;

public class Implementation2 implements ImplementationFactory {
    List<Integer> list;
    public Implementation2(List<Integer> list){
        this.list=list;
    }
    @Override
    public void operation() {
        System.out.println("Implementation2 list size:" + list.size());
    }
}
