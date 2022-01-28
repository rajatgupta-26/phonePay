public class Vehicle {

    private String number;
    private String name;
    private Type type;
    private String booked_status;
    private String station_id;

    public Vehicle(Type type, String status){
        this.booked_status = status;
        this.type = type;
    }

    public String get_booked_status(){
        return this.booked_status;
    }

    public void set_booked_status(String status){
       this.booked_status = status;
    }

    public Type getType(){
        return this.type;
    }

}
