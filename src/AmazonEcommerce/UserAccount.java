package AmazonEcommerce;

import AmazonEcommerce.Stategies.SearchStrategy;
import AmazonEcommerce.enums.AccountType;
import AmazonEcommerce.util.IdGenerator;


import java.time.LocalDateTime;
import java.util.List;

public class UserAccount {
    String id;
    String password;
    String name;

    public String getName() {
        return name;
    }

    String phone;
    boolean isBlocked;
    Session session;
    AccountType accountType;
    Address address;

    UserAccount(String name, String password){
        this.name=name;
        this.password=password;
        id= IdGenerator.generateId();
        accountType=AccountType.GUEST;
    }

    //add remove address
    public void addAddress(Address address){
        this.address=address;
    }
    public void removeAddress(){
        this.address=null;
    }
    //login and logout
    public void logIn(int id, String password){
        String token=generateToken(id,password,accountType);
        this.session=new Session(token);
    }

    public void logOut(){
        session=null;
    }
    //add remove session
    private String generateToken(int id, String password, AccountType accountType){
        return ""+id+password+accountType.toString();
    }

    //having valid session or logged In
    public boolean isValidSession(){
        return session!=null
                && session.getTimeToLive().compareTo(LocalDateTime.now())>0
                && session.isActive();
    }

    public List<Item> searchProduct(SearchStrategy searchStrategy, Product product){
        return CatalogService.searchProducts(searchStrategy,product);
    }
    //views Review
    public List<Review> viewReview(Product product){
        return product.getReviews();
    }
    //add comment to purchased product
    //orderId -> itemid
    public void addReviewProduct(Product product, String reviewContent){
        product.getReviews().add(new Review(reviewContent, this));
    }
    public void removeReviewProduct(Product product){
        product.removeReview(this);
    }

    //Observer Pattern
    public void receiveNotification(String message) {System.out.println("Notification to: " + name + " - " + message);}

    public Address getAddress(){return address;}



}
