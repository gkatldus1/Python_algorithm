import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1210 {
    static int[][] ladder = new int[100][100];
    
    static int [] dx = {0,0,-1};
    static int [] dy = {-1,1,0};
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int loop=1; loop<=10; loop++){
            int tc = Integer.parseInt(bf.readLine());
            StringTokenizer st = null;
            for(int i=0; i<100; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<100; j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<100; i++){
                if(ladder[99][i] == 2){//0, k  
                    move(i);
                    break; 
                }
            }
            System.out.printf("#%d %d", tc, answer);
            System.out.println();
        }

    }



    public static void move(int k) {
        int x= 99;
        int y = k;
        while(true) {
            if(x==0) {
                answer = y;
                break;
            }
            for(int i=0;i<3;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx >=0 && nx <100 && ny>=0 && ny < 100 && ladder[nx][ny] == 1) {
                    ladder[x][y] = 3;
                    x = nx; 
                    y = ny;
                }
            }
        }  
    }
    
}
