package hackerrank.dynamic;

import java.util.Scanner;

public class TheMaximumSubarraySolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int programRepeat = in.nextInt();
		for (int cnt = 0; cnt < programRepeat; cnt++) {
			int n = in.nextInt();
			long[] A = new long[n];
			for (int i = 0; i < n; i++) {
				A[i] = in.nextLong();
			}

			long[][] L = new long[n + 1][n + 1];
			Long maxCont = null;
			Long[] sumL = new Long[n + 1];

			for (int i = 0; i < n + 1; i++) {
				L[0][i] = 0;
				L[i][0] = 0;
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = i; j < n + 1; j++) {
					L[i][j] = L[i][j - 1] + A[j - 1];
					if (sumL[i] != null) {
						sumL[i] = sumL[i] > L[i][j] ? sumL[i] : L[i][j];
					} else {
						sumL[i] = L[i][j];
					}
				}
				if (maxCont != null) {
					maxCont = maxCont > sumL[i] ? maxCont : sumL[i];
				} else {
					maxCont = sumL[i];
				}
			}
			System.out.print(maxCont + " ");

			Long maxNonCont = null;
			// require if all are minus values
			Long maxNonContNo = A[0];
			for (int i = 0; i < n; i++) {
				if (A[i] > 0) {
					maxNonCont = maxNonCont != null ? maxNonCont + A[i] : A[i];
				}
				maxNonContNo = maxNonContNo > A[i] ? maxNonContNo : A[i];
			}

			if (maxNonCont == null) {
				maxNonCont = maxNonContNo;
			}
			System.out.println(maxNonCont);
		}
	}
}
