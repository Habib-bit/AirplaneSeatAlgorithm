
public class Main {
	public static void main(String args[]){
		
		 int[][] seats = { { 3,2 }, { 4, 3 },{2,3},{3,4} };
		 int passengers = 30;
		 System.out.println("Seats:: [[3,2],[4,3],[2,3],[3,4]] \nPassengers :: 30");
		 AirplaneSeating.allocateSeats(seats, passengers);
		 
		 //testCase1();
		 //testCase2();
		 //testCase3();
	}
	
	
	public static void testCase1(){
		int[][] seats = { { 3,2 },{1,2}};
		 int passengers = 2;
		 
		 System.out.println("Seats:: [[3,2],[1,2]] \nPassengers :: 2");
		 AirplaneSeating.allocateSeats(seats, passengers);
	}
	
	public static void testCase2(){
		int[][] seats = { { 1,8 }};
		 int passengers = 6;
		 
		 System.out.println("Seats:: [[1,8]] \nPassengers :: 6");
		 AirplaneSeating.allocateSeats(seats, passengers);
	}
	
	public static void testCase3(){
		int[][] seats = { { 1,1 },{ 1,1 },{ 1,1 }};
		 int passengers = 2;
		 
		 System.out.println("Seats:: [[1,1],[1,1],[1,1]] \nPassengers :: 2");
		 AirplaneSeating.allocateSeats(seats, passengers);
	}
}
