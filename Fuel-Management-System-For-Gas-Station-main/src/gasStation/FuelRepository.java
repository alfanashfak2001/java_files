package gasStation;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class FuelRepository {
    private String fuelType;
    private int capacity;//initially creating capacity with 25000 liters when dispensing this capacity is decreasing by liters;
    private int pricePerLiter;
    private Map<LocalDate, Integer> dispensedCapacityPerDay = new LinkedHashMap<>();//LocalDate object means it is like : 2022-12-04
                                                                                 //which contains date in above format yyyy-MM-dd

    public FuelRepository(String fuelType, int capacity, int pricePerLiter) {
        this.fuelType = fuelType;
        this.capacity = capacity;
        this.pricePerLiter = pricePerLiter;
    }

    public FuelRepository(String fuelType, int capacity, int pricePerLiter, Map<LocalDate, Integer> dispensedCapacityPerDay) {
        this.fuelType = fuelType;
        this.capacity = capacity;
        this.pricePerLiter = pricePerLiter;
        this.dispensedCapacityPerDay = dispensedCapacityPerDay;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUsedRepoCapacity()
    {
        final int INITIAL_CAPACITY = 25000;
        return INITIAL_CAPACITY - capacity;//therefore we can get the used capacity by subtracting remaining capacity
    }

    public void refillCapacity(int quantityLiters)
    {
        if (capacity+quantityLiters < 25000)//because maximum space available is 25000 liters
        {
            capacity += quantityLiters;
            System.out.println(fuelType+" repository re-filled by "+quantityLiters+" liters(s)");
        }
        else
        {
            System.out.println(fuelType+" repository cannot re-filled by "+quantityLiters+" liter(s)" +
                    "because already "+capacity+" liter(s) available out of 25000 liters");
        }
    }

    /**
     * -below method is used to refill the capacity by a random amount;
     */
    public void refillCapacity()
    {
        int maximum = 25000-capacity;
        int minimum = 15000;
        int quantityLiters = (int)Math.floor(Math.random()* (maximum-minimum+1))+minimum;//Math.floor(Math.random() * (max - min + 1) ) + min;

        refillCapacity(quantityLiters);

    }

    public synchronized void supplyFromRepoCapacity(int fuelQuantityNeeded)
    {
        //first reduce the capacity from the repo for the needed quantity
        capacity -= fuelQuantityNeeded;

        //then update the dispensed capacity per day
        LocalDate date = LocalDate.now(); // Create date object yyyy-MM-dd

        if(dispensedCapacityPerDay.containsKey(date))
        {//if the date is already in the map we have to change the value for that particular date
            int alreadyConsumedAmountForTheDay = dispensedCapacityPerDay.get(date);
            alreadyConsumedAmountForTheDay += fuelQuantityNeeded;
            dispensedCapacityPerDay.put(date, alreadyConsumedAmountForTheDay);
        }
        else
        {
            dispensedCapacityPerDay.put(date, fuelQuantityNeeded);
        }


    }

    public int getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(int pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public synchronized Map<LocalDate, Integer> getDispensedCapacityPerDay() {
        return dispensedCapacityPerDay;
    }

    public void setDispensedCapacityPerDay(Map<LocalDate, Integer> dispensedCapacityPerDay) {
        this.dispensedCapacityPerDay = dispensedCapacityPerDay;
    }

    // not needed for more methods to dispensedCapacityPerDay since this is manipulated through
    // supplyFromRepoCapacity method above;

    public synchronized boolean isLowLevel()
    {
        return capacity <= 500;
    }

}
