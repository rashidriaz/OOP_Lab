package com.Abstract.assignment;

public class FruitTest {

    public static void main(String[] args) {
//        if (args.length < 4){
//            System.out.println("Command Line Arguments not found");
//            return;
//        }

        double[] weight = new double[4];
        Fruit[] fruits = new Fruit[4];
        double vitaminC = 0, antiOxidants = 0;
//        for (int i = 0; i < 4; i++){
//            weight[i] = Double.parseDouble(args[i]);
//        }
        weight[0] = 100;
        weight[1] = 110;
        weight[2] = 400;
        weight[3] = 5000;

	fruits[0] = new Kinu(weight[0]);
	fruits[1] = new Malta(weight[1]);
	fruits[2] = new Kharbooza(weight[2]);
	fruits[3] = new Tarbooz(weight[3]);
	vitaminC = ((Kinu)fruits[0]).getVitaminC() + ((Malta)fruits[1]).getVitaminC();
	antiOxidants = ((Kharbooza)fruits[2]).getAntiOxidants() + ((Tarbooz)fruits[3]).getAntiOxidants();
        System.out.println("You will get " + vitaminC + "gm of Vitamin C");
        System.out.println("You will get " + antiOxidants + "gm of AntiOxidants");
    }
}
abstract class Fruit {
    private double weight;

    public Fruit(double weight){
        this.weight = weight;
    }

    abstract String getColor();

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
abstract class Citrus extends Fruit{
    public Citrus(double weight){
        super(weight);
    }
    abstract double getVitaminC();
}
class Malta extends Citrus {
    public Malta(double weight){
        super(weight);
    }

    @Override
    public double getVitaminC() {
        return 0.02 * getWeight();
    }

    @Override
    public String getColor() {
        return "orange";
    }
}
class Kinu extends Citrus{
    public Kinu(double weight){
        super(weight);
    }

    @Override
    public double getVitaminC() {
        return 0.03 * getWeight();
    }

    @Override
    public String getColor() {
        return "orange";
    }
}
abstract class Melon extends Fruit{
    public Melon(double weight){
        super(weight);
    }
    abstract double getAntiOxidants();
}
class Kharbooza extends Melon {
    public Kharbooza(double weight){
        super(weight);
    }

    @Override
    public double getAntiOxidants() {
        return 0.00001 * getWeight();
    }

    @Override
    public String getColor() {
        return "Yellow";
    }
}
class Tarbooz extends Melon {
    public Tarbooz(double weight){
        super(weight);
    }

    @Override
    public double getAntiOxidants() {
        return 0.00008 * getWeight();
    }

    @Override
    String getColor() {
        return "Green";
    }
}