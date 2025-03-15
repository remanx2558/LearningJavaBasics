package AmazonEcommerce;

import java.time.LocalDateTime;

public class Session {
    private  final String token;
    private  boolean isActive;
    private LocalDateTime timeToLive;

    Session(String token){
        this.token=token;
        isActive=true;
        timeToLive=LocalDateTime.now().plusMinutes(30);
    }
    public LocalDateTime getTimeToLive(){return timeToLive;}

    public boolean isActive(){return isActive;}
}
