package AmazonEcommerce;

import AmazonEcommerce.util.IdGenerator;

public class Item {
    String id;
    public Product product;
    boolean isAvailable=true;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    int batchId;
    int price;
    Merchant merchant;

    public Item(Product product, int price, Merchant merchant) {

        id = IdGenerator.generateId();
        this.product = product;
        this.price = price;
        this.merchant= merchant;
    }
}
