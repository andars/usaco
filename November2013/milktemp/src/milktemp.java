import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class milktemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("milktemp.in"));
		PrintWriter out = new PrintWriter(new FileWriter("milktemp.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		int cows[][] = new int[n][2];
		for (int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int temp = 0;
		
		for (int i = 0; i< 100000; i++){
			
			int sum = 0;
			for (int j = 0 ;j < n; j++){
				if (i < cows[j][0]){
					sum += x;
				}
				else if (i > cows[j][1]){
					sum += z;
				}
				else {
					sum += y;
				}
			}
			if (sum > max){
				temp = i;
			}
			max = Math.max(max, sum);
		}
		System.out.println(temp);
		System.out.println(max);
		out.println(max);
		out.flush();
		out.close();
	}

}

class Cow{
	int low, high;
	Cow(){
		
	}
	void setHigh(int a){
		high = a;
		
	}
	void setLow(int a){
		low = a;
	}
}