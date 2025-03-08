package AirlineManagementSystem;

public class Seat {
    int id;
    int flightId;
    int seatNo;
    SeatType seatType;

    boolean isAvailable;
    int passengerId;

    void occupySeat(Person person){
        isAvailable=false;
        passengerId=person.id;
    }
}
