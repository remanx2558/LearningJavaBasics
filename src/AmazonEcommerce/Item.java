package AmazonEcommerce;

import AmazonEcommerce.util.IdGenerator;

public class Item {
    String id;
    public Product product;

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
