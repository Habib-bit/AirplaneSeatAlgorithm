
public class AirplaneSeating {
	
	public static int airplaneSeats[][];
	public static int lastPassengerNumber = 1;
	
	public static void main(String args[]){
		
		 int[][] seats = { { 3,2 }, { 4, 3 },{2,3},{3,4} };
		 int passengers = 30;
		 allocateSeats(seats, passengers);
	}
	
	public static void allocateSeats(int seats[][], int passengers){
		int totalRows = 0;
		int totalColumns = 0;
		for(int i=0 ; i<seats.length ; i++){
			totalRows = totalRows + seats[i][0];
			if(totalColumns < seats[i][1])
				totalColumns = seats[i][1];
		}
		
		airplaneSeats = new int[totalColumns][totalRows];
		
		//Initializing array with -1 where seats are not present and -2 where the seats are aisle seats
		airplaneSeats = initializeSeats(airplaneSeats, seats);
		
		//Filling Aisle Side seats
		airplaneSeats = fillAisleSeats(airplaneSeats, seats, passengers);
		
		//Method to fill window seats
		airplaneSeats = fillWindowSeats(airplaneSeats, passengers);
		
		//Fill remaining Seats
		airplaneSeats = fillRemainingSeats(airplaneSeats, passengers);
		
		printSeats(airplaneSeats);
	}
	
	public static int[][] initializeSeats(int airplaneSeats[][], int seats[][]){
		
		int currentCol = 0;
		int k = 0;
		for(int i=0 ; i<seats.length ; i++){
			for(k = currentCol ; k < (currentCol+seats[i][0]) ; k++){
				if(k == currentCol || k == (currentCol+seats[i][0] -1)){
					
					for(int j=0 ; j<airplaneSeats.length; j ++){
						if(k!=0 && k!=airplaneSeats[j].length-1){
							airplaneSeats[j][k] = -2;
						}
					}
				}
				for(int j=seats[i][1] ; j<airplaneSeats.length; j ++){
					airplaneSeats[j][k] = -1;
				}
			}
			currentCol = k;
		}
		
		//printSeats(airplaneSeats);
		
		return airplaneSeats;
	}
	
	public static int[][] fillAisleSeats(int airplaneSeats[][], int seats[][], int passengers){
		for(int i=0 ; i<airplaneSeats.length ; i++){
			for(int j=0 ; j<airplaneSeats[i].length ; j++){
				if(airplaneSeats[i][j] == -2 && lastPassengerNumber <=passengers){
					airplaneSeats[i][j] = lastPassengerNumber;
					lastPassengerNumber++;
				}
			}
		}
		//printSeats(airplaneSeats);
		
		return airplaneSeats;
	}
	
	public static int[][] fillWindowSeats(int airplaneSeats[][], int passengers){
		for(int i=0 ; i<airplaneSeats.length ; i++){
			for(int j=0 ; j<airplaneSeats[i].length ; j++){
				
				if((j == 0 || j == airplaneSeats[i].length -1) && airplaneSeats[i][j] != -1){
					if(lastPassengerNumber <=passengers){
						airplaneSeats[i][j] = lastPassengerNumber;
						lastPassengerNumber++;
					}
				}
				
			}
		}
		
		//printSeats(airplaneSeats);
		
		return airplaneSeats;
	}
	
	public static int[][] fillRemainingSeats(int airplaneSeats[][], int passengers){
		
		for(int i=0 ; i<airplaneSeats.length ; i++){
			for(int j=0 ; j<airplaneSeats[i].length ; j++){
				if(airplaneSeats[i][j] == 0 && lastPassengerNumber <=passengers){
					airplaneSeats[i][j] = lastPassengerNumber;
					lastPassengerNumber++;
				}
			}
		}
		return airplaneSeats;
	}
	
	public static void printSeats(int airplaneSeats[][]){
		
		for(int i=0 ; i<airplaneSeats.length ; i++){
			for(int j=0 ; j<airplaneSeats[i].length; j ++){
				if(airplaneSeats[i][j] != -1){
					System.out.print(airplaneSeats[i][j] + "\t");
				}
				else{
					System.out.print(" \t");
				}
			}
			System.out.println("");
		}
	}
}
