package GasStationApplication;

public class AdminEmployee extends Employee {
    private double PaymentPerMonth;

    //Constructor
    public AdminEmployee(String FirstName,String LastName,int EmpId,int WorkingHoursPerDay,String Password,double PaymentPerMonth) {
        super(FirstName,LastName,EmpId,WorkingHoursPerDay,Password);
        this.PaymentPerMonth=PaymentPerMonth;
    }
    //getters and setters

    public double getPaymentPerMonth() {
        return PaymentPerMonth;
    }

    public void setPaymentPerMonth(double paymentPerMonth) {
        PaymentPerMonth = paymentPerMonth;
    }



}
