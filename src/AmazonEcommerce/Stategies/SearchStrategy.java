package AmazonEcommerce.Stategies;

import AmazonEcommerce.Item;
import AmazonEcommerce.Product;

import java.util.List;

public interface SearchStrategy {
    List<Item> search(Product product);
}
