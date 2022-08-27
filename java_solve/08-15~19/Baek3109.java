

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3109 {
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int ans;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){ //입력을 받아줌
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<R; i++){//처음행부터 마지막행까지 가스를 연결시킬 수 있는지 탐색
            gasRobber(i,0);
            flag = false;
        }
        System.out.println(ans);
    }
    public static void gasRobber(int r, int c){
        visited[r][c] = true;
        if(c==C-1){ //끝에 도달했다면 카운트를 증가시키고 이후에 다른 방향 탐색을 안하도록 플래그에 true입력
            ans++;
            flag = true;
            return;
        }
        for(int i=0; i<3; i++){//오른쪽 위, 오른쪽, 오른쪽 아래 순서로 탐색
            int dir_x = r+dx[i];
            int dir_y = c+dy[i];
            if(dir_x>=0&&dir_x<R&&dir_y>=0&&dir_y<C&&map[dir_x][dir_y]!='x'&&!visited[dir_x][dir_y]){
                gasRobber(dir_x, dir_y);
                
                if(flag)    return; //빵집에 연결되었을 시에 다른 방향들 탐색 종료
            }

        }
    }

}
