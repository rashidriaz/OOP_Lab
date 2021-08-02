//Author: Rashid Riaz FA19_BSE_081

public class S1{

	public static void main(String[] args){
	
		if(args.length < 1){
			System.out.println("Please Enter Some Integer Values.");
		}else{
			int[] numbers = new int[args.length];
			int positiveNumberCount = 0, negativeNumberCount = 0, zeroCount = 0;
			double sum = 0, average = 0;
			
			for(int i = 0; i < args.length; i++){
				try{
					numbers[i] = Integer.parseInt(args[i]);
				}catch(NumberFormatException e){
					System.out.println("\n" + e + "\n");
					continue;
				}
				if(numbers[i] < 0){
					negativeNumberCount++;
				}else if(numbers[i] > 0){
					positiveNumberCount++;
				}else{
					zeroCount++;
				}
				sum += numbers[i];
			}
			average = sum / args.length;
			
			System.out.println("There were " + positiveNumberCount + " positive numbers");
			System.out.println("There were " + negativeNumberCount + " negative numbers");
			System.out.println("There were " + zeroCount + " zeros");
			System.out.printf("The sum of all numbers is %.1f\n", sum);
			System.out.printf("The average is %.1f", average);
			
		
		
		
		
		}	
	
	
	
	}



}