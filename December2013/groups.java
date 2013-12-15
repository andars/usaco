import java.io.*;
import java.util.*;

class groups{
	static int num = 0;
	public static void main(String[] args) {
    	int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    	int k = 2;

    	List<List<Integer>> subsets = new ArrayList<List<Integer>>(a.length / k);
    	for (int i = 0; i < a.length / k; i++)
        	subsets.add(new ArrayList<Integer>(k));
  		solve(a, k, 0, subsets);

	}
	public static void solve(int[] a, int k, int i, List<List<Integer>> subsets) {
    if (i == a.length) {
        for (List<Integer> subset : subsets) {
            System.out.print(subset); 
            
        }
        num++;
        System.out.println(num);
    } else {
        // loop over all subsets and try to put a[i] in
        for (int j = 0; j < subsets.size(); j++) {                 
            if (subsets.get(j).size() < k) {
                // subset j not full
                subsets.get(j).add(a[i]);
                solve(a, k, i+1, subsets); // do recursion
                subsets.get(j).remove((Integer)a[i]);

                if (subsets.get(j).size() == 0) {
                     // don't skip empty subsets, so you won't get duplicates
                     break;
                }                    
            }
        }
    }
}
}
