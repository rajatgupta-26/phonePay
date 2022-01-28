import java.util.*;

public class RentalSystem {
    private static List<Station> stations = new ArrayList<>();

    private Map<Customer, Vehicle> bookedVehicles = new HashMap<>();


    public void addStation(Station station){
        stations.add(station);
    }

    public Station search_vehicle(Type type) throws Exception{
        PriorityQueue<Station> queues = new PriorityQueue<>((a, b) -> {
            if(a.getPrices(type) == null){
                return 1;
            }

            return (int) (a.getPrices(type) - b.getPrices(type));
        });

        queues.addAll(stations);


        while(!queues.isEmpty()){
            Station station = queues.poll();
            if(station.has_vehicle_type(type)) {
                return station;
            }
        }

        throw new Exception("Expected vehicle type is not aviable");

    }

    public void book_vehicle(Station station, Type type, Customer customer) throws Exception{
        List<Vehicle> vehicles = station.getVehicles(type);
        for(Vehicle vehicle : vehicles){
               if(!Objects.equals(vehicle.get_booked_status(), "booked")){
                   vehicle.set_booked_status("booked");
                   bookedVehicles.put(customer, vehicle);
                   return;
               }
        }

        throw new Exception("Expected vehicle type is not aviable");
    }

    public void remove_vehicle(Vehicle vehicle, Station station) throws Exception{
        station.remove_vehicle(vehicle);
    }

    public Map<Customer, Vehicle> getBookedVehicles(){
        return bookedVehicles;
    }


}
