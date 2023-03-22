package user;

import gasStation.FuelDispenser;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Customer extends Person {
    private int ticketNumber;
    private Vehicle vehicle;

    public Customer(String nic, String firstName, Vehicle vehicle) {
        super(nic, firstName);
        this.vehicle = vehicle;
    }

    public Customer(String nic, String mobileNo, String firstName, String lastName, String address, Vehicle vehicle) {
        super(nic, mobileNo, firstName, lastName, address);
        this.vehicle = vehicle;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        if (ticketNumber == 0)
        {
            return "Customer{" +
                    "ticketNumber=not assigned yet" +
                    ", vehicle=" + vehicle +
                    '}';
        }
        return "Customer{" +
                "ticketNumber=" + ticketNumber +
                ", vehicle=" + vehicle +
                '}';
    }

    public int getFuel(Scanner input)
    {

//        System.out.print("Enter the fuel amount needed"); if we use this line for user input then we have else clause below to get valid input
//        otherwise noo need else clause because here we get random input between 1 to tank size of vehicle which include 1 and tank size;
//        int quantityNeeded = input.nextInt();
        int quantityNeeded = (int)Math.floor(Math.random()* (this.getVehicle().getFuelTankSize()-1+1))+1;//Math.floor(Math.random() * (max - min + 1) ) + min;
        if (quantityNeeded < getVehicle().getFuelTankSize())
        {
            this.getVehicle().setFuelQuantityNeeded(quantityNeeded);
            return quantityNeeded;
        }
        else
        {
            System.out.println("Please enter the quantity less than the tank size");
            quantityNeeded = getFuel(input);
            this.getVehicle().setFuelQuantityNeeded(quantityNeeded);
            return quantityNeeded;
        }
    }
    public int makePayment(int fuelBillRupees, Scanner input)
    {

//        System.out.println("Please enter the paying bill amount");if we use this line for user input then we have else clause below to get valid input
//        otherwise noo need else clause because here we get random input between fuelBillPrice to maximum amount of 1 million  which include 1 and 1 million;
//        int payingAmount = input.nextInt();
        // below maximum fixed to 1 million because that could be the maximum reserve amount in a dispenser locker to exchange for the moment
        int payingAmount = (int)Math.floor(Math.random()* ((fuelBillRupees+5000)-fuelBillRupees+1))+fuelBillRupees;//Math.floor(Math.random() * (max - min + 1) ) + min;

        if (payingAmount >= fuelBillRupees)
        {
            System.out.println("ticket.no-"+this.getTicketNumber() + " payed the bill Rs."+ fuelBillRupees +" with "+payingAmount);
            return payingAmount;
        }else
        {
            System.out.println("Please pay sufficient amount for "+ fuelBillRupees);
            payingAmount = makePayment(fuelBillRupees, input);
            return payingAmount;
        }
    }

    public static Customer aCustomerJoinsToTheStation(Scanner input)
    {
        String nic, firstName, vehicleNumber, chassisNumber, vehicleType, fuelType;
        int fuelTankSize;

        System.out.println("Adding a customer to the station");
        System.out.print("Enter the First Name of customer: ");
        input.nextLine();
        firstName = input.nextLine();
        System.out.print("Enter the NIC of customer : ");
        nic = input.nextLine();
        System.out.print("Enter the Vehicle Number : ");
        vehicleNumber = input.nextLine();
        System.out.print("Enter the Chassis Number : " );
        chassisNumber = input.nextLine();
        System.out.print("Enter the Vehicle Type : ");
        vehicleType = input.nextLine();
        System.out.print("Enter the Fuel Type (92Octane/diesel): ");
        fuelType = input.nextLine();
        System.out.print("Enter the Fuel Tank Size : ");
        fuelTankSize = input.nextInt();

        //creating vehicle
        Vehicle v = new Vehicle(vehicleNumber, chassisNumber, vehicleType, fuelType, fuelTankSize);

        //creating customers who own vehicles
        Customer customer = new Customer(nic, firstName, v);

        //customer deciding the fuel quantity needed
        customer.getVehicle().setFuelQuantityNeeded(new Random().nextInt(1,fuelTankSize));

        System.out.println("\nSystem is detecting customer");

        System.out.println(customer.toString()+" entering the station");
        customer.setTicketNumber(FuelDispenser.issueTicket());

        System.out.println(customer.getFirstName()+"-"+customer.getNic()+" with "+ customer.getVehicle().getVehicleType()+ " " +
                "got the ticket-ticketno."+customer.getTicketNumber());

        return customer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return ticketNumber == customer.ticketNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketNumber);
    }
}
