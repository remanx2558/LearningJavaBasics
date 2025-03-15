package AmazonEcommerce;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int id;
    List<Product> productList= new ArrayList<>();;

    //add product
    public void addProduct(Product product){
        if(!productList.contains(product)){productList.add(product);}
        else{
            for(Product product1: productList){
                if(product1.getId()==product.getId()){
                    product1.setQuantity(product1.getQuantity()+product.getQuantity());
                    return;
                }

            }
        }
    }


    //add remove product
    public void removeProduct(Product product){
        if(!productList.contains(product)){return;}
        else{
            for(Product product1: productList){
                if(product1.getId()==product.getId()){
                    product1.setQuantity(Math.max(product1.getQuantity()-product.getQuantity(),0));
                    return;
                }
            }
        }
    }
}
