package exercise;

public class ParttimeEmployee {
    private double ratePerHour;
    private int noOfHours;

    public ParttimeEmployee(){
        super();
        this.ratePerHour=1.0;
        this.noOfHours=1;

    }
    public void Calculatesalary(){
        System.out.println("salary is "+this.ratePerHour*noOfHours);

        //consider abt overload
    }
}
