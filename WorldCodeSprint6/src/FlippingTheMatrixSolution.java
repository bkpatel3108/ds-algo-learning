import java.util.Scanner;

public class FlippingTheMatrixSolution {
	public static void main(String[] args) {
		Integer q = null; // No of queries
		Scanner in = new Scanner(System.in);
		q = in.nextInt();
		// repeat process for q times
		for (int cnt = 0; cnt < q; cnt++) {
			Integer n = null; // matrix quadrant dimention
			Integer mSize = null; // matrix size
			Integer[][] m = null; // input matrix
			//Integer[][] u = null; // upper-left quadrant
			Integer maxSum = 0;
			n = in.nextInt();
			mSize = 2 * n;
			m = new Integer[mSize][mSize];
			//u = new Integer[n][n];

			for (int i = 0; i < mSize; i++) {
				for (int j = 0; j < mSize; j++) {
					m[i][j] = in.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int ele = m[i][j];
					int adjRow = (mSize-1) - i;
					int adjCol = (mSize-1) - j;
					if (m[i][adjCol] > ele)
						ele = m[i][adjCol];
					if (m[adjRow][j] > ele)
						ele = m[adjRow][j];
					if (m[adjRow][adjCol] > ele)
						ele = m[adjRow][adjCol];

					maxSum = maxSum + ele;
				}
			}

			System.out.println(maxSum);
		}

	}
}
