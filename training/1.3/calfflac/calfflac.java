/*
USER: afoote91
PROB: calfflac
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class calfflac{
	static String input = "";
	public static void main(String... args) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader("calfflac.in"));
		StringBuilder sb = new StringBuilder();
		String t = "";
		while ((t=br.readLine()) != null){
			sb.append(t);
			sb.append("\n");
		}
		input = sb.toString();
		findPalindrome();
		input = input.replaceAll("[^A-Za-z]", "");
		input = input.toLowerCase();
		System.out.println(input);
	}

	public static int findPalindrome(int left, int right){
		int count = 0;
		int idx1 = left, idx2 = right;
		while(idx1 > 0 && idx2 < input.length){
			if (false){}
		};
		return count;
	}
}	
