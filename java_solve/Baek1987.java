import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1987 {
    static int R, C;
    static char[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max = Integer.MIN_VALUE;
    static boolean[] selected = new boolean[26];    //알파벳을 선택했는지 확인하는 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        String str = "";
        move(0,0, str, 0);
        System.out.println(max);
    }   
    static void move(int r, int c, String str, int count){
        int idx = board[r][c] - 'A';
        selected[idx] = true;
        max = Math.max(count+1, max);
        for(int i=0; i<4; i++){     //4방향을 조건에 맞는지 재귀를 돌며 탐색
            int dir_x = r+dx[i];
            int dir_y = c+dy[i];
            if(dir_x>=0&&dir_x<R&&dir_y>=0&&dir_y<C){
                idx = board[dir_x][dir_y]-'A';
                if(!selected[idx]){
                    move(dir_x, dir_y, str, count+1);
                    selected[idx] = false;
                }
                
            }
        }
    }
}
