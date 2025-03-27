package Common.entities;

import Common.util.IdGenerator;

public class Store {
    private String id;
    protected Store(){
        id= IdGenerator.generateId();
    }
}
