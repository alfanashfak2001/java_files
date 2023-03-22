package gasStation;

import user.Person;

public class DispenseWorker extends Person {
    private int id;
    private FuelDispenser fuelDispenser;

    public DispenseWorker(String nic, String mobileNo, String firstName, String lastName, String address, int id, FuelDispenser fuelDispenser) {
        super(nic, mobileNo, firstName, lastName, address);
        this.id = id;
        this.fuelDispenser = fuelDispenser;
    }

    public DispenseWorker(String nic, String firstName, int id) {
        super(nic, firstName);
        this.id = id;
    }

    public DispenseWorker(String nic, String firstName, int id, FuelDispenser fuelDispenser) {
        super(nic, firstName);
        this.id = id;
        this.fuelDispenser = fuelDispenser;

        //in order to maintain the consistency of the association this method is used here
        fuelDispenser.setDispenseWorker(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FuelDispenser getFuelDispenser() {
        return fuelDispenser;
    }

    public void setFuelDispenser(FuelDispenser fuelDispenser) {
        this.fuelDispenser = fuelDispenser;

        //in order to maintain the consistency of the association this method is used here
        fuelDispenser.setDispenseWorker(this);
    }
}
