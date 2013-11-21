import java.io.*;
import java.util.*;

public class combo {
	static int n;
	static int john[];
	static int master[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new FileWriter("combo.out"));
		
		n = Integer.parseInt(br.readLine());
		boolean check[][][] = new boolean[n+1][n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		john = new int[3];
		for (int i = 0; i<3; i++){
			john[i] = Integer.parseInt(st.nextToken());
			
		}
		master = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<3; i++){
			master[i] = Integer.parseInt(st.nextToken());
			
		}
		//System.out.println(n);
		//System.out.println("master: "+Arrays.toString(master));
		int count = 0;
		//System.out.println(check.length);
		int a, b, c;
		for (int i = 0; i<5; i++){
			for (int j = 0; j<5; j++){
				for (int k = 0; k<5; k++){
					a = wrap(john[0]-2+i);
					b = wrap(john[1]-2+j);
					c = wrap(john[2]-2+k);
					//System.out.println(a+" "+b+" "+c);
					if (!check[a][b][c]){
						check[a][b][c] = true;
						count++;
					}
				}
			}
		}
		for (int i = 0; i<5; i++){
			for (int j = 0; j<5; j++){
				for (int k = 0; k<5; k++){
					a = wrap(master[0]-2+i);
					b = wrap(master[1]-2+j);
					c = wrap(master[2]-2+k);
					if (!check[a][b][c]){
						check[a][b][c] = true;
						count++;
					}
				}
			}
		}
		
		//System.out.println(count);
		out.println(count);
		out.flush();
		out.close();
		
	}
	public static int wrap(int a){
		return (a % n + n) % n;
	
	}

}
