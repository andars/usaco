import java.io.*;
import java.util.*;

class records{
	int primes[] = {2,3,5,7,11,13,17,19,23,29};
	static Map<String, Integer> groups = new HashMap<String,Integer>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("records.in"));
		PrintWriter out = new PrintWriter(new FileWriter("records.out"));
		int hours = Integer.parseInt(br.readLine());
		String cows[] = new String[3];
		StringTokenizer st;
		StringBuilder sb; 
		String name;
		int max = 0;
		for (int i = 0; i<hours; i++){
			st = new StringTokenizer(br.readLine());
			cows[0] = st.nextToken();
			cows[1] = st.nextToken();
			cows[2] = st.nextToken();
			Arrays.sort(cows);
			sb = new StringBuilder();
			sb.append(cows[0]);
			sb.append(cows[1]);
			sb.append(cows[2]);
			name = sb.toString();
			if (!groups.containsKey(name)){
				groups.put(name, 1);
			}else{
				Integer t = groups.get(name);
				t++;
				groups.put(name, t);
				if (t>max){
					max = t;
				}
			}
			//System.out.println(sb.toString());

		}
		System.out.println(max);
		out.println(max);
		out.flush();
		out.close();
	}
}
