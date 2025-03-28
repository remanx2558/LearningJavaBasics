package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DBConnectionPoolManager {

    private static volatile DBConnectionPoolManager instance;
    private final Logger logger = Logger.getLogger(DBConnectionPoolManager.class.getName());

    private final int MAX_POOL_SIZE = 6;
    private final int INIT_POOL_SIZE = 3;

    private final List<DBConnectionResource> freeResources;
    private final List<DBConnectionResource> inUseResources;

    private DBConnectionPoolManager() {
        freeResources = new ArrayList<>();
        inUseResources = new ArrayList<>();
        initiateDbPool();
    }

    public static DBConnectionPoolManager getInstance() {
        if (instance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (instance == null) {
                    instance = new DBConnectionPoolManager();
                }
            }
        }
        return instance;
    }

    private void initiateDbPool() {
        for (int i = 0; i < INIT_POOL_SIZE; i++) {
            freeResources.add(new DBConnectionResource());
        }
    }

    public synchronized DBConnectionResource getResource() {
        try {
            if (freeResources.isEmpty() && inUseResources.size() < MAX_POOL_SIZE) {
                logger.info("Creating new DBConnectionResource as pool resources are utilized.");
                DBConnectionResource dbConnectionResource = new DBConnectionResource();
                inUseResources.add(dbConnectionResource);
                return dbConnectionResource;
            } else if (freeResources.isEmpty() && inUseResources.size() >= MAX_POOL_SIZE) {
                logger.warning("Maximum pool size reached, no available resources.");
                // Handle situation gracefully: return null or wait
                return null; // or implement a waiting mechanism if needed
            }

            DBConnectionResource dbConnectionResource = freeResources.remove(freeResources.size() - 1);
            inUseResources.add(dbConnectionResource);
            return dbConnectionResource;
        } catch (Exception e) {
            logger.severe("Failed to get resource: " + e.getMessage());
            return null;
        }
    }

    public void freeResource(DBConnectionResource resource) {
        try {
            if (resource == null) {
                logger.warning("Failed to free resource: Resource cannot be null.");
                return;
            } else if (!inUseResources.contains(resource)) {
                logger.warning("Failed to free resource: Resource not found in in-use resources.");
                return;
            }

            inUseResources.remove(resource);
            freeResources.add(resource);
            logger.info("Resource has been freed and added back to the pool.");
        } catch (Exception e) {
            logger.severe("Error freeing resource: " + e.getMessage());
        }
    }
}