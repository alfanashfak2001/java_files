package TemplateMathod;

public class ChickenSandwich extends Sandwich {

    //these methods must be overridden by child
    @Override
    public void addChicken() {
        System.out.println("add chicken");
    }

    @Override
    public void addCheese() {
        System.out.println("add cheese");
    }

    @Override
    public void addVegetables() {
        System.out.println("add vegetables");
    }
    //depending on the requirment of the child below method is overridden
    @Override
    public boolean customerWantsVegetables() {
        return true;
    }

    @Override
    public boolean customerWantsCheese() {
        return true;
    }

    @Override
    public boolean customerWantsChicken() {
        return false;
    }

}
