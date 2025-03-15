package AmazonEcommerce;

import AmazonEcommerce.enums.ProductCategory;
import AmazonEcommerce.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Product {
    private final String id;
    private ProductCategory productCategory;
    private List<Review> reviews=new ArrayList<>();
    private int mrp;

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    private int quantity;

    public Product( ProductCategory category, int price, int quantity) {
        id = IdGenerator.generateId();
        this.productCategory = category;
        mrp = price;
        this.quantity = quantity;
    }

    public int getMrp() {
        return mrp;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(UserAccount account){
        for(Review review: reviews){
            if(review.getReviewer() == account){
                reviews.remove(review);
            }
        }
    }

    //view reviews
    public List<Review> viewReview(){
        return reviews;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    //Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product other = (Product) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Review> getReviews(){return reviews;}

    public String getId(){return id;}

    public int getQuantity(){return quantity;}

    public void setQuantity(int qt){
        quantity=qt;
    }


}
