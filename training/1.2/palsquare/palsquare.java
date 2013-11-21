/*
USER: afoote91
PROB: palsquare
LANG: JAVA
*/
import java.util.*;
import java.io.*;
class palsquare {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		int b = Integer.parseInt(br.readLine());
		//list of all integers less than 300 that are palindromes in base b
		List<Integer> pal = new ArrayList<Integer>();
		for (int i = 1; i<301; i++){ //loop through all n : {1..300}
			System.out.println(i);
			if (isPalindrome(i, b)){
				pal.add(i);
			}
		}
		//System.out.println(pal);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		//print all palindromes in uppercase base b
		for (int i = 0; i<pal.size(); i++){
			out.println(Integer.toString(pal.get(i),b).toUpperCase() +" " + Integer.toString((int) Math.pow(pal.get(i),2),b).toUpperCase());
		}
		out.close();
	}
	public static boolean isPalindrome(int a, int b){
		String num = Integer.toString(a*a,b);
		//only need to check half length - past that is repetitive
		for (int i = 0; i<(num.length())/2; i++){
			if(num.charAt(i) != num.charAt(num.length()-1-i)) return false;
		}
		return true;
	}
}

