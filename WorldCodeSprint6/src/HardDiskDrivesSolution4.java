import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HardDiskDrivesSolution4 {
	public static void main(String[] args) {
		Integer n = null; // No of primary hard disk and backup hard disk
		Integer c = null; // No of computers
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		c = in.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		long[] ab = new long[n];
		List[] abc = new List[c];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
			b[i] = in.nextLong();
		}
		Long maxN = null;
		Long minN = null;

		for (int i = 0; i < n; i++) {
			long sum = a[i] + b[i];
			ab[i] = sum;
			if (maxN == null && minN == null) {
				maxN = sum;
				minN = sum;
			} else {
				maxN = sum > maxN ? sum : maxN;
				minN = sum < minN ? sum : minN;
			}
		}
		
		double cPtsInterval = (Math.abs(maxN) +  Math.abs(minN)) / (double)c;
		double lowerLimit = minN;
		int cpCtr = 0;
		Set<Integer> cpSet = new HashSet<Integer>();
		for(double i=minN+cPtsInterval; i<=maxN; i=i+cPtsInterval,cpCtr++){
			List<Integer> cpList = new ArrayList<Integer>();
			for (int k = 0; k < n; k++) {
				if(ab[k] <=i && ab[k] >= lowerLimit){
					cpList.add(k);
					cpSet.add(k);
				}
			}
			abc[(int) cpCtr] = cpList;
			lowerLimit = i;
		}
		
		for (int i = 0; i < n; i++) {
			List<Integer> cpList = abc[c-1];
			if(cpList == null){
				cpList = new ArrayList<Integer>();
				abc[c-1] = cpList;
			}
			if(!cpSet.contains(i)){
				cpList.add(i);
			}
		}
		//allocate remaing computer to last
		
		//System.out.println(abc);
		
		//place computes
		long totalLength = 0;
		for(int i=0; i<c; i++){
			List<Integer> cp = abc[i];
			double len = cp.size() * 2.0;
			double sum = 0;
			for(int j : cp){
				sum = sum + a[j] + b[j];
			}
			long avg = (long) Math.round(sum/len);
			for(int j : cp){
				totalLength = totalLength + Math.abs(a[j]-avg) + Math.abs(b[j]-avg);
			}
		}
		
		System.out.println(totalLength);

	}
}
