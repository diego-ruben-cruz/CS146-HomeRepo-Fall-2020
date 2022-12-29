package divisionByTwo;

public class DividingMain {
	
	public static void main(String[] args) {
		
		int counterOne = 0;
		
		int counterTwo = 0;
		
		float toDivOne = 1000;
		
		float toDivTwo = 1000000;
		
		System.out.println("Running...");
		System.out.println();
		
		System.out.println("Working 1000/2...");
		while (toDivOne > 1){
			toDivOne = toDivOne/2;
			counterOne++;
			System.out.println(toDivOne);
		}
		System.out.println();
		
		System.out.println("Working 1000000/2...");
		while (toDivTwo > 1){
			toDivTwo = toDivTwo/2;
			counterTwo++;
			System.out.println(toDivTwo);
		}
		
		System.out.println();
		System.out.println("Results:");
		System.out.println();
		System.out.println("1000/2 is: " + counterOne);
		System.out.println();
		System.out.println("1000000/2 is: " + counterTwo);
	}

}