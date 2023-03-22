package TemplateMathod;
//the template method pattern identifies steps of the algo and allows subclasses
//to change some methods
public abstract class Sandwich {

    // this does not change/ the child cannot change the process of making sandwich
    public final void makeSandwich(){
        cutBread();
        if(customerWantsChicken()){
            addChicken();
        }
        if(customerWantsCheese()){
            addCheese();
        }
        if(customerWantsVegetables()){
            addVegetables();
        }
        wrap();
    }

    public void cutBread(){
        System.out.println("Bread is cut");
    }
    public void wrap(){
        System.out.println("sandwich is wrapped");
    }
    //the methods must be overridden by the child classes
    public abstract void addChicken();
    public abstract void addVegetables();
    public abstract void addCheese();
    //these are hooks - if the user wants can override
    // if the method is not an abstract method overriding is not compulsory
    public boolean customerWantsChicken(){
        return true;
    }
    public boolean customerWantsCheese(){
        return true;
    }
    public boolean customerWantsVegetables() {
        return false;
    }

}
