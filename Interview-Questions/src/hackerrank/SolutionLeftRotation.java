package hackerrank;

import java.util.Scanner;

public class SolutionLeftRotation {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		// get size of array
		int n = in.nextInt();
		int[] arr = new int[n];
		// get no of left operations
		int d = in.nextInt();
		d = d % n;
		// get elements of array
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		// d left roatate operation with performance of O(n)

		// swap d-1th element with n-1th element of array
		// as array starts form index 0
		int temp = arr[d - 1];
		arr[d - 1] = arr[n - 1];
		arr[n - 1] = temp;

		if (n % d != 0) {
			int currentEle = (n - 1);
			int swapIndex;
			for (int i = 0; i < n - 2; i++) {
				temp = arr[d - 1];
				if (currentEle > (d - 1)) {
					swapIndex = currentEle - (d % n);
				} else {
					swapIndex = n - (d - currentEle);
				}
				arr[d - 1] = arr[swapIndex];
				arr[swapIndex] = temp;
				currentEle = swapIndex;
			}
		} else {

			// now swap right side elements of d-1th element with left side
			// elements
			for (int i = 0; (d - 1) + (i + 1) < n - 1; i++) {
				temp = arr[(d - 1) + (i + 1)];
				arr[(d - 1) + (i + 1)] = arr[i];
				arr[i] = temp;
			}

		}
		for (int arr_i = 0; arr_i < n; arr_i++) {
			System.out.print(arr[arr_i] + " ");
		}
	}
}
