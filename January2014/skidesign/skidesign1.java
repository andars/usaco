import java.io.*;
import java.util.*;

public class skidesign{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));
		int N = Integer.parseInt(br.readLine());
		int hills[] = new int[N];
		int cost = 0;
		for (int i = 0; i<N; i++){
			hills[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(hills);
		
		//System.out.println(Arrays.toString(hills));
		int diff=0;
		while((diff = hills[N-1] - hills[0]) > 17){
			diff = diff-17;
			hills[0] = hills[0] + diff/2;
			cost+=(diff/2)*(diff/2);
			hills[N-1] = hills[N-1] - diff/2;
			cost+=(diff/2)*(diff/2);
			Arrays.sort(hills);
			
			//System.out.println(Arrays.toString(hills));
		}

		out.println((int) cost);
		out.close();
	}

}
