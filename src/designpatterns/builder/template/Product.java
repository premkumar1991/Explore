package designpatterns.builder.template;

public class Product {
    private int productField;
    private Product(Builder builder){
        productField= builder.productField;
    }
    public int getProductField(){
        return productField;
    }
    public static class Builder{
        private int productField;
        public Builder(){}
        public Builder setProductField(int productField){
            this.productField=productField;
            return this;
        }
        public Product build(){
            validate();
            return new Product(this);
        }
        public void validate(){
            if(productField<0)
                throw new IllegalArgumentException("Please set positive value");
        }
    }

}
