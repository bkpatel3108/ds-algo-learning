import java.util.Scanner;

public class CombinationLockSolution {

	public static void main(String[] args) {
		Integer n = 5; // No of slots
		Integer l = 0; // lower bound
		Integer h = 9; // higher bound
		Integer m = (l + h) / 2; // mid value
		Integer[] initConfig = new Integer[5]; // Initial Configuration
		Integer[] desiredConfig = new Integer[5]; // Desired Configuration
		Integer totalMoves = 0; // No of moves required

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			initConfig[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			desiredConfig[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			int moves = 0;
			if (desiredConfig[i] > initConfig[i]) {
				moves = desiredConfig[i] - initConfig[i];
				// circular direction
				if (moves > m) {
					moves = (initConfig[i] - l) + (h - desiredConfig[i]) + 1;
				}
			} else {
				moves = initConfig[i] - desiredConfig[i];
				// circular direction
				if (moves > m) {
					moves = (h - initConfig[i]) + (desiredConfig[i] - l) + 1;
				}
			}
			totalMoves = totalMoves + moves;
		}

		System.out.println(totalMoves);

	}

}
