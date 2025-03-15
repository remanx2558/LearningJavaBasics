package AmazonEcommerce;

import AmazonEcommerce.util.IdGenerator;


public class Review {
    private final String reviewContent;
    private final String id;
    private final UserAccount reviewer;

    Review(String text, UserAccount account){
        id= IdGenerator.generateId();
        reviewContent=text;
        reviewer=account;
    }
    public UserAccount getReviewer(){return reviewer;}
}
