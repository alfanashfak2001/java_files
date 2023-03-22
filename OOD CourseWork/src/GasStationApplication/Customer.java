package GasStationApplication;

public class Customer {
    private String VehicleId;
    private String TypeOfFuel;
    private String TypeOfVehicle;
    private String NameOfOwner;
    private String NICOfOwner;
    private  double PumpedFuelQuantity;


    public Customer(String vehicleId, String typeOfFuel, String typeOfVehicle, String nameOfOwner, String NICOfOwner) {
        this.VehicleId = vehicleId;
        this.TypeOfFuel = typeOfFuel;
        this.TypeOfVehicle = typeOfVehicle;
        this.NameOfOwner = nameOfOwner;
        this.NICOfOwner = NICOfOwner;


        
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.VehicleId = vehicleId;
    }

    public String getTypeOfFuel() {
        return TypeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.TypeOfFuel = typeOfFuel;
    }

    public String getTypeOfVehicle() {
        return TypeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.TypeOfVehicle = typeOfVehicle;
    }

    public String getNameOfOwner() {
        return NameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.NameOfOwner = nameOfOwner;
    }

    public String getNICOfOwner() {
        return NICOfOwner;
    }

    public void setNICOfOwner(String NICOfOwner) {
        this.NICOfOwner = NICOfOwner;
    }

    public double getPumpedFuelQuantity() {
        return PumpedFuelQuantity;
    }

    public void setPumpedFuelQuantity(double PumpedFuelQuantity) {
        this.PumpedFuelQuantity = PumpedFuelQuantity;
    }
}
