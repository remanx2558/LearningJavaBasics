package ZoomCar;

public class VehicleManagementService {

    public void addVehicleToStore(Store store, Vehicle vehicle) {
        store.addVehicle(vehicle);
        System.out.println("Vehicle " + vehicle.getVehicleId() + " added to store " + store.getStoreId());
    }

    public void removeVehicleFromStore(Store store, Vehicle vehicle) {
        store.removeVehicle(vehicle);
        System.out.println("Vehicle " + vehicle.getVehicleId() + " removed from store " + store.getStoreId());
    }

    public void modifyVehicle(Vehicle vehicle, String newBrand, String newModel, int newEngineCC, boolean newElectric) {
        // In a real system, you'd have setters or a specialized approach
        // For simplicity, let's assume we can replace some fields:
        // vehicle.setBrand(newBrand);
        // ...
        System.out.println("Vehicle " + vehicle.getVehicleId() + " modified with new specs.");
    }
}
