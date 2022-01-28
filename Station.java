import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Station {
    private String station_id;
    private String address;
    private Map<Type, List<Vehicle>> free_vechicles;
    private Map<Type, List<Vehicle>> booked_vechicles;
    private Map<Type, Double> prices;


    public Station(Map<Type, Double> prices, String station_id){
        this.station_id = station_id;
        this.prices = prices;
        this.free_vechicles = new HashMap<>();
        this.booked_vechicles = new HashMap<>();
    }

    public void park_vehicle(Vehicle vehicle){
        if(!free_vechicles.containsKey(vehicle.getType())){
            free_vechicles.put(vehicle.getType(), new ArrayList<>());
        }
        free_vechicles.get(vehicle.getType()).add(vehicle);
    }

//    public void mark_vehicle_book(Type type) throws Exception {
//        List<Vehicle> free = free_vechicles.get(type);
//        if(free.size() == 0){
//            throw new Exception("No vechicles free");
//        }
//        List<Vehicle> booked  = booked_vechicles.get(type);
//        if(free.size() == 0){
//            booked_vechicles.put(type, new ArrayList<>());
//        }
//        booked_vechicles.get(type).add(free.get(0));
//        free.remove(0);
//
//    }

    public void remove_vehicle(Vehicle vehicle) throws Exception {
        if(free_vechicles.getOrDefault(vehicle.getType(), new ArrayList<>()).contains(vehicle)){
            throw new Exception(" Can't remove vechicles as vechicles is not free");
        }
        free_vechicles.get(vehicle.getType()).remove(vehicle);
    }

    public boolean has_vehicle_type(Type type){
//        System.out.println(free_vechicles);
        return free_vechicles.containsKey(type) && (free_vechicles.get(type).size() > 0);
    }

    public Map<String, Map<Type, List<Vehicle>>> generate_report(){
        Map<String, Map<Type, List<Vehicle>>> map = new HashMap<>();
        map.put("Available", free_vechicles);
        map.put("Booked", booked_vechicles);

        return map;
    }

    public Double getPrices(Type type) {
        return prices.get(type);
    }

    public List<Vehicle> getVehicles(Type type) {
        return free_vechicles.get(type);
    }

    public String getStation_id() {
        return station_id;
    }
}
