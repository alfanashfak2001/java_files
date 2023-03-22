package exercise;

public class FultimeEmployee extends Employee{
    private double basicSalary,bonus;

    public FultimeEmployee(){
        super();
        this.basicSalary=1.0;
        this.bonus=1.0;

    }
    public void Calculatesalary(){
        System.out.println("salary is "+this.basicSalary+this.bonus);
    }
}
