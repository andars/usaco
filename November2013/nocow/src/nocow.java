import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;


public class nocow {

	/**
	 * @param args
	 */
	static HashMap<String, Boolean> notcows;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("nocow.in"));
		PrintWriter out = new PrintWriter(new FileWriter("nocow.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		System.out.println(n);
		int k = Integer.parseInt(st.nextToken());
		Cow cows2[] = new Cow[n];
		for(int j = 0; j<n; j++){
			cows2[j] = new Cow();
		}
		int settings[] = new int[30];
		List<List<String>> options = new ArrayList<List<String>>();
		List<String> none = new ArrayList<String>();
		
		System.out.println(options);
		HashMap<String, Boolean> check = new HashMap<String, Boolean>();
		notcows = new HashMap<String, Boolean>();
		for (int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j<4; j++){
				st.nextToken();
			}
			String next = st.nextToken();
			int a = 0;
			
			
			while(!next.equals("cow.")){
				cows2[i].addAdjective(next);
				if(!check.containsKey(next)|| !check.get(next)){
					settings[a]++;
					check.put(next, true);
					if (a>=options.size()){
						options.add(a, new ArrayList<String>());
						
					}
					
					options.get(a).add(next);
					
				}
				next = st.nextToken();
				a++;
			}
			notcows.put(cows2[i].finish(), true);
		}
		System.out.println(options);
		
		int product = 1;
		for (int i = 0; settings[i]!=0; i++){
			product *= settings[i];
			System.out.println(product);
		}
		System.out.println("p"+product);
		String[] cowlist = genCowList(settings,options, cows2[0].length, product);
		Arrays.sort(cowlist);
		System.out.println(Arrays.toString(cowlist));
		System.out.println(cowlist[7]);
		
	}
	public static void addAdjToCows(List<String> cows,int adj,int[] settings, List<List<String>> options, boolean flag){
		int start = 0;
		System.out.println(options.get(adj).size());
		int dist = cows.length/options.get(adj).size();
		System.out.println("l"+cows.length);
		System.out.println("d"+dist);
		String temp = "";
		for (int i = 0; i<settings[adj]; i++){
			//looping through all possibilities for this adjective
			for (int j = 0; j<cows.size(); j++){
				//looping through
				temp = (cows[j*dist]==null?"":cows[j])+" "+options.get(adj).get(i);
				System.out.println("adding "+ options.get(adj).get(i) + " to "+cows[j]);
				if (flag){
					if (notcows.containsValue(temp)) break;
				}
				cows[j] = temp;
			}
			start+= dist;
		}
	}
	public static String[] genCowList(List<String> cowlist,int[] settings,int adj, List<List<String>> options, int numadjs, int numcows ){
		System.out.println(numcows);
		//String cows[] = new String[numcows];
		/*for (int i = 0; i < options.size(); i++){
			System.out.println("s "+settings[i]);
			addAdjToCows(cows,i, settings, options, i-1 == options.size()?true:false);
		}*/
		
		addAdjToCows(cowlist,adj, settings, options, numadjs==1?true:false );
		List<>
		for (int i = 0; i<options.get(adj).size(); i++){
			
		}
		List<String> myList = new ArrayList<String>(Arrays.asList(first));
		myList.addAll(new ArrayList<String>(Arrays.asList(second)));
		String[] both = myList.toArray(new String[myList.size()]);
	
		return cows;
	}

}

class Cow{
	String adjectives[] = new String[30];
	int i = 0;
	int length;
	Cow(){
		
	}
	public void addAdjective(String a){
		adjectives[i] = a;
		i++;
	}
	public String finish(){
		length = i;
		String ret = "";
		for(int j = 0; j<length; j++){
			String t = ret +" "+ adjectives[j];
			ret = t;
		}
		return ret;
	}
	public String[] getAdjectives(){
		String ret[] = new String[length];
		for(int j = 0; j<length; j++){
			ret[j] = adjectives[j];
		}
		System.out.println(length);
		return ret;
	}
}
