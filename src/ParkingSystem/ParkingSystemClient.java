package ParkingSystem;

import ParkingSystem.Entitiy.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ParkingSystem.Entitiy.Vehicle.FourWheelerVehicle;
import ParkingSystem.Entitiy.Vehicle.TwoWheelerVehicle;
import ParkingSystem.Entitiy.Vehicle.Vehicle;
import ParkingSystem.Strategy.Payment.CreditCardPayment;

public class ParkingSystemClient {
    private static final Logger logger = Logger.getLogger(ParkingSystemClient.class.getName());

    public static void main(String[] args) {
        logger.info("Starting Parking System...");

        ParkingSystem parkingSystem = new ParkingSystem();

        // Vehicles
        Vehicle bike = new TwoWheelerVehicle(101);
        Vehicle car = new FourWheelerVehicle(202);

        try {
            // Enter bike via Gate-1
            Ticket bikeTicket = parkingSystem.vehicleEntry(bike, parkingSystem.getEntryGate(1));

            System.out.println("Bike parked with ticket number: " + (bikeTicket != null ? bikeTicket.getVehicle().getVehicleNumber() : "No Spot"));

            // Enter car via Gate-2
            Ticket carTicket = parkingSystem.vehicleEntry(car, parkingSystem.getEntryGate(2));
            System.out.println("Car parked with ticket number: " + (carTicket != null ? carTicket.getVehicle().getVehicleNumber() : "No Spot"));

            // Two-Wheeler Exit
            int bikePrice = parkingSystem.vehicleExit(bikeTicket, parkingSystem.getExitGate(5), new CreditCardPayment());
            System.out.println("Total bike parking fee: " + bikePrice);

            // Four-Wheeler Exit
            int carPrice = parkingSystem.vehicleExit(carTicket, parkingSystem.getExitGate(6), new CreditCardPayment());
            System.out.println("Total car parking fee: " + carPrice);

        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "Null value encountered: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        }
    }
}