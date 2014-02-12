import java.io.*;
import java.util.*;

public class skidesign{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));
		int N = Integer.parseInt(br.readLine());
		int hills[] = new int[N];
		int cost = 0;
		int initmaxhill = 0;
		for (int i = 0; i<N; i++){
			hills[i] = Integer.parseInt(br.readLine());
			if (hills[i] > initmaxhill){
				initmaxhill = hills[i];
			}
		}
		//Arrays.sort(hills);
		int count = 0;
		int t = 0;
		int maxcount = 0;
		int bestb = 0;
		for (int i = 0; i+17<100; i++){
			t = i + 17;
			if (t > initmaxhill){
				break;
			}
			count = 0;
			for (int j = 0; j<N; j++){
				if (j<i){
					count += (i-j)*(i-j);
				}
				if (j>=i+17){
					count += (j-(i+17))*(j-(i+17));
				}
			}
			
			if(count < maxcount){
				maxcount = count;
				bestb = i;
			}
		
		}
		System.out.println(maxcount);
		System.out.println(bestb);
		for (int i = 0; i<N; i++){
			if (hills[i] < bestb){
				cost += (bestb - hills[i]) * (bestb-hills[i]);
				
			} else if (hills[i] > bestb+17){
				cost += (hills[i] - (bestb+17))*(hills[i] - (bestb+17));

			}
		}
		System.out.println(cost);
		out.println((int) cost);
		out.close();
	}

}
