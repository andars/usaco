import java.io.*;
import java.util.*;

public class slowdown{
	static double dist = 0;
	static double time = 0;
	static double currspeed = 1;
	static int currdenom = 1;
	
	static int N = 0;
	static double timeevents[];
	static double distevents[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
		PrintWriter out = new PrintWriter(new FileWriter("slowdown.out"));
		N = Integer.parseInt(br.readLine());
		
		distevents = new double[N];
		timeevents = new double[N];
		String line[];
		int ti = 0; 
		int di = 0;
		for (int i = 0; i<N; i++){
			
			//System.out.println(ti + " " + di);
			
			line = br.readLine().split("\\s");
			//System.out.println(Arrays.toString(line));
			if (line[0].equals( "T")){
			
				timeevents[ti] = (double) Integer.parseInt(line[1]);
				ti++;
			}else{
				distevents[di] = (double) Integer.parseInt(line[1]);
				di++;
			}
			
		}
		
		distevents[di] = 1000;
		timeevents[ti] = 10000000;
		Arrays.sort(timeevents, 0, ti);
		Arrays.sort(distevents, 0, di);
		System.out.println(Arrays.toString(timeevents));
		System.out.println(Arrays.toString(distevents));
		ti = 0;
		di = 0;
		//System.out.println("beginning race");
		while(dist < 1000){
			//System.out.println(ti + " " + di);
			double deltat = timeevents[ti] - time;
			double deltad = distevents[di] - dist;
			if ((double) deltad*currdenom <= (double) deltat){
				//distance event is going to occur next in time
				System.out.println("D" + distevents[di]);
				dist += deltad;
				time += (double) deltad*currdenom;
				currdenom++;
				di++;
			}else{
				System.out.println("T"+timeevents[ti]);
				time += deltat;
				dist += deltat/currdenom;
				currdenom++;
				ti++;
			}

		}
		//System.out.println(Math.round(time));
		out.println(Math.round(time));
		out.flush();
		out.close();

		
	}
}
