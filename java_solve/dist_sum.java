import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dist_sum {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        for(int i=1; i <=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] sum = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sum[i][j] = sum[i][j-1] + map[i][j];
            }
        }

        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=M; i++){
            int result = 0;
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());
            for(int j=x1; j<=x2; j++){
                result += (sum[j][y2] - sum[j][y1-1]);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
