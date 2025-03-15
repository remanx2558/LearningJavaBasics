package AmazonEcommerce;

import AmazonEcommerce.Stategies.SearchStrategy;
import AmazonEcommerce.enums.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class CatalogService {
    static List<ProductCategory> productCategories= new ArrayList<>();;
    static List<Product> products= new ArrayList<>();;
    public static List<Item> items= new ArrayList<>();;

    //Products
    static void removeProduct(Product product){
        products.remove(product);
    }
    static void addProduct(Product product){
        products.add(product);
    }
    //ProductCategory
    static void removeProductCategory(ProductCategory productCategory){
        productCategories.remove(productCategory);
    }
    static void addProductCategory(ProductCategory productCategory){
        productCategories.add(productCategory);
    }

    //Search Product
    static List<Item> searchProducts(SearchStrategy searchStrategy, Product product){
        return searchStrategy.search(product);
    }
}
