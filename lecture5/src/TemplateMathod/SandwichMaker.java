package TemplateMathod;

public class SandwichMaker {
    public  static void  tryy(String A,String B){
        if(A==B){
            System.out.println("true");
            }


    }
    public static void main(String[] args) {
        Sandwich sandwich1 = new ChickenSandwich();
        sandwich1.makeSandwich();

        Object sandwichobject = new ChickenSandwich();
        Sandwich sandwich3=new VegetableSandwich();
        sandwich3.makeSandwich();
        Sandwich sandwich4=new CheeseSandwich();
        sandwich4.makeSandwich();

        String a="abc";
        String b="abc";

        tryy(a,b);



        //for Object
    }
}
