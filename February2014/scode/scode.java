import java.io.*;
import java.util.*;

public class scode {
    static String begin;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("scode.in"));
        PrintWriter out = new PrintWriter(new FileWriter("scode.out"));
        
        begin = br.readLine();
        
        out.println(backward(begin, 0));
        out.flush();
        out.close();
    }
    public static int backward(String start, int count) {
        //no idea if any of this works or even what it says
        if (start.length() <= 2) {
            return 0;   
        }
        int len = (start.length()+1)/2;
        List<String> ret = new ArrayList<String>(2);
        
        String a1 = start.substring(0, len);   
        
        if (a1.substring(0,a1.length()-1).equals(start.substring(len,start.length()))){ 
            count++;
            count+=backward(a1, 0);
            //System.out.println(a1 + " " + start.substring(len,start.length()) + " where excluding last letter");
        }
        if (a1.substring(1,a1.length()).equals(start.substring(len,start.length()))) {
            count++;
            count+=backward(a1, 0);
            //System.out.println(a1 + " " + start.substring(len,start.length()) + " where excluding first letter");
        }      
            
        String a2 = start.substring(len-1, start.length());
        if (a2.substring(0,a2.length()-1).equals(start.substring(0,len-1))) {
         
            
            count++;
            count+=backward(a2, 0);
            //System.out.println(start.substring(0,len-1) + " " + a2 + " where excluding last letter");
        }
        if (a2.substring(1,a2.length()).equals(start.substring(0,len-1))) {
            count++;
            count+=backward(a2, 0);
            //System.out.println(start.substring(0,len-1) + " " + a2 + " where excluding first letter"); 
        }
        
        return count;
    }
}