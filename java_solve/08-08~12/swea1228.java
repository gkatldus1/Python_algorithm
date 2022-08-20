import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1228 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int tc=1; tc<=10; tc++){
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            //N개의 암호문 숫자 받기
            for(int i=0; i<N; i++){
                list.add(Integer.valueOf(st.nextToken()));
            }
            //명령어의 숫자 받기
            int M = Integer.parseInt(br.readLine());
            //명령어 받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                String str = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Queue<Integer> queue = new LinkedList<>();
                //명령어에 들어있는 숫자 받기
                for(int j=0; j<y; j++){
                    int s = Integer.parseInt(st.nextToken());
                    queue.add(s);    
                }
                //받은 숫자를 암호문에 넣어주기
                for(int j=0; j<y; j++){
                    list.add(x, queue.poll());
                    x++;
                }
            
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            System.out.print("#"+tc+" "+sb.toString());
            System.out.println();
        }


    }
}
