import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1931 {
    static class meeting implements Comparable<meeting>{
        int start;
        int end;
        public meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(meeting o) {
            if(this.end==o.end) return this.start-o.start;
            return this.end-o.end;
            
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        meeting[] arr = new meeting[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int count=1;
        meeting now = arr[0];
        for(int i=1; i<arr.length; i++){
            if(now.end<=arr[i].start){
                count++;
                now = arr[i];
                continue;
            }
        }
        
        System.out.println(count);

    }
}
