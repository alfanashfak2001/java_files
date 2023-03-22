package GasStationApplication;

import java.util.ArrayList;

public class DieselDispenserManager  extends DispenserManagers implements FuelDispenseManager{
    private final String FuelType;


    public DieselDispenserManager(String NameOfDispenserManager,double priceperliter,String nameOfDispenser) {
        super(NameOfDispenserManager,priceperliter);
        this.FuelType="Diesel";
        setManagingDispensers(new Dispenser(nameOfDispenser));
    }


    @Override
    public void AddNewDispenser(String nameOfdispenser) {
        setManagingDispensers(new Dispenser(nameOfdispenser));
    }

    @Override
    public boolean ContinueFuelSupply() {
        return true;
    }

    @Override
    public String DisplayLackFuelMessage() {
        String message= "Diesel pumping stopped due to lack of Diesel ";
        return message;
    }

    public String DisplayFuelAmountInRepositor(Double d){
        String message="remaining Diesel is "+d;
        return message;
    }



    @Override
    public void GetDispenserNames() {
        int i = getManagingDispensers().size();
        while(i-1>-1){
            System.out.println(getManagingDispensers().get(i-1).getNameOfDispenser());
            i--;
        }
    }
}
