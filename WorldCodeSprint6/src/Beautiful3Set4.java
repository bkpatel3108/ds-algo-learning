import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Beautiful3Set4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> beautifulSet = new ArrayList<String>();
		Set<Integer> xSet = new HashSet<Integer>();
		Set<Integer> ySet = new HashSet<Integer>();
		Set<Integer> zSet = new HashSet<Integer>();

		for (int x = 0; x <= n; x++) {

			for (int y = 0; y <= n; y++) {

				for (int z = 0; z <= n; z++) {
					if (!zSet.contains(z) && !xSet.contains(x) && !ySet.contains(y)) {
						//if (x != y && x != z && y != z) {
							int xyz = x + y + z;
							if (xyz == n) {
								beautifulSet.add(x + " " + y + " " + z);
								// System.out.println(x + " " + y + " "
								// +
								// z);
								xSet.add(x);
								ySet.add(y);
								zSet.add(z);
								// break outerloop;
							}
						//}
					}
				}
			}

		}
		System.out.println(beautifulSet.size());
		for (String s : beautifulSet) {
			System.out.println(s);
		}

	}
}
