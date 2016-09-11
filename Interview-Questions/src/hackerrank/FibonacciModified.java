package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BigInteger t1 = in.nextBigInteger();
        BigInteger t2 = in.nextBigInteger();
        int n = in.nextInt();
        BigInteger tn = null;
        for(int i=3; i<=n; i++){
            tn = new BigInteger(t1.toString());
            tn.add(t2.pow(2));
            t1 = t2;
            t2 = tn;
        }
        
        System.out.println(tn);
        
    }
}
