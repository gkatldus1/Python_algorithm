import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek16926 {
    static int[][] map;
    static int[]dir_x = {1,0,-1,0};
    static int[]dir_y = {0,1,0,-1};
    static int k;
    static int N;
    static int M;
    static int l;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x_start = 0;
        int y_start = 0;
        int x_end = N;
        int y_end = M;


        for(int i=0; i<Math.min(M,N)/2; i++){   //상자의 수만큼 for문을 돌려준다.
            for(int j=0; j<R; j++){
                rotateOuter(i, i, map[i][i], x_start, x_end, y_start, y_end);   //움직임을 시작할 위치와 경계선을 매개값으로 보내준다.
            }
            x_start++;
            y_start++;
            x_end--;
            y_end--;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();

    }
    
    static void rotateOuter(int i, int j, int val, int x_start, int x_end, int y_start, int y_end){     //반시계방향으로 돌게하는 함수
        if(i==x_start&&j==y_start+1){
            map[x_start][y_start] = val;
            return;
        }
        
        int dx = i+dir_x[k];
        int dy = j+dir_y[k];
        if(dx>=x_start && dx<x_end && dy>=y_start && dy<y_end){
            int temp = map[dx][dy];
            map[dx][dy] = val;
            rotateOuter(dx, dy, temp, x_start, x_end, y_start, y_end);
        }else{
            k = (k+1)%4;
            rotateOuter(i, j, val, x_start, x_end, y_start, y_end);
        }
    }
}
