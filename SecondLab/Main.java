public class Main{

	public static void main(String[] args){
	

		for(int i = 1; i <= 500; i++){
			
			for(int j = 1; j <=500; j++){

				for(int k = 1; k <= 500; k++){

					boolean pythagoricallyValid = ((k * k) == ( (i * i) + (j * j) ));
					if(pythagoricallyValid){


						System.out.println("\n\nBase = " + i + "\t Perpendicular = " + j + "\t hypotenuse = " + k);						
						System.out.print("____________________________________________________________________________\n");
						

						}						

					}

			}


		}


	}



}
