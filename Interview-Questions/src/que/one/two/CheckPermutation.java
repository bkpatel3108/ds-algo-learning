package que.one.two;

public class CheckPermutation {

	public static boolean checkPermutation(String one, String two) {
		while (two.length() > 0) {
			String twoSub = two.substring(0, 1);
			Integer twoSubInd = one.indexOf(twoSub);
			if (twoSubInd == -1) {
				return false;
			}
			if (twoSubInd == 0) {
				one = one.substring(1);
			} else if (twoSubInd == one.length() - 1) {
				one = one.substring(0, one.length() - 1);
			} else {
				one = one.substring(0, twoSubInd) + one.substring(twoSubInd + 1, one.length());
			}
			two = two.substring(1);
		}
		return true;
	}
}
