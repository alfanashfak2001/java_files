import gasStation.*;
import user.Customer;
import user.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class StartApplication {
    public static void main(String[] args)
    {
        FuelDispenser[] fuelDispensers = initializeTheGasStationData();
        ArrayList<Customer> customers = initializeTheCustomerData();
        displayLoadedDataStatus(fuelDispensers , customers);

        userInteraction(fuelDispensers, customers);

        //Note : Every functionality are working perfectly as expected and producing proper outputs;


    }

    /**
     * command line interaction for the application controller(user)
     */
    public static void userInteraction(FuelDispenser[] fuelDispensers, ArrayList<Customer> customers) {
        int count = 1;
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("1. Add a new vehicle to the station");
            System.out.println("2. Deduct a vehicle from queue ");
            System.out.println("3. Process the gas stations automatically");
            System.out.println("4. Print the statistics ");
            System.out.println("5. Exit ");
            System.out.println("Enter the option : ");

            int userChoice = 0;
            try {
                userChoice = input.nextInt();
            } catch (Exception ignored)
            {

            }

            if (userChoice == 1)
            {
                customers.add(Customer.aCustomerJoinsToTheStation(input));
            }
            else if (userChoice == 2)
            {
                FuelDispenser.removeASpecificCustomerFromAnyQueue(customers);
            }
            else if (userChoice == 3)
            {
                automatedProcess(fuelDispensers, customers, count);
            }
            else if (userChoice == 4)
            {
                FuelDispenseManager.printStatistics(fuelDispensers);
            }
            else if (userChoice == 5)
            {
                System.out.println("Exited from application");
                break;
            } else
            {
                System.out.println("Enter valid input");
            }
        }
    }

    public static void automatedProcess(FuelDispenser[] fuelDispensers, ArrayList<Customer> customers, int cycle)
    {
        //Since below 5 methods work simultaneously at the same time,So we have to implement 5 threads to below 5 methods
        // to run parallel since the application is in the development process further methods could be added in future below

        Thread t1 = new Thread(() -> checkAndDisplayStatusOfStation(fuelDispensers),"Display Status Thread");

        Thread t2 = new Thread(() -> customerEntryToGasStation(customers),"Customer Entry Thread");

        Thread t3 = new Thread(() -> customerJoinsToTheQueue(
                fuelDispensers, customers, true, false),"Queue Joining Thread");

        Thread t4 = new Thread(() -> dispenseFuelForTheCustomers(fuelDispensers),"Dispense Fuel Thread");

        Thread t5 = new Thread(() -> reprocessTheCustomersInWaitingQueue(fuelDispensers),"Process WaitingQueue Thread");

        try {

            t1.start();
            Thread.sleep(500);//Delayed 0.5s to the customer entry to keep a sync;
            t2.start();
            Thread.sleep(500);
            t3.start();
            Thread.sleep(500);
            t4.start();
            Thread.sleep(500);
            t5.start();

            //Before printing the options' menu joining the thread with main thread to keep the programme sync
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public static void reprocessTheCustomersInWaitingQueue(FuelDispenser[] fuelDispensers)
    {
        if (!FuelDispenser.getWaitingQueue().isEmpty())
        {
            ArrayList<Customer> waitingCustomers = FuelDispenser.getWaitingQueue();
            customerJoinsToTheQueue(fuelDispensers, waitingCustomers, true, true);
        }
    }

    public static void dispenseFuelForTheCustomers(FuelDispenser[] fuelDispensers)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Thread> dispenserThreads = new ArrayList<>();

        for (FuelDispenser fd : fuelDispensers)
        {
            //Separate thread for all the active  dispensers
            String threadName = "Dispenser."+fd.getDispenserNumber()+"-"+fd.getFuelRepo().getFuelType()+" Thread";
            Thread aDispenserThread = new Thread(()->
            {
                while(!fd.getCustomerList().isEmpty()) {
                    Object[] details = fd.removeACustomerFromQueue();
                    String message = (String) details[0];
                    Customer customer = (Customer) details[1];


                    if (fd instanceof DieselFuelDispenseManager dfd) {

                        String[] dispenseDetails = dfd.dispenseFuel(customer, input);
                        dfd.updateTheFuelIssuedByADispenser(dispenseDetails);
                        dfd.updateTotalFuelIssuedByDieselPerDay(dispenseDetails);
                        dfd.getThePaymentForFuel(dispenseDetails, customer, input);
                        dfd.removeAVehicleFromQueue(message);

                    } else if (fd instanceof OctaneFuelDispenseManager ofd){

                        String[] dispenseDetails = ofd.dispenseFuel(customer, input);
                        ofd.updateTotalFuelIssuedBy92OctanePerDay(dispenseDetails);
                        ofd.updateTheFuelIssuedByADispenser(dispenseDetails);
                        ofd.getThePaymentForFuel(dispenseDetails, customer, input);
                        ofd.removeAVehicleFromQueue(message);
                    }
                }
            }, threadName);
            aDispenserThread.start();
            dispenserThreads.add(aDispenserThread);
        }

        for(Thread thread: dispenserThreads)
        {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public  static void customerJoinsToTheQueue(FuelDispenser[] fuelDispensers, ArrayList<Customer> customers
            , boolean displayPositions, boolean reProcessingWaitingQueue)
    {

        //Categorizing the dispensers by their fuel type and the vehicle type here;
        /*
        * petrol1 = car,van
        * petrol2 = car,van,other except 3wheel and mobike
        * petrol3 = 3wheel
        * petrol4 = mobike
        * diesel1 = public transport
        * diesel2 = other
        * diesel3 = other
        * */
        FuelDispenser petrol1, petrol2, petrol3, petrol4, diesel1, diesel2, diesel3;
        petrol1 = fuelDispensers[0];
        petrol2 = fuelDispensers[1];
        petrol3 = fuelDispensers[2];
        petrol4 = fuelDispensers[3];
        diesel1 = fuelDispensers[4];
        diesel2 = fuelDispensers[5];
        diesel3 = fuelDispensers[6];

        ArrayList<Thread> customerJoiningThreads = new ArrayList<>();

        //below added list and waitingCustomerAdded is only used when we use this function to reprocess the waiting queue;
        //added list, waitingCustomerAdded have no use when this method runs for the first time;
//        ArrayList<Customer> addedDriversFromWaitingQueue = new ArrayList<>();
        for (Customer c: customers)
        {
            //Joining the customers simultaneously
            Thread aCustomerJoiningThread = new Thread(()->
            {
                boolean waitingCustomerAdded = true;

                String vehicleType = c.getVehicle().getVehicleType();
                String fuelType = c.getVehicle().getFuelType();

                //classifying vehicles
                if(vehicleType.equalsIgnoreCase("three-wheeler") && fuelType.equalsIgnoreCase("92octane") &&
                !petrol3.isCustomerQueueFull() && petrol3.isActiveDispenser(false))
                {
                    if(displayPositions)
                    {
                        petrol3.displayFreePositions();
                    }
                    petrol3.addACustomerToQueue(c);
                    System.out.println();
                }
                else if (vehicleType.equalsIgnoreCase("motor-bike") && fuelType.equalsIgnoreCase("92octane") &&
                        !petrol4.isCustomerQueueFull() && petrol4.isActiveDispenser(false))
                {
                    if(displayPositions)
                    {
                        petrol4.displayFreePositions();
                    }
                    petrol4.addACustomerToQueue(c);
                    System.out.println();
                }
                else if((vehicleType.equalsIgnoreCase("car") || vehicleType.equalsIgnoreCase("van")) &&
                        fuelType.equalsIgnoreCase("92octane") && !petrol1.isCustomerQueueFull() && petrol1.isActiveDispenser(false))
                {
                    if(displayPositions)
                        petrol1.displayFreePositions();
                    petrol1.addACustomerToQueue(c);
                    System.out.println();
                }
                else if((vehicleType.equalsIgnoreCase("car") || vehicleType.equalsIgnoreCase("van") || vehicleType.equalsIgnoreCase("other")) &&
                        fuelType.equalsIgnoreCase("92octane") && !petrol2.isCustomerQueueFull() && petrol2.isActiveDispenser(false))
                {
                    if(displayPositions)
                        petrol2.displayFreePositions();
                    petrol2.addACustomerToQueue(c);
                    System.out.println();
                }
                else if(vehicleType.equalsIgnoreCase("public-transport") && fuelType.equalsIgnoreCase("diesel") &&
                        !diesel1.isCustomerQueueFull() && diesel1.isActiveDispenser(false))
                {
                    if(displayPositions)
                        diesel1.displayFreePositions();
                    diesel1.addACustomerToQueue(c);
                    System.out.println();
                }
                else if(vehicleType.equalsIgnoreCase("other") && fuelType.equalsIgnoreCase("diesel") &&
                        !diesel2.isCustomerQueueFull() && diesel2.isActiveDispenser(false))
                {
                    if(displayPositions)
                        diesel2.displayFreePositions();
                    diesel2.addACustomerToQueue(c);
                    System.out.println();
                }
                else if(vehicleType.equalsIgnoreCase("other") && fuelType.equalsIgnoreCase("diesel") &&
                        !diesel3.isCustomerQueueFull() && diesel3.isActiveDispenser(false))
                {
                    if(displayPositions)
                        diesel3.displayFreePositions();
                    diesel3.addACustomerToQueue(c);
                    System.out.println();
                }
                else
                {
                    //if the customer not added to any active queue above then add to common waiting queue

                    //below variable is only used when re-processing the waiting queue and if customer not added for any
                    //above queue then this becomes false;
                    waitingCustomerAdded = false;

                    if (!FuelDispenser.getWaitingQueue().contains(c))
                    {// this if clause is used when we re-process the waiting queue we don't need to add if the customer is again need
                        // to wait in the same waiting queue;
                        FuelDispenser.addACustomerToWaitingQueue(c);
                        System.out.println();
                    }
                }

                //when in the re-processing of the waiting queue when the list with customer added to a queue
                if(waitingCustomerAdded && reProcessingWaitingQueue)
                {//this jf clause is only useful when we use the reprocessing of waiting queue
                    //then the customer is added to one of the dispenser queue and needed to remove from waiting queue;
                    FuelDispenser.removeASpecificCustomerFromWaitingQueue(c);
                }
            });
            aCustomerJoiningThread.start();
            customerJoiningThreads.add(aCustomerJoiningThread);
        }

        for(Thread thread: customerJoiningThreads)
        {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if(!reProcessingWaitingQueue)
        {
            customers.clear();
        }

    }
    /**
     * when customer enters the gas station detect the vehicle (using AI) and through the application send him the ticket
     * @param customers : array of customers
     */
    public static void customerEntryToGasStation(ArrayList<Customer>  customers)
    {
        if(!customers.isEmpty()) {
            System.out.println("\nSystem is detecting customers");
        }else
        {
            System.out.println("\nAll the customers were processed");
        }

        for (Customer c: customers)
        {
            System.out.println(c.toString()+" entering the station");
            if(c.getTicketNumber() == 0)
                c.setTicketNumber(FuelDispenser.issueTicket());

            System.out.println(c.getFirstName()+"-"+c.getNic()+" with "+ c.getVehicle().getVehicleType()+ " " +
                    "got the ticket-ticketno."+c.getTicketNumber());

        }
        System.out.println();


    }
    /**
     *
     * @param fuelDispensers
     * check and display which dispensers are active and the proper message about station status
     */
    public static void checkAndDisplayStatusOfStation(FuelDispenser[] fuelDispensers)
    {
        System.out.println("Printing Current Gas Station Status\n");
        ArrayList<FuelDispenser> activeDispensers = FuelDispenser.showActiveDispensers(fuelDispensers);
        ArrayList<DieselFuelDispenseManager> activeDieselDispensers = new ArrayList<>();
        ArrayList<OctaneFuelDispenseManager> activeOctaneDispensers = new ArrayList<>();

        for(FuelDispenser fd : activeDispensers)
        {
            if(fd instanceof DieselFuelDispenseManager)
            {
                activeDieselDispensers.add((DieselFuelDispenseManager)fd);
            }else if(fd instanceof OctaneFuelDispenseManager)
            {
                activeOctaneDispensers.add((OctaneFuelDispenseManager)fd);
            }
        }

        if (activeDispensers.size() == 0)
        {
            System.out.println("--- Gas Station is Closed ---");
        }
        else
        {
            System.out.println("--- "+activeDispensers.size()+" Dispenser(s) Active : Petrol92Octane - "+
                    activeOctaneDispensers.size()+ " Diesel - " + activeDieselDispensers.size() + " ---");
        }

    }

    public static void displayLoadedDataStatus(FuelDispenser[] fuelDispensers, ArrayList<Customer>  customers)
    {
        System.out.println("Printing Initialized Data");
        for(FuelDispenser fd : fuelDispensers)
        {
            if(fd.getDispenseWorker() == null)
            {
                System.out.println(fd);// +" not ready to dispense fuel"
            }
            else
            {
                System.out.println(fd);// +" is ready to dispense fuel";
            }
        }

        System.out.println();
        for(Customer c : customers)
        {
            System.out.println(c);

        }System.out.println();

    }

    public static ArrayList<Customer> initializeTheCustomerData()
    {
        System.out.println("Initializing users");
        //creating vehicles
        Vehicle v1 = new Vehicle("GU-2620", "N786543322", "car", "92Octane", 21);
        Vehicle v2 = new Vehicle("AB-1234", "B143509123", "public-transport", "diesel", 50);
        Vehicle v3 = new Vehicle("CB-2343", "D130951980", "three-wheeler", "92Octane", 30);

        //creating customers who own vehicles
        Customer customer1 = new Customer("20002770423v","cristiano", v1);
        Customer customer2 = new Customer("20012770423b","messi", v2);
        Customer customer3 = new Customer("20032770423c","neymar", v3);

        //customer deciding the fuel quantity needed
        customer1.getVehicle().setFuelQuantityNeeded(20);
        customer2.getVehicle().setFuelQuantityNeeded(38);
        customer3.getVehicle().setFuelQuantityNeeded(28);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;
    }

    public static FuelDispenser[] initializeTheGasStationData()
    {
        System.out.println("Initializing Gas Station");
        //creating FuelRepositories for gas stations
        FuelRepository octane92Repo = new FuelRepository("92Octane", 25000, 450);
        FuelRepository dieselRepo = new FuelRepository("diesel", 25000, 430);

        //creating FuelDispensers for the repositories
        //creating 4 92OctaneDispenser
        OctaneFuelDispenseManager petrolDispenser1 = new OctaneFuelDispenseManager(1, "car,van", 10, octane92Repo);
        OctaneFuelDispenseManager petrolDispenser2 = new OctaneFuelDispenseManager(2, "car,van,other", 10, octane92Repo);
        OctaneFuelDispenseManager petrolDispenser3 = new OctaneFuelDispenseManager(3, "three-wheeler", 10, octane92Repo);
        OctaneFuelDispenseManager petrolDispenser4 = new OctaneFuelDispenseManager(4, "motor-bike", 10, octane92Repo);
        //creating 3 DieselDispenser
        DieselFuelDispenseManager dieselDispenser1 = new DieselFuelDispenseManager(1, "public-transport", 10, dieselRepo);
        DieselFuelDispenseManager dieselDispenser2 = new DieselFuelDispenseManager(2, "other", 10, dieselRepo);
        DieselFuelDispenseManager dieselDispenser3 = new DieselFuelDispenseManager(3, "other", 10, dieselRepo);

        //creating Worker who is responsible for dispensers
        DispenseWorker worker1 = new DispenseWorker("20012550232v", "justin", 1001, petrolDispenser1);
        DispenseWorker worker2 = new DispenseWorker("20022650232v", "selena", 1002, petrolDispenser2);
        DispenseWorker worker3 = new DispenseWorker("200327502321", "hailey", 1003, dieselDispenser1);
        //new worker is joining and assigning him to the job
        DispenseWorker worker4 = new DispenseWorker("200428502321", "ariana", 1004);
        worker4.setFuelDispenser(dieselDispenser2);

        return new FuelDispenser[] {petrolDispenser1, petrolDispenser2, petrolDispenser3, petrolDispenser4,
        dieselDispenser1, dieselDispenser2, dieselDispenser3};

    }
}
