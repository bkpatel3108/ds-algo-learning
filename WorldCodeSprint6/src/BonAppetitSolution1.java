import java.util.Scanner;

public class BonAppetitSolution1 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int bActual = 0;
	
		for (int i = 0; i < n; i++) {
			int c = in.nextInt();
			// calculate bActual
			if (i != k) {
				bActual = bActual + c;
			}
		}
		bActual = bActual/2;
		int bCharged = in.nextInt();

		//calculate bReturn
		int bReturn = bCharged - bActual;
		
		if(bReturn != 0){
			System.out.println(bReturn);
		}else{
			System.out.println("Bon Appetit");
		}
		in.close();

	}
}
