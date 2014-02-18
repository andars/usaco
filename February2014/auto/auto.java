import java.io.*;
import java.util.*;

public class auto {
    static int N;
    static int W;
    static String dict[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new FileReader("auto.in"));
        PrintWriter out = new PrintWriter( new FileWriter("auto.out"));
        String words[] = br.readLine().split(" ");
        W = Integer.parseInt(words[0]);
        N = Integer.parseInt(words[1]);
        dict = new String[W];
        Trie dict = new Trie();
        List<String> results = new ArrayList<String>();
        List<String> indices = new ArrayList<String>();
        for (int i = 0; i<W; i++){
            dict.addWord(br.readLine(), i+1);    
        }
        for (int i = 0; i<N; i++){
            words = br.readLine().split(" ");
            dict.traverse(words[1], results);
            Collections.sort(results);
            //System.out.println(results);
            
            if (results.size() > Integer.parseInt(words[0])) {
                String str = results.get(Integer.parseInt(words[0])-1);
                out.println(str.charAt(str.length()-1));
            } else {
                out.println("-1");
            }
            results.clear();
            
        }
        out.flush();
        out.close();
        
    }
}

class Trie {
    public Node root = new Node(' ');
    
    public Trie() {
           
    }
    public void addWord(String str, int i){
        root.addWord(str, i);
    }
    public void countWords(String str){
        char c = str.charAt(0);
        
    }
    private Node getNodeForPrefix(Node node, String prefix) {
        if (prefix.length() == 0) {
            return node;
        }
        Node next = node.children[prefix.charAt(0)-'a'];
        if (next == null) {
            return null;
        }
        return getNodeForPrefix(next, prefix.substring(1, prefix.length()));
    }
    public void traverse(String prefix, List<String> list) {
        traverse(prefix, getNodeForPrefix(root, prefix), list);   
    }
    
    public void traverse(String prefix, Node node, List<String> list) {
        //node.printChildren();

        if (node.end){
            list.add( prefix + node.index);
        }
        for (char index = 0; index < 26; ++index) {
            char next = (char)( 'a'+ (char) index);
            Node pChild = node.children[index];
            
            if (pChild != null) {
               
                prefix += next;
                traverse(prefix, pChild, list);
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        
    }
    class Node {
        private char data = ' ';
        public boolean end = false;
        public int childcount = 0;
        public int index = -1;
        public Node[] children = new Node[26];
        public Node(char c){
            data = c;
            end = false;
            
            
        }
       
        public Node(char c, int i){
            data = c;
            end = false;
            index = i;
            
        }
        public void addWord(String str, int i){
            
            
            if (str.length() == 0){
                end = true; 
                index = i;
                return;
            }
            childcount++;
            //System.out.println("adding " + str + " to " + data);
            char c = str.charAt(0);
            
            if (children[c-'a'] == null) {
                children[c-'a'] = new Node(c);
                
            }
            children[c-'a'].addWord(str.substring(1), i);
        }
        
        
        
    }
}
