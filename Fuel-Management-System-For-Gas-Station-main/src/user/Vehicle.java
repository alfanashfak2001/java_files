package user;

public class Vehicle {
    private String vehicleNumber;
    private String chassisNumber;
    private String vehicleType;
    private String fuelType;
    private int fuelTankSize;
    private int fuelQuantityNeeded;

    public Vehicle(String vehicleNumber, String chassisNumber, String fuelType)
    {
        this.vehicleNumber = vehicleNumber;
        this.chassisNumber = chassisNumber;
        this.fuelType = fuelType;

    }

    public Vehicle(String vehicleNumber, String chassisNumber, String vehicleType, String fuelType, int fuelTankSize) {
        this.vehicleNumber = vehicleNumber;
        this.chassisNumber = chassisNumber;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.fuelTankSize = fuelTankSize;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelTankSize() {
        return fuelTankSize;
    }

    public void setFuelTankSize(int fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public int getFuelQuantityNeeded() {
        return fuelQuantityNeeded;
    }

    public void setFuelQuantityNeeded(int fuelQuantityNeeded) {
        this.fuelQuantityNeeded = fuelQuantityNeeded;
    }

    @Override
    public String toString() {
        if (fuelQuantityNeeded != 0)
        {
            return "Vehicle{" +
                    "vehicleNumber=" + vehicleNumber +
                    ", chassisNumber=" + chassisNumber +
                    ", vehicleType=" + vehicleType +
                    ", fuelType=" + fuelType +
                    ", fuelTankSize=" + fuelTankSize +
                    ", fuelQuantityNeeded=" + fuelQuantityNeeded +
                    '}';
        }
        else {
            return "Vehicle{" +
                    "vehicleNumber=" + vehicleNumber +
                    ", chassisNumber=" + chassisNumber +
                    ", vehicleType=" + vehicleType +
                    ", fuelType=" + fuelType +
                    ", fuelTankSize=" + fuelTankSize +
                    ", fuelQuantityNeeded=not decided yet" +
                    '}';
        }

    }
}
