package GasStationApplication;

public class  DieselDispenserQueue extends Queue{
    private final String FuelType;
    public DieselDispenserQueue(String nameofqueue) {
        super(nameofqueue);
        this.FuelType="Diesel";

    }
}
