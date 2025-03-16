package AmazonEcommerce.enums;

public enum ProductCategory {
    ELECTRONICS("ELECTRONICS","ELECTRONICS"),
    BOOKS("BOOKS","BOOKS"),
    CLOTHING("CLOTHING","CLOTHING"),
    BEAUTY("CLOTHING","CLOTHING"),
    FOOD("CLOTHING","CLOTHING");

    String name;
    String description;

    ProductCategory(String name, String description){
        this.name=name;
        this.description=description;
    }
}
