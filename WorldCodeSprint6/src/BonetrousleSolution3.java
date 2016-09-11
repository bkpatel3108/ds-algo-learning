import java.math.BigInteger;
import java.util.Scanner;

public class BonetrousleSolution3 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Integer t = in.nextInt(); // No of tours

		for (long cnt = 0; cnt < t; cnt++) {
			BigInteger n = in.nextBigInteger();// the number of sticks to buy
			BigInteger k = in.nextBigInteger(); // the number of boxes the store
												// has for sale
			BigInteger b = in.nextBigInteger(); // the number of boxes to buy
			BigInteger mod = new BigInteger(n.toString());
			mod = mod.remainder(b);
			//System.out.println(mod);
			BigInteger m = new BigInteger(n.toString());
			m = m.divide(b);
			if (mod.equals(new BigInteger("0"))) {
				if (b.remainder(new BigInteger("2")).equals(new BigInteger("0"))) {
					BigInteger l = m.subtract(m.divide(new BigInteger("2")));
					BigInteger h = m.add(m.divide(new BigInteger("2")));
					if (l.compareTo(new BigInteger("1")) >= 0 && h.compareTo(k) <= 0) {
						for (BigInteger i = new BigInteger(l.toString()); i
								.compareTo(m.subtract(new BigInteger("1"))) <= 0; i.add(new BigInteger("1"))) {
							System.out.print(i);
							if (i.compareTo(m.subtract(new BigInteger("1"))) < 0) {
								System.out.print(" ");
							}
						}
						for (BigInteger i = new BigInteger(m.toString()).add(new BigInteger("1")); i
								.compareTo(h) <= 0; i.add(new BigInteger("1"))) {
							System.out.print(i);
							if (i.compareTo(h) < 0) {
								System.out.print(" ");
							}
						}
					} else {
						System.out.print("-1");
					}
				}
//				else {
//					long l = m - (b / 2);
//					long h = m + (b / 2);
//					if (l >= 1 && h <= k) {
//						for (long i = l; i <= h; i++) {
//							System.out.print(i);
//							if (i < h) {
//								System.out.print(" ");
//							}
//						}
//					} else {
//						System.out.print("-1");
//					}
//				}
			}
			//System.out.println("a");
		}
	}
}
