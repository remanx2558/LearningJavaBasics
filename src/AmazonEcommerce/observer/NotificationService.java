package AmazonEcommerce.observer;

import AmazonEcommerce.UserAccount;
import AmazonEcommerce.enums.NotificationTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationService {

    //Observer Pattern

    static HashMap<NotificationTopic, List<UserAccount>> subscriptions=new HashMap<>();


    static public void subscribe(NotificationTopic topic, UserAccount account){
        if(!subscriptions.containsKey(topic)){subscriptions.put(topic,new ArrayList<>());}
        subscriptions.get(topic).add(account);
    }

    static public void unsubscribe(NotificationTopic topic, UserAccount account){
        if(subscriptions.containsKey(topic)){subscriptions.get(topic).remove(account);}
    }

    static public void notify(UserAccount account, String message){
        account.receiveNotification("Notification to:"+ account.getName() +" is "+message);
    }

    public void notifyTopic(NotificationTopic topic, String message) {
        for(UserAccount account: subscriptions.get(topic)){
            account.receiveNotification(message);
        }
    }
}
