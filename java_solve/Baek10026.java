import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek10026 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i]=br.readLine().toCharArray(); 
        }
        // for(char[] arr: map){
        //     System.out.println(Arrays.toString(arr));
        // }
        int cnt1=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i, j, map[i][j]);
                    cnt1++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'G')    map[i][j] = 'R';
            }
        }
        visited = new boolean[N][N];
        int cnt2=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i, j, map[i][j]);
                    cnt2++;
                }
            }
        }
        
        System.out.println(cnt1+" "+cnt2);


    }
    static void dfs(int x, int y, char val){
        if(map[x][y]!= val){
            return;
        }
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int dir_x = x+ dx[i];
            int dir_y = y + dy[i];
            if(dir_x<0 || dir_x >=N || dir_y <0 || dir_y >= N || visited[dir_x][dir_y]) continue;
            dfs(dir_x, dir_y, val);

        }
    }

}
