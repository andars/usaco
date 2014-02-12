/*
PROB: milk
USER: afoote91
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class milk{
	static int N = 0;
	static int M = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Farmer sellers[] = new Farmer[M];
		for (int i = 0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			sellers[i] = new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(sellers, new Comparator<Farmer>(){
			public int compare(Farmer a1, Farmer a2){
				if (a1.cost < a2.cost) return -1;
				else if (a1.cost > a2.cost) return 1;
				else return 0;
			}
		});
		int idx = 0;
		int cost = 0;
		int num = N;
		while (num>0){
			if (num >= sellers[idx].amount){
				num -= sellers[idx].amount;
				cost += sellers[idx].amount*sellers[idx].cost;
				idx++;
			}else{
				cost += num*sellers[idx].cost;
				num -= num;
				idx++;
			}
		}
		//System.out.println(cost);
		out.println(cost);
		/*
		for (Farmer i : sellers){
			System.out.println(i.cost);
		}
		*/
		out.flush();
		out.close();
		br.close();

		
	}

	static class Farmer{
		public int cost = 0;
		public int amount = 0;
		Farmer(int a, int b){
			cost = a;
			amount = b;
		}
	}
	
}
