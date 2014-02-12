/*
PROB: barn1
USER: afoote91
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class barn1 {
	static int M = 0;
	static int S = 0;
	static int C = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		boolean stalls[] = new boolean[S+1];
		boolean planks[] = new boolean[S+1];
		int idx = 0;
		int min = S+1, max  = 0;
		//get all cows and find first and last 
		for (int i = 0; i<C; i++){
			idx = Integer.parseInt(br.readLine());
			stalls[idx-1] = true;
			min = Math.min(min, idx-1);
			max = Math.max(max, idx-1);
		}
		br.close();
		System.out.println(max+" "+min);
		int coveredcount = 0;
		for (int i = min; i<= max && i<S; i++){
			planks[i] = true;
			coveredcount++;
			System.out.println("adding inital plank at "+i);
		}
		System.out.println(coveredcount);
		for (int i = 1; i<M; i++){
			System.out.println("adding board: "+(i+1));
			int count = 0;
			int maxcount = 0;
			int maxidx = 0;
			//loop to find maximum unnecessary covering
			for (int j = min; j<=max && i<S; j++){

				if (planks[j] && !stalls[j]){
					count++;
				}
				if (count > maxcount){
					maxcount = count;
					maxidx = j;
				}
				if (stalls[j]){
					count = 0;
				}

			}
			System.out.println("Removing at: "+maxidx);
			while(!stalls[maxidx] && maxidx > 0){
				planks[maxidx] = false;
				maxidx--;
			}
		}
		for (int i = 0; i<S+1; i++){
			System.out.println("Position "+i+": "+ planks[i] +" ; "+stalls[i]);
		}
		int answer = 0;
		for (boolean t : planks){
			if (t) answer++;
		}
		PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));
		out.println(answer);
		out.flush();
		out.close();
		int numcows = 0;
		for (boolean t: stalls){
			if (t) numcows++;
		}
		System.out.println(numcows);
	}	
}
