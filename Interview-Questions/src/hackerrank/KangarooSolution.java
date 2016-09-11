package hackerrank;

import java.util.Scanner;

public class KangarooSolution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		int currentLocationX1 = x1;
		int currentLocationX2 = x2;
		boolean isLandAtSameLoc = false;

		// find x2 is catchable by x1
		boolean isX2Catchable = false;
		if (v2 < v1) {
			isX2Catchable = true;
			isLandAtSameLoc = false;
		}

		if (isX2Catchable == true) {
			while (currentLocationX1 <= currentLocationX2) {
				if (currentLocationX1 == currentLocationX2) {
					isLandAtSameLoc = true;
					break;
				}
				currentLocationX1 = currentLocationX1 + v1;
				currentLocationX2 = currentLocationX2 + v2;
			}
		}
		
		if (isLandAtSameLoc)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}
