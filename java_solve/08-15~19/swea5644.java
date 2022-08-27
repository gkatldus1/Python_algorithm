import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea5644 {
    static int dx[] = {0, -1, 0, 1, 0};
    static int dy[] = {0, 0, 1, 0, -1};
    
    static int[] A_move;
    static int[] B_move;
    static int A;
    static int ans;
    static int M;
    static ArrayList<Battery> list = new ArrayList<>();
    static class Battery{
        int x;
        int y;
        int c;
        int p;
        public Battery(int x, int y, int c, int p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int loop=1; loop<=T; loop++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            A_move = new int[M];
            B_move = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                A_move[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B_move[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                list.add(new Battery(x, y, c, p));
            }
    
            ans = move();
            System.out.println("#"+loop+" "+ans);

        }
    }

    static int move(){
        int x1 = 1;
        int y1 = 1;
        int x2 = 10;
        int y2 = 10;

        //0 초일때 합
        int sum = getMax(x1,y1,x2,y2);

        for(int time=0; time<M; time++){
            x1 += dx[A_move[time]];
            y1 += dy[A_move[time]];
            x2 += dx[B_move[time]];
            y2 += dy[B_move[time]];

            sum += getMax(x1,y1,x2,y2);
        }
        return sum;
    }

    static int getMax(int x1, int y1, int x2, int y2){
        int[][] amount = new int[2][A]; //사용자의 충전 가능한 배터리 값을 넣어줌
        //사용자A의 충전가능한 P값
        for(int i=0; i<A; i++){
            amount[0][i] = check(x1,y1,i);
        }
        //사용자B의 충전가능한 P값
        for(int i=0; i<A; i++){
            amount[1][i] = check(x2,y2,i);
        }

        //사용자 둘의 충전량의 합 중 최댓값을 구해준다.
        int max = 0;
        for(int i=0; i<A; i++){
            for(int j=0; j<A; j++){
                int sum = amount[0][i] + amount[1][j];
                
                //같은 BC 값일 경우 반으로 나눠줌
                if(i==j&&amount[0][i] == amount[1][j]){
                    sum /= 2;
                }
                max = Math.max(max, sum);
            }    
        }
        return max;
    }

    static int check(int x, int y, int BCnum){
        int a = Math.abs(x-list.get(BCnum).x);
        int b = Math.abs(y-list.get(BCnum).y);
        int dist = a+b;
        return dist<=list.get(BCnum).c ? list.get(BCnum).p : 0;
    }
}
