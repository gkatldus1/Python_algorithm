import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baek10971
 */
public class Baek10971 {
    static int[][] map;
    static int N;
    static boolean[] visited;
    static int[] orders;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        orders = new int[N];
        map = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<N; i++){
            orders[0] = i;
            visited[i] = true;
            permutation(1);
            visited[i] = false;
        }
        System.out.println(min);


    }
    static void permutation(int cnt){
        if(cnt==N){
            if(map[orders[N-1]][0]==0) return;
            // for(int i=0; i<N; i++){
            //     System.out.print(orders[i]+" ");
            // }
            // System.out.println();
            calc();

            return;
        }
        
        for(int i=1; i<N; i++){
            if(map[orders[cnt-1]][i]==0) continue;//이번 차례에 고르려고 하는 장소로 가는 길이 없다면 continue
            if(visited[i])  continue;//이미 방문한 장소라면 continue
            visited[i] = true;
            orders[cnt] = i;
            permutation(cnt+1);
            visited[i] = false;
        }
    }

    static void calc(){
        int result = 0;
        int from = -1;
        int to = -1;
        for(int i=0; i<N-1; i++){
            from = orders[i];
            to = orders[i+1];
            result += map[from][to];
            // System.out.print( map[from][to]+" ");
        }
        // System.out.println();
        result += map[orders[N-1]][orders[0]];
        // if(min<result){
        //     for(int i=0; i<N; i++){
        //         System.out.print(orders[i]+" ");
        //     }
        //     System.out.println();
        // }
        min = Math.min(min, result);
    }
    
}