package AmazonEcommerce.Stategies;

import AmazonEcommerce.CatalogService;
import AmazonEcommerce.Item;
import AmazonEcommerce.Product;
import java.util.ArrayList;
import java.util.List;

public class SearchItemOnProductCategory implements SearchStrategy{
    public List<Item> search(Product product){
        List<Item> result=new ArrayList<>();
        for(Item item: CatalogService.items){
            if(item.product.getProductCategory().equals(product.getProductCategory())){
                result.add(item);
            }
        }
        return result;
    }
}
