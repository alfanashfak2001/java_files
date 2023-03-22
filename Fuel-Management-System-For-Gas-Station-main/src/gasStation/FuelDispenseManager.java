package gasStation;

import user.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public interface FuelDispenseManager {
    boolean isActiveDispenser(boolean printMessage);
    static int issueTicket() {
        return 0;
    }
    void displayFreePositions();
    void addAVehicleToQueue();
    String[] dispenseFuel(Customer customer, Scanner input);
    void updateTheFuelIssuedByADispenser(String[] details);
    void updateTotalFuelIssuedByAFuelTypePerDay(String[] details);
    void getThePaymentForFuel(String[] details, Customer customer,Scanner input);
    void removeAVehicleFromQueue(String message);

    static void printStatistics(FuelDispenser[] fuelDispensers)
    {
        //Below hash map is used to store the total fuel amount of each dispenser regardless of the vehicle category
        Map<FuelDispenser, Integer> totalFuelAmountStored = new LinkedHashMap<>();
        Set<FuelRepository> allTheFuelRepositories = new LinkedHashSet<>();
        //Below hash map is used to store the total fuel amount of each category which having the same fuel type
        Map<String, Integer> vehicleCategories = new LinkedHashMap<>();


        //SECTION 1
        System.out.println();
        System.out.println("Total fuel dispensed per vehicle category type per fuel type".toUpperCase());
        //The total fuel dispensed per vehicle category type per fuel type
        //So This is not categorized using the date....
        for(FuelDispenser fd : fuelDispensers)
        {
            int totalFuelAmount = 0;

            for(Integer amounts : fd.getFuelAmountDispensed().values())
            {
                totalFuelAmount += amounts;
            }
            String data = fd.getVehicleType()+"|"+fd.getFuelRepo().getFuelType() + ":";
            //these below set of statements used to categorize the same vehicle types in different dispensers -
            //like diesel dispensers have 2 other type of dispensers;
            if(vehicleCategories.containsKey(data))
            {
                int i = vehicleCategories.get(data);
                vehicleCategories.put(data, i+totalFuelAmount);
            }
            else {
                vehicleCategories.put(data, totalFuelAmount);
            }

            totalFuelAmountStored.put(fd, totalFuelAmount);
        }
        //Now print the gathered data of categories from above loop section;
        for(String data : vehicleCategories.keySet())
        {
            System.out.println(data + vehicleCategories.get(data) + " liter(s)");
        }
        System.out.println();


        //SECTION 2
        //The vehicle that received the largest amount of fuel for the day and the type of
        //fuel received.
        String largestAmountVehicle = null, largestAmountType = null;
        int largestAmount = 0;
        for(FuelDispenser fd : fuelDispensers)
        {
            for(LocalDateTime dateTime : fd.getFuelAmountDispensed().keySet())
            {
                //In here we have to check whether the date is today
                LocalDate date = dateTime.toLocalDate();//this converts from this 2022-12-11T06:48:09.877378400=2 to this 2022-12-11
                LocalDate today = LocalDate.now();

                if((fd.getFuelAmountDispensed().get(dateTime) > largestAmount) && (date.equals(today)))
                {
                    largestAmount = fd.getFuelAmountDispensed().get(dateTime);
                    largestAmountVehicle = fd.getVehicleType();
                    largestAmountType = fd.getFuelRepo().getFuelType();
                }
            }
        }
        System.out.println("The vehicle that received largest amount of fuel : "+ largestAmountVehicle+
                " - Fuel type : "+ largestAmountType + " - " + " Quantity : "+largestAmount +" liters");
        System.out.println();


        //SECTION 3
        //the total number of vehicles served by each dispenser along with the
        //amounts of fuel and the total income per dispenser
        for(FuelDispenser fd : totalFuelAmountStored.keySet())
        {
            System.out.println("Dispenser no."+fd.getDispenserNumber()+"-"+fd.getFuelRepo().getFuelType()+" for the "+
                    fd.getVehicleType() + " | served vehicles : "+ fd.getFuelAmountDispensed().size() +
                    " | amount of fuel dispensed : "+ totalFuelAmountStored.get(fd) + " | total income "+
                    totalFuelAmountStored.get(fd)*fd.getFuelRepo().getPricePerLiter());//total income by this dispenser

            allTheFuelRepositories.add(fd.getFuelRepo());//adding the repo ,so we can use in below manipulations;
        }
        System.out.println();


        //SECTION 4
        //the total income of the Gas Station per day per fuel type and the remaining stock at close
        System.out.println("GAS STATION STATISTICS\n");
        for(FuelRepository fr : allTheFuelRepositories)
        {
            for(LocalDate date : fr.getDispensedCapacityPerDay().keySet())
            {
                System.out.println("Dispensed capacity for "+fr.getFuelType()+" on "+ date +" - "+
                        fr.getDispensedCapacityPerDay().get(date) +
                        " liters - total profit : " + fr.getDispensedCapacityPerDay().get(date) * fr.getPricePerLiter() +
                        " remaining "+ fr.getCapacity() + " liters capacity in this repository...");

            }
        }
    }
}

