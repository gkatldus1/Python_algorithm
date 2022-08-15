import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1931 {
    static class meeting implements Comparable<meeting>{
        int start;
        int end;
        public meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(meeting o) {
            if(this.start==o.start) return this.end-o.end;
            return this.start - o.start;
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
        int max=Integer.MIN_VALUE, temp=0;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                temp = 1;
                int k=j+1;
                int temp_j=j;
                while(k<arr.length){
                    if(arr[temp_j].start==arr[k].start){
                        k++;
                        continue;
                    }
                    if(arr[temp_j].end<=arr[k].start){
                        temp+=1;
                        temp_j = k;
                        k++;
                        continue;
                    }
                    k++;
                }
                max = Math.max(max, temp);
            }
        }
        System.out.println(max);
    }
}
