import java.util.HashMap;
import java.util.Map;

public class Execute {

    private static final RentalSystem rentalSystem = new RentalSystem();

    public static void main(String[] args) throws Exception {

        Map<Type, Double> price1 = new HashMap<>();
        price1.put(Type.Hatchback, 50.0);
        price1.put(Type.Sedan, 100.0);
        price1.put(Type.SUV, 200.0);
        Station s1 = new Station(price1, "dummy1");
        rentalSystem.addStation(s1);


        Map<Type, Double> price2 = new HashMap<>();
        price2.put(Type.Hatchback, 500.0);
        price2.put(Type.Sedan, 80.0);
        price2.put(Type.SUV, 200.0);
        Station s2 = new Station(price2, "dummy2");
        rentalSystem.addStation(s2);
        Vehicle vehicle1 =  new Vehicle(Type.Hatchback, "available");
        Vehicle vehicle2 =  new Vehicle(Type.Sedan, "available");
        Vehicle vehicle3 =  new Vehicle(Type.Hatchback, "available");
        Vehicle vehicle4 =  new Vehicle(Type.Sedan, "available");
        s2.park_vehicle(vehicle1);
        s2.park_vehicle(vehicle2);

        s1.park_vehicle(vehicle3);
        s1.park_vehicle(vehicle4);


        Station s = rentalSystem.search_vehicle(Type.Sedan);

        rentalSystem.book_vehicle(s, Type.Sedan, new Customer("1", "abc", null, null));

        System.out.println(rentalSystem.getBookedVehicles());
    }
}
