import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class maze {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int loop=0; loop<T; loop++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int pos_y = Integer.parseInt(st.nextToken());
            int pos_x = Integer.parseInt(st.nextToken());
            
            int jumper = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[][] area = new int[N+1][N+1];
            int j_x = 0;
            int j_y = 0;
            for(int i=0; i<jumper; i++){
                j_x = Integer.parseInt(st.nextToken());
                j_y = Integer.parseInt(st.nextToken());
                area[j_y][j_x] = 1;
            }
            // for (int r = 0; r < N+1; r++) {
            //     for (int c = 0; c < N+1; c++) {
            //         System.out.printf("%-2d", area[r][c]);
            //     }
            //     System.out.println();
            // }
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[][]orders = new int[count][2];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<count; i++){
                orders[i][0] = Integer.parseInt(st.nextToken());
                orders[i][1] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<count; i++){
                if(orders[i][0] == 1){
                    for(int j=1; j<=orders[i][1]; j++){
                        pos_y -= 1;
                        if(pos_y < 1 ){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                        if(area[pos_y][pos_x] == 1){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                    }
                }
                if(orders[i][0] == 2){
                    for(int j=1; j<=orders[i][1]; j++){
                        pos_x += 1;
                        if(pos_x > 8 ){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                        if(area[pos_y][pos_x] == 1){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                    }
                }
                if(orders[i][0] == 3){
                    for(int j=1; j<=orders[i][1]; j++){
                        pos_y += 1;
                        if(pos_y > 8 ){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                        if(area[pos_y][pos_x] == 1){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                    }
                }
                if(orders[i][0] == 4){
                    for(int j=1; j<=orders[i][1]; j++){
                        pos_x -= 1;
                        if(pos_x < 1 ){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                        if(area[pos_y][pos_x] == 1){
                            pos_y = 0;
                            pos_x = 0;
                            break;
                        }
                    }
                }
            }
            System.out.printf("#%d ",loop+1);
            System.out.println(pos_y+" "+pos_x);
        }
    }
}
