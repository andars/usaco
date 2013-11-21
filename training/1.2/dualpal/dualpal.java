/*
PROB: dualpal
USER: afoote91
LANG: JAVAA

*/
import java.io.*;
import java.util.*;

public class dualpal{

	static int N = 0;
	static int S = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		br.close();
		PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
		int t = S+1;
		int num = 0;
		while (num < N){
			if (isDualPalindrome(t)){
				out.println(t);
				num++;
			}
			t++;
		}
		out.flush();
		out.close();
	}
	public static boolean isDualPalindrome(int a){
		int count = 0;
		for (int i = 2; i<=10; i++){
			if (isPalindrome(a,i)){
				count++;
			}

			//System.out.println(i+" "+a+" "+isPalindrome(a,i)+" "+Integer.toString(a,i));
			if (count >= 2) return true;
		}
		return false;
	}
	public static boolean isPalindrome(int a, int b){
		String num = Integer.toString(a,b);
		//only need to check half length - past that is repetitive
		for (int i = 0; i<(num.length()/2); i++){
			if(num.charAt(i) != num.charAt(num.length()-1-i)) return false;
		}
		return true;
	}
}
