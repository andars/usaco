/*possible ways to groups m*n items into m groups of n:
	(mn)!/((n!)^m * m!)
	12!/(3!^4 * 4!)
	15400 possible groupings

	brute force?
*/
import java.io.*;
import java.util.*;

public class bteams{
	static List<List<Integer>> groups = new ArrayList<List<Integer>>();
	///cows[i][0] is value, cows[i][1] is flag for grouped
	static int cows[][] = new int[12][2];
	static int mindiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("bteams.in"));
		PrintWriter out = new PrintWriter(new FileWriter("bteams.out"));
		for (int i = 0; i<4; i++){
			groups.add(new ArrayList<Integer>());
		}
		for (int i = 0; i<12; i++){
			cows[i][0] = Integer.parseInt(br.readLine());
		}
		generateGroupings();
		out.println(mindiff);
		out.flush();
		out.close();
	}
	public static void generateGroupings(){
		int i;
		for ( i = 0; i<12; i++){
			if (cows[i][1] == 0) break;
		}
		if (i>=12) {
			int diff = findSkillDiff();
			if (diff < mindiff){
				mindiff = diff;
			}
		}
		for (int j = 0; j<4; j++){
			// check group unfinished
			if(groups.get(j).size() < 3){
				groups.get(j).add(cows[i][0]);
				cows[i][1] = 1;
				generateGroupings();
				cows[i][1] = 0;
				groups.get(j).remove(Integer.valueOf(cows[i][0]));
			}
		}
	}
	public static int findSkillDiff(){
		
		int maxskill = 0;
		for (int i = 0; i<4; i++){
			maxskill = Math.max(maxskill, sum(i));
		}
		int minskill = Integer.MAX_VALUE;
		for(int i =0; i<4; i++){
			minskill = Math.min(minskill, sum(i));
		}
		return maxskill - minskill;
		
	}
	public static int sum(int index){
		return groups.get(index).get(0) + groups.get(index).get(1) + groups.get(index).get(2);
	}

}
