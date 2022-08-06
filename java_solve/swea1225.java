import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1225 {
    public static void main(String[] args) throws Exception{
        int tc = 10;
        int[] nums = new int[8];
        int n = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int loop = 1; loop<=tc; loop++){
            Queue<Integer> queue = new LinkedList<>();
            int t = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<8; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            int k = 1;
            while(true){
                n = queue.poll();
                n -= (k);
                if(n <= 0){
                    n = 0;
                    queue.add(n);
                    break;
                }
                queue.add(n);
                k++;
                if(k>5) k = 1;
            }

            System.out.print("#"+t+" ");
            for(int i: queue){
                System.out.print(i+" ");
            }
            System.out.println();

        }
    }
}
