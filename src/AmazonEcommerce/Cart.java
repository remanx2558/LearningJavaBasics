package AmazonEcommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item>items= new ArrayList<>();;

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> viewCart(){
        return items;
    }
    public int getTotalPrice(){
        int totalPrice=0;
        for(Item item: items){
            totalPrice=totalPrice+item.price;
        }
        return totalPrice;
    }

    public List<Item> getItems(){return items;}
}
