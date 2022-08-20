import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2961 {
    static int[][]dp;
    static int[][] taste;
    static int min = Integer.MAX_VALUE;
    static int N;
    static Stack<Integer> selected = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=N; i++){
            selected.clear();
            find_min(0,i);
        }
        System.out.println(min);


    }
    static void find_min(int start, int end){
        if(selected.size() == end){
            int diff;
            int index;
            int sour = 1;
            int bitter = 0;
            for(int i=0; i<selected.size(); i++){
                index = selected.get(i);
                sour *= taste[index][0];
                bitter += taste[index][1];
            }
            diff = Math.abs(sour-bitter);
            min = (min<diff) ? min: diff;
            return;
        }
        for(int i=start; i<N; i++){
            selected.add(i);
            find_min(i+1, end);
            selected.pop();
        }
    }

    
}
