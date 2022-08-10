import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek1010 {
    
    static int count;
    static int west;
    static int east;
    static int check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int loop=1; loop<=tc; loop++){
            st= new StringTokenizer(br.readLine());
            west = Integer.parseInt(st.nextToken());
            east = Integer.parseInt(st.nextToken());
            
            
            bridge(0, 0);
            sb.append(count).append("\n");
            count = 0;
        }
        bw.write(sb.toString());
        bw.close();
    }
    static void bridge(int start, int length){
        if(check == west){
            count++;
            return;
        }
        for(int i=start; i<east; i++){
            check++;
            bridge(i+1, length+1);
            check--;
        }
    }
}
