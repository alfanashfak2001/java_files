package gasStation;

import user.Customer;

import java.util.Queue;
import java.util.Scanner;

public class DieselFuelDispenseManager extends FuelDispenser implements FuelDispenseManager
{

    public DieselFuelDispenseManager(int dispenserNumber, String vehicleType, int availablePostions, FuelRepository fuelRepo, Queue<Customer> customerList) {
        super(dispenserNumber, vehicleType, availablePostions, fuelRepo, customerList);
    }

    public DieselFuelDispenseManager(int dispenserNumber, String vehicleType, int availablePostions, FuelRepository fuelRepo) {
        super(dispenserNumber, vehicleType, availablePostions, fuelRepo);
    }

    public DieselFuelDispenseManager(int dispenserNumber, String vehicleType) {
        super(dispenserNumber, vehicleType);
    }

    @Override
    public void displayFreePositions() {
        super.displayFreePositions();
    }

    @Override
    public void addAVehicleToQueue() {
        //for the moment adding process done by parent class dispenser but this method kept for future updates;
        System.out.println();
    }

    @Override
    public String[] dispenseFuel(Customer customer, Scanner input) {


        //asking the customer the needed fuel quantity in liters
        int fuelQuantityNeeded = customer.getFuel(input);
        //and generating the bill according to the request
        int totalFuelBill = (fuelQuantityNeeded*this.getFuelRepo().getPricePerLiter());

        //returning message to printing the message
        String message = ("Dispensing diesel to ticket-no."+customer.getTicketNumber()+
                " amount of " +fuelQuantityNeeded +" liter(s) : Rs."+ totalFuelBill);
        System.out.println(message);
        return new String[]{String.valueOf(fuelQuantityNeeded), String.valueOf(totalFuelBill), message};

    }

    @Override
    public synchronized void updateTheFuelIssuedByADispenser(String[] details) {
        int fuelQuantityNeeded = Integer.parseInt(details[0]);
        //increase the amount of fuel dispensed by this dispenser
        recordTheFuelAmountDispensed(fuelQuantityNeeded);
    }


    public synchronized void updateTotalFuelIssuedByDieselPerDay(String[] details) {
        super.updateTotalFuelIssuedByAFuelTypePerDay(details);
    }

    @Override
    public void getThePaymentForFuel(String[] details, Customer customer,Scanner input) {
        super.getThePaymentForFuel(details, customer, input);
    }

    @Override
    public void removeAVehicleFromQueue(String message) {
        System.out.print(message+"\n");
    }


}
