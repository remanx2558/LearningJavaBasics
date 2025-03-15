package AmazonEcommerce.Stategies;

import AmazonEcommerce.CatalogService;
import AmazonEcommerce.Item;
import AmazonEcommerce.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchItemOnProduct implements SearchStrategy {
    public List<Item> search(Product product){
        List<Item> items=new ArrayList<>();
        for(Item item: CatalogService.items){
            if(item.product.equals(product)){
                items.add(item);
            }
        }
        return items;
    }
}
