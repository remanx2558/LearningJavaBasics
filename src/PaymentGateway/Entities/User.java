package PaymentGateway.Entities;

import Common.util.IdGenerator;

public class User {
    public String id;
    String name;
    String email;

    public User(String name, String email) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
