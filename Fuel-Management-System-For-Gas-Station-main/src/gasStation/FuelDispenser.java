package gasStation;

import user.Customer;

import java.time.LocalDateTime;
import java.util.*;

public abstract class FuelDispenser {
    private int dispenserNumber;
    private String vehicleType;
    private int availablePositions;
    private Map<LocalDateTime, Integer> fuelAmountDispensed= new LinkedHashMap<>();//Date object means it is like : 2022-12-11T06:48:09.877378400
                                                                          //which contains date and time like above
    private DispenseWorker dispenseWorker;
    private FuelRepository fuelRepo;
    private Queue<Customer> customerList = new LinkedList<>();

    private static int ticketOrder;

    private static ArrayList<Customer> waitingQueue = new ArrayList<>();//in the beginning using the queue for the waiting queue
    //but later decided to choose arrayList because waiting queue is not working is a queue its working as common waiting area
    //and customers need to be waiting in the same position , or move front without considering the order until some part of the dispensers should
    //become active due to many reasons therefore most suitable is arraylist comparing to queue;

    static{
        ticketOrder = 10000;
    }

    public FuelDispenser(int dispenserNumber, String vehicleType, int availablePositions, FuelRepository fuelRepo, Queue<Customer> customerList) {
        this.dispenserNumber = dispenserNumber;
        this.vehicleType = vehicleType;
        this.availablePositions = availablePositions;
        this.fuelRepo = fuelRepo;
        this.customerList = customerList;
    }

    public FuelDispenser(int dispenserNumber, String vehicleType, int availablePositions, FuelRepository fuelRepo) {
        this.dispenserNumber = dispenserNumber;
        this.vehicleType = vehicleType;
        this.availablePositions = availablePositions;
        this.fuelRepo = fuelRepo;
    }

    public FuelDispenser(int dispenserNumber, String vehicleType) {
        this.dispenserNumber = dispenserNumber;
        this.vehicleType = vehicleType;
    }


    public int getDispenserNumber() {
        return dispenserNumber;
    }

    public void setDispenserNumber(int dispenserNumber) {
        this.dispenserNumber = dispenserNumber;
    }

    public String getVehicleType() {

        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getAvailablePostions() {
        this.availablePositions = 10-this.customerList.size();
        return availablePositions;
    }

    public void setAvailablePostions(int availablePostions) {
        this.availablePositions = availablePostions;
    }

    public synchronized Map<LocalDateTime, Integer> getFuelAmountDispensed() {
        return fuelAmountDispensed;
    }

    public void setFuelAmountDispensed(Map<LocalDateTime, Integer> fuelAmountDispensed) {
        this.fuelAmountDispensed = fuelAmountDispensed;
    }

    public synchronized void recordTheFuelAmountDispensed(int fuelAmount)
    {
        LocalDateTime aDateTime = LocalDateTime.now();
        this.fuelAmountDispensed.put(aDateTime, fuelAmount);
    }

    public DispenseWorker getDispenseWorker() {
        return dispenseWorker;
    }

    public void setDispenseWorker(DispenseWorker dispenseWorker) {
        this.dispenseWorker = dispenseWorker;
    }

    public FuelRepository getFuelRepo() {
        return fuelRepo;
    }

    public void setFuelRepo(FuelRepository fuelRepo) {
        this.fuelRepo = fuelRepo;
    }

    public Queue<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Queue<Customer> customerList) {
        this.customerList = customerList;
    }

    public synchronized void addACustomerToQueue(Customer customer)
    {

        if( this.customerList.add(customer))
        {
            System.out.println("ticket.no-"+customer.getTicketNumber()+ " " +
                    customer.getFirstName()+"-"+customer.getNic()+" with "+ customer.getVehicle().getVehicleType()+ " " +
                    "added to the "+ getFuelRepo().getFuelType() + " dispenser " + getDispenserNumber());
        };

    }

    public synchronized Object[] removeACustomerFromQueue()
    {
        Customer customer = customerList.remove();

        return new Object[] {"ticket.no-"+customer.getTicketNumber()+ " " +
                customer.getFirstName()+"-"+customer.getNic()+" with "+ customer.getVehicle().getVehicleType()+ " " +
                "removed from "+ getFuelRepo().getFuelType() + " dispenser " + getDispenserNumber(), customer};


    }

    public synchronized static int issueTicket() {
        return ticketOrder++;

    }

    public synchronized boolean isActiveDispenser(boolean printMessage)
    {
        boolean active = true;
        //checking the man power and the minimum fuel level of the repository to confirm active or not
        if (dispenseWorker == null)
        {
            active = false;
            if(printMessage) {
                System.out.println("This " + this + " not active due to less man power");
            }
        }
        if(fuelRepo.isLowLevel())
        {
            active = false;
            if(printMessage)
            {
                System.out.println("This "+ this + " not active due to insufficient capacity of repo");
            }
        }
        return active;


    }

