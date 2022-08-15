import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDeliv {
    static int[][] map;
    static List<Integer> sum_list = new ArrayList<>();
    static List<Home> home = new ArrayList<>();
    static List<Chicken> chicken = new ArrayList<>();
    static Chicken[] selected;
    static int min = Integer.MAX_VALUE;
    static class Home{
        int x;
        int y;
        public Home(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Chicken{
        int x;
        int y;
        public Chicken(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    chicken.add(new Chicken(i, j));
                }else if(map[i][j] == 1){
                    home.add(new Home(i, j));
                }
            }
        }
        combi(chicken.size(), M);
        System.out.println(min);
    }

    static void combi(int n, int r){
        for(int i=0; i<(1<<n); i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if((i&(1<<j))>0){   //==1로 하니까 틀렸어 왜?? 왜냐면 이진법으로 일이 왼쪽으로 갈수록 2곱하기때문이야 바보야
                    cnt++;
                }
            }

            if(cnt == r){
                findStreet(n, i);
            }

        }
    }

    static void findStreet(int size, int select){
        int chicken_st = 0;
        
        for(int i=0; i<home.size(); i++){   //각각의 집마다 치킨 거리를 구해준다.
                int h_r = home.get(i).x;
                int h_c = home.get(i).y;
                int min_st = Integer.MAX_VALUE; //개개의 집에서 치킨거리의 최솟값을 비교할 변수
        
                for(int j=0; j<size; j++){
                    if((select&1<<j)>0){
                        int ch_r = chicken.get(j).x;
                        int ch_c = chicken.get(j).y;
                        int temp = Math.abs(h_r-ch_r)+Math.abs(h_c-ch_c);
                        min_st = Math.min(min_st, temp);
                    }
                }
                chicken_st += min_st;
            }
            min = Math.min(chicken_st, min);
            
    }



}
