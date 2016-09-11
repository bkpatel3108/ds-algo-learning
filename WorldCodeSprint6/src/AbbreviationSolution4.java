import java.util.Scanner;

public class AbbreviationSolution4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer q = in.nextInt(); // No of queries

		for (int cnt = 0; cnt < q; cnt++) {
			String a = in.next();
			String aUpper = a.toUpperCase();
			char[] b = in.next().toCharArray();
			boolean notFound = false;

			for (int i = 0; i < b.length; i++) {
				int idx = a.indexOf(b[i]);
				if (idx != -1) {
					aUpper = aUpper.substring(0, idx) + aUpper.substring(idx + 1);
					a = a.substring(0, idx) + a.substring(idx + 1);
				} else {
					idx = aUpper.indexOf(b[i]);
					if (idx != -1) {
						aUpper = aUpper.substring(0, idx) + aUpper.substring(idx + 1);
						a = a.substring(0, idx) + a.substring(idx + 1);
					} else {
						notFound = true;
						break;
					}
				}
			}

			if (notFound == false) {
				a = a.replaceAll("[a-z]", "");
				if (a.equals("")) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				System.out.println("NO");
			}

		}
	}
}
