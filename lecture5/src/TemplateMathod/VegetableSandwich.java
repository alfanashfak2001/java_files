package TemplateMathod;

public class VegetableSandwich extends Sandwich {
    //do vegetable sandwich


    @Override
    public void addVegetables() {
        System.out.println("add vegetables");
    }

    @Override
    public void addCheese() {
        System.out.println("add cheese");

    }

    @Override
    public void addChicken() {
        System.out.println("add chicken");
    }

    @Override
    public boolean customerWantsCheese() {
        return true;
    }

    @Override
    public boolean customerWantsVegetables() {
        return true;
    }
}
