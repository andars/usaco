import java.io.*;
import java.util.*;
//brute force! w00t
public class mirror {
    static int width;
    static int height;
    static char mirrors[][];
    
    public static void main(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("mirror.in"));
        PrintWriter out = new PrintWriter(new FileWriter("mirror.out"));
        String words[] = br.readLine().split(" ");
        height = Integer.parseInt(words[0]);
        width = Integer.parseInt(words[1]);
        
        mirrors = new char[height][width];
        
        for (int i = 0; i<height; i++){
            br.read(mirrors[i],0,width);
            br.read();
        }
        for (int i = 0; i<height; i++){
            for (int j = 0; j<width; j++){
                //System.out.print(mirrors[i][j]);
            }
            //System.out.println();
        }
        System.out.println(simulate());
        out.println(simulate());
        out.flush();
        out.close();
    }
    
    public static int simulate(){
        //try shooting vertically
        int max = 0;
        int count = 0;
        int tmp[] = new int[2];
        int last[] = new int[2];
        for (int i = 0; i<width; i++){
            count = 1;
            last[0] = i; last[1] = -1;
            int next[] = nextSpot(i, 0, last[0], last[1]);
            last[0] = i; last[1] = 0;
            //System.out.println(next[0] + "," + next[1]);
            while (0 <= next[0] && next[0] < width && 0 <= next[1] && next[1] < height){
                //System.out.println("going to " +next[0] + "," + next[1] + "from " + last[0] + "," + last[1]);
                tmp[0] = next[0]; tmp[1] = next[1];
                next = nextSpot(next[0], next[1], last[0], last[1]);
                last[0] = tmp[0]; last[1] = tmp[1];
                
                count++;
                
            }
            if (count > max)
                max = count;
            
        }
        //System.out.println("BOTTOM UP");
        for (int i = 0; i<width; i++){
            count = 1;
            last[0] = i; last[1] = height;
            int next[] = nextSpot(i, height-1, last[0], last[1]);
            last[0] = i; last[1] = height-1;
            //System.out.println(next[0] + "," + next[1]);
            while (0 <= next[0] && next[0] < width && 0 <= next[1] && next[1] < height){
                //System.out.println("going to " +next[0] + "," + next[1] + "from " + last[0] + "," + last[1]);
                tmp[0] = next[0]; tmp[1] = next[1];
                next = nextSpot(next[0], next[1], last[0], last[1]);
                last[0] = tmp[0]; last[1] = tmp[1];
                
                count++;
                
            }
            if (count > max)
                max = count;
            
            
        }
        //System.out.println("LEFT IN");
        for (int i = 0; i<height; i++){
            count = 1;
            last[0] = -1; last[1] = i;
            int next[] = nextSpot(0, i, last[0], last[1]);
            last[0] = 0; last[1] = i;
            //System.out.println(next[0] + "," + next[1]);
            while (0 <= next[0] && next[0] < width && 0 <= next[1] && next[1] < height){
                //System.out.println("going to " +next[0] + "," + next[1] + "from " + last[0] + "," + last[1]);
                tmp[0] = next[0]; tmp[1] = next[1];
                next = nextSpot(next[0], next[1], last[0], last[1]);
                last[0] = tmp[0]; last[1] = tmp[1];
                
                count++;
               
            }
            if (count > max)
                max = count;
            
            
        }
        //System.out.println("RIGHT IN");
        for (int i = 0; i<height; i++){
            count = 1;
            last[0] = width; last[1] = i;
            int next[] = nextSpot(width-1, i, last[0], last[1]);
            last[0] = width-1; last[1] = i;
            //System.out.println(next[0] + "," + next[1]);
            while (0 <= next[0] && next[0] < width && 0 <= next[1] && next[1] < height){
                //System.out.println("going to " +next[0] + "," + next[1] + "from " + last[0] + "," + last[1]);
                tmp[0] = next[0]; tmp[1] = next[1];
                next = nextSpot(next[0], next[1], last[0], last[1]);
                last[0] = tmp[0]; last[1] = tmp[1];
                
                count++;
               
            }
            if (count > max)
                max = count;
            
            
        }
        return max;
    }
    public static int[] nextSpot(int x, int y, int lx, int ly){
        //can't go diagonally
        int dx = x-lx;
        int dy = y-ly;
        //System.out.println(dx + " "+ dy);
        if (dx == 0 && dy == 1){
            if (mirrors[y][x] == '/') {
                return new int[]{x-1, y};
            } else {
                return new int[]{x+1, y};
            }
        } else if (dx == 0 && dy == -1) {
            if (mirrors[y][x] == '/') {
                return new int[]{x+1, y};
            } else {
                return new int[]{x-1, y};
            }
        } else if (dx == -1 && dy == 0) {
            if (mirrors[y][x] == '/') {
                return new int[]{x, y+1};
            } else {
                return new int[]{x, y-1};
            }
        } else if (dx == 1 && dy == 0) {
            if (mirrors[y][x] == '/') {
                return new int[]{x, y-1};
            } else {
                return new int[]{x, y+1};
            }
        }
        System.out.println("fail");
        return new int[2];
    }
}
        