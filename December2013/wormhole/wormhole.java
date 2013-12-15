import java.io.*;
import java.util.*;

class wormhole{
	static int[] links;
	static int N = 0;
	static List<List<List<Integer>>> possibles;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		Integer wormholes[][] = new Integer[N][2];
		links = new int[N/2];
		for (int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			wormholes[i][0] = Integer.parseInt(st.nextToken());
			wormholes[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(wormholes, new Comparator<Integer[]>(){
			public int compare(Integer[] e1, Integer[] e2){
				Integer n1 = e1[0];
				Integer n2 = e2[0];
				return n1.compareTo(n2);
			}
		});
		int a[] = new int[N];
		for (int i = 0; i<N; i++){
			a[i] = i;
		}
		List<List<Integer>> subsets = new ArrayList<List<Integer>>(N/2);
		possibles = new ArrayList<List<List<Integer>>>();
		for (int i = 0; i < N/2; i++){
		    subsets.add(new ArrayList<Integer>(2));
		}
		possibleLinks(a, 0, subsets, possibles);
		for (List<List<Integer>> aa: possibles){
			for (List<Integer> bb : aa){
				System.out.print(bb);
			}
			System.out.println();
		}
		System.out.println(possibles);

		System.out.println(Arrays.deepToString(wormholes));
	}
	public static void possibleLinks(int[] a, int i, List<List<Integer>> pairs, List<List<List<Integer>>> results){
		if (results.size() == factorial(N)/(factorial(N/2)*Math.pow(2, N/2))){
			return;
		}
		if (i == N){
			for (List<Integer> z : pairs)
				System.out.print(z);
			System.out.println();
			results.add(pairs);
			System.out.println(results);
			
		}
		else {
        // loop over all subsets and try to put a[i] in
        for (int j = 0; j < N/2; j++) {                 
            if (pairs.get(j).size() < 2) {
                // subset j not full
                pairs.get(j).add(a[i]);
                possibleLinks(a, i+1, pairs, results); // do recursion
                pairs.get(j).remove((Integer)a[i]);

                if (pairs.get(j).size() == 0) {
                     // don't skip empty subsets, so you won't get duplicates
                     break;
                }                    
            }
        }
    }
    System.out.println(results);
	}
	public static int factorial(int number) {
	    int factorial = 1;
	    for (int i = 1; i <= number; ++i) {
	        factorial *= i;
	    }
	    return factorial;
    }
}
