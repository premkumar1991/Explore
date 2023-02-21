package designpatterns.builder.template;

public class Client {
    public static void main(String[] args){
        Product product = new Product.Builder().setProductField(1).build();
        System.out.println(product.getProductField());
    }
}
