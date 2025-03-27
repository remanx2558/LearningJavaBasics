package Common.entities;

import Common.util.IdGenerator;

public class UserAccount {
    String name;
    String id;
    String password;

    protected UserAccount(String name, String password){
        this.name=name;
        this.password=password;
        id= IdGenerator.generateId();
    }

    //getter setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