    public static ArrayList<FuelDispenser> showActiveDispensers(FuelDispenser[] fuelDispensers)
    {
        ArrayList<FuelDispenser> activeDispensers = new ArrayList<>();
        for(FuelDispenser fd : fuelDispensers)
        {
            if (fd.isActiveDispenser(true))
            {
                activeDispensers.add(fd);
            }
        }
        return activeDispensers;
    }

    public synchronized boolean isCustomerQueueFull()
    {
        return (customerList.size() == 10);
    }

    public static ArrayList<Customer> getWaitingQueue() {
        return waitingQueue;
    }


    public static void setWaitingQueue(ArrayList<Customer> waitingQueue) {
        FuelDispenser.waitingQueue = waitingQueue;
    }

    public synchronized static void addACustomerToWaitingQueue(Customer customer)
    {
        if(waitingQueue.add(customer))
        {
            System.out.println("ticket.no-"+customer.getTicketNumber()+ " " +
                    customer.getFirstName()+"-"+customer.getNic()+" with "+ customer.getVehicle().getVehicleType()+ " " +
                    "added to the common waiting queue");
        };
    }


    public synchronized static void removeASpecificCustomerFromWaitingQueue(Customer customer)
    {
        waitingQueue.remove(customer);
        System.out.println("ticket.no-"+customer.getTicketNumber()+ " " +
                customer.getFirstName()+"-"+customer.getNic()+" with "+ customer.getVehicle().getVehicleType()+ " " +
                "removed from the common waiting queue");
    }

    public static void removeASpecificCustomerFromAnyQueue(ArrayList<Customer> customers) {
        Scanner input = new Scanner(System.in);
        String nic;

        System.out.println("Enter customer's nic : ");
        nic = input.nextLine();

        Customer removingCustomer = null;
        for (Customer c : customers) {
            if (c.getNic().equalsIgnoreCase(nic)) {
                removingCustomer = c;
            }
        }
        for (Customer c : waitingQueue) {
            if (c.getNic().equalsIgnoreCase(nic)) {
                removingCustomer = c;
            }
        }

        if (removingCustomer != null && customers.remove(removingCustomer)) {
            System.out.println("ticket.no-" + removingCustomer.getTicketNumber() + " " +
                    removingCustomer.getFirstName() + "-" + removingCustomer.getNic() + " with " +
                    removingCustomer.getVehicle().getVehicleType() + " " +
                    "removed from a dispenser by controller ");

        } else if (removingCustomer != null && waitingQueue.remove(removingCustomer)) {
            System.out.println("ticket.no-" + removingCustomer.getTicketNumber() + " " +
                    removingCustomer.getFirstName() + "-" + removingCustomer.getNic() + " with " +
                    removingCustomer.getVehicle().getVehicleType() + " " +
                    "removed from the common waiting queue ");
        } else
        {
            System.out.println("No customer exists under the system by given nic");
        }

    }

    public synchronized void displayFreePositions()
    {
        System.out.println("Dispenser no."+getDispenserNumber()+"-"+getFuelRepo().getFuelType()+" for the "+
                getVehicleType() + " has " + getAvailablePostions() + " remaining positions ");
    }

    public void getThePaymentForFuel(String[] details, Customer customer, Scanner input) {

        int fuelQuantityNeeded = Integer.parseInt(details[0]);
        int totalFuelBill = Integer.parseInt(details[1]);
        String message = details[2];


        //requesting payment from customer by issuing him the bill
        int cashReceivedFromCustomer = customer.makePayment(totalFuelBill, input);


        //if cashReceivedFromCustomer == totalFuelBill then no balance (rupees) amount need to be returned to customer else if below condition
        if( cashReceivedFromCustomer > totalFuelBill)
        {
            int balance = cashReceivedFromCustomer-totalFuelBill;
            System.out.println("Balance of "+balance+" returned to ticket.no-"+customer.getTicketNumber());
        }
    }

    public synchronized void updateTotalFuelIssuedByAFuelTypePerDay(String[] details) {
        int fuelQuantityNeeded = Integer.parseInt(details[0]);

        getFuelRepo().supplyFromRepoCapacity(fuelQuantityNeeded);
    }

    @Override
    public String toString() {
        if (dispenseWorker == null)
        {
            return "FuelDispenser{" +
                "dispenserNumber=" + dispenserNumber +
                ", fuelRepo=" + fuelRepo.getFuelType() +
                ", vehicleType=" + vehicleType  +
                ", dispenseWorker=no worker assigned"+
                "}";
        }

        return "FuelDispenser{" +
                "dispenserNumber=" + dispenserNumber +
                ", fuelRepo=" + fuelRepo.getFuelType() +
                ", vehicleType=" + vehicleType  +
                ", dispenseWorker=" + dispenseWorker.getId()+ "-" +dispenseWorker.getFirstName()+
                "}";
    }
}
