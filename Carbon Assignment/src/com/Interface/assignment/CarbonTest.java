package com.Interface.assignment;

import java.util.ArrayList;

public class CarbonTest {

    public static void main(String[] args) {
	if (args.length < 3){
        System.out.println("Command Line Arguments not found");
        return;
    }
	int[] size = new int[args.length];
	for (int i = 0; i < args.length; i++){
            size[i] = Integer.parseInt(args[i]);
    }
        int totalCO2Generated = 0;
        ArrayList<CarbonFootprint> list = new ArrayList<>();

	list.add(0, new Building(size[0]));
	list.add(1, new Car(size[1]));
	list.add(2, new Bicycle(size[2]));

        for (CarbonFootprint item: list) {
            totalCO2Generated += item.getCarbonFootprint();
            if (item instanceof Building){
                System.out.println("A " + ((Building) item).getArea() + " sq feet house will generate " + item.getCarbonFootprint() + " gm of CO2\n");
            }
            if (item instanceof Car){
                System.out.println("A " + ((Car) item).getEngineCapacity() + " CC car will generate " + item.getCarbonFootprint() + " gm of CO2\n");
            }
            if (item instanceof Bicycle){
                System.out.println("A " + ((Bicycle) item).getGear() + " gear Bicycle will generate " + item.getCarbonFootprint() + " gm of CO2\n");
            }
        }
	System.out.println("Total CO2 generated is " + totalCO2Generated + " gm");

    }
}
class Building implements CarbonFootprint{
    private int area;
    public Building(int area){
        this.area = area;
    }

    @Override
    public int getCarbonFootprint() {
        return (area * 40);
    }

    public int getArea() {
        return area;
    }
}
class Car implements CarbonFootprint{
    private int engineCapacity;
    public Car(int engineCapacity){
        this.engineCapacity = engineCapacity;
    }

    @Override
    public int getCarbonFootprint() {
        return (10 * engineCapacity);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }
}
class Bicycle implements CarbonFootprint{
    private int gear;
    public Bicycle(int gear){
        this.gear = gear;
    }

    @Override
    public int getCarbonFootprint() {
        return gear;
    }

    public int getGear() {
        return gear;
    }

}
interface CarbonFootprint{
    int getCarbonFootprint();
}