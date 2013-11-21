/*
PROB: namenum
USER: afoote91
LANG: JAVA
*/

import java.io.*;
import java.util.*;

public class namenum{
	
	public static void main(String[] args) throws Exception{
		String num = "";
		BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
		num = br.readLine();
		br.close();
		String curr = "";

		boolean found = false;
		while (( curr = dict.readLine()) != null){
			if (nameToNumber(curr).equals(num)){
				out.println(curr);
				found = true;
			}
		}
		dict.close();
		if (!found) out.println("NONE");
		out.flush();
		out.close();
		System.out.println(num);
		System.out.println(nameToNumber("KRISTOPHER"));
	}
	public static String nameToNumber(String name){
		String number = "";
		char here;
		for (int i = 0; i<name.length(); i++){
			here = name.charAt(i);
			if (here<'Q'){
				number += 2+(here-'A')/3;
			}
			else{
				number += 7 + (here-'P'-1)/3;
			}
		}
		return number;
	}

}
