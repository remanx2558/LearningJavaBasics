package ObjectPoolDesignPattern;

public class ObjectPoolClient {
    public static void main(String agrs[]){

        DBConnectionPoolManager manager=DBConnectionPoolManager.getInstance();

        //get 7 instances
        DBConnectionResource resource1=manager.getResource();
        DBConnectionResource resource2=manager.getResource();
        DBConnectionResource resource3=manager.getResource();
        DBConnectionResource resource4=manager.getResource();
        DBConnectionResource resource5=manager.getResource();
        DBConnectionResource resource6=manager.getResource();
        DBConnectionResource resource7=manager.getResource();
        DBConnectionResource resource8=manager.getResource();

        //remove few resources
        manager.freeResource(resource8);
        manager.freeResource(resource1);
        manager.freeResource(resource2);

        //get 1 more resource
        DBConnectionResource resource9=manager.getResource();
    }
}
