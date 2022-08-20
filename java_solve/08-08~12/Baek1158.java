import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb= new StringBuilder();
        //N만큼 숫자 받아오기
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        sb.append("<");
        while(!queue.isEmpty()){
            if(queue.size()== 1){
                sb.append(queue.poll()).append(">");
                break;
            }
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(",").append(" ");
        }
        System.out.println(sb.toString());
        
    }
}
