package TemplateMathod;

public class CheeseSandwich extends Sandwich {

    @Override
    public void addChicken() {

    }

    @Override
    public void addVegetables() {

    }

    @Override
    public void addCheese() {
        System.out.println("add cheese");
    }

    @Override
    public boolean customerWantsVegetables() {
        return false;

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
