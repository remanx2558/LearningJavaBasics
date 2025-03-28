package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DBConnectionPoolManager {

    private static volatile DBConnectionPoolManager instance;
    private final Logger logger= Logger.getLogger(DBConnectionPoolManager.class.getName());

    private final int MAX_POOL_SIZE=6;
    private final int INIT_POOL_SIZE=3;

    private final List<DBConnectionResource> freeResources;
    private final List<DBConnectionResource> inUseResources;

    private DBConnectionPoolManager(){
        freeResources=new ArrayList<>();
        inUseResources=new ArrayList<>();
        initiateDbPool();
    }

    static public DBConnectionPoolManager getInstance(){
        if(instance==null){
            synchronized (DBConnectionPoolManager.class){
                if(instance==null){
                    instance=new DBConnectionPoolManager();
                }
            }
        }
        return instance;
    }


    private void initiateDbPool(){
        for(int i=0;i<INIT_POOL_SIZE;i++){
            freeResources.add(new DBConnectionResource());
        }
    }


    //Bussiness Logic here: when we put throws on method??
    //when we put synchronized on method??
    //when we put synchroized in block??
    public synchronized DBConnectionResource getResource() throws RuntimeException{
        if(freeResources.isEmpty() && inUseResources.size()<MAX_POOL_SIZE){
            logger.info("Creating new DBConnectionResource as pool resources are utilized.");
            DBConnectionResource dbConnectionResource=new DBConnectionResource();
            inUseResources.add(dbConnectionResource);
            return dbConnectionResource;
        }
        else if(freeResources.isEmpty() && inUseResources.size()>=MAX_POOL_SIZE){
            throw new RuntimeException("Maximum pool size reached, no available resources.");
        }

        //get the last element
        DBConnectionResource dbConnectionResource=freeResources.remove(freeResources.size()-1);
        inUseResources.add(dbConnectionResource);
        return dbConnectionResource;
    }

    public void freeResource(DBConnectionResource resource) throws IllegalArgumentException, IllegalStateException{
        if(resource==null){
            throw new IllegalArgumentException("Resource cannot be null.");
        }
        else if(!inUseResources.contains(resource)){
            throw new IllegalStateException("Resource not found in in-use resources.");
        }

        inUseResources.remove(resource);
        freeResources.add(resource);
        logger.info("Resource has been freed and added back to the pool.");

    }
}
