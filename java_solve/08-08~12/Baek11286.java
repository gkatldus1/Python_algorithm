import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Baek11286 {
    static class Value implements Comparable<Value>{
        int val;
        public Value(int val){
            this.val = val;
        }
        @Override
        public int compareTo(Value o) {
            if(Math.abs(this.val) == Math.abs(o.val))   return this.val - o.val;
            return Math.abs(this.val) - Math.abs(o.val);
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Value> minHeap = new PriorityQueue<>();
        int temp = 0;
        for(int i=0; i<N; i++){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(!minHeap.isEmpty()){
                    sb.append(minHeap.poll().val+"\n");       
                    continue;
                }
                sb.append("0\n");
            }
            minHeap.add(new Value(temp));
        }
        bw.write(sb.toString());
        bw.close();
    }
}
