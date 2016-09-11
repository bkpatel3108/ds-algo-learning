import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FunctionalPalindromes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // n
		int q = in.nextInt(); // q
		String s = in.next(); // input string
		List<String> pList = new ArrayList<String>();
		// char[] c = s.toCharArray();
		//
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// System.out.println("i>" + i + "j>" + j);
				String str = s.substring(i, j);
				String rev = new StringBuilder(str).reverse().toString();

				if (str.equals(rev)) {
					pList.add(str);
				}
				// System.out.println(str);
			}
		}
		Collections.sort(pList);
		// pList.sort(c);
		// System.out.println(pList);

		BigInteger m = new BigInteger("10");
		m = m.pow(9);
		m = m.add(new BigInteger("7"));

		BigInteger[] aPow = new BigInteger[n];
		for (int i = 0; i < q; i++) {
			int k = in.nextInt(); // input k
			try {
				String str = pList.get(k - 1);
				char[] c = str.toCharArray();
				BigInteger w = new BigInteger("0");
				for (int cnt = 1; cnt <= str.length(); cnt++) {
					Integer ch = (int) c[cnt - 1];
					BigInteger al = null;
					int l = str.length() - cnt;
					if (aPow[l] != null) {
						al = aPow[l];
					} else {
						al = new BigInteger("100001");
						al = al.pow(l);
						aPow[l] = new BigInteger(al.toString());
					}

					al = al.multiply(new BigInteger(ch.toString()));
					w = w.add(al);

				}
				System.out.println(w.remainder(m));

			} catch (IndexOutOfBoundsException ie) {
				System.out.println("-1");
			}
		}
	}
}
