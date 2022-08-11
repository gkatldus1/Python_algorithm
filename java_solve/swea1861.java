import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea1861 {
    static int[][] map;     //숫자를 저장할 이차원배열
    static int[]dir_x = {1,-1,0,0}; //아래, 위, 좌, 우
    static int[]dir_y = {0,0,-1,1};
    static int N;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int loop=1; loop<=T; loop++){
            N = Integer.parseInt(br.readLine());

            
            map = new int[N][N];
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int room = -1;  //가장 많은 카운트를 가진 룸을 저장할 변수
            int max = 0;    //움직인 최대값을 저장할 변수
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int tempRoom = map[i][j];   //처음 출발한 방을 저장
                    count = 1;
                    go(i,j);
                    if(count > max){        //카운트가 max 보다 클 경우 새로 값을 갱신함
                        max = count;
                        room = tempRoom;
                    }else if(count == max){ //값이 같을땐 더 작은 방 번호를 저장해줌
                        room = (room < tempRoom) ? room :tempRoom;
                    }
                }
            }
        sb.append("#"+loop +" "+room+" "+max).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void go(int i, int j){   //조건에 맞으면 재귀 함수를 호출하며 계속 이동
        for(int k=0; k<4; k++){
            int dx = i+dir_x[k];
            int dy = j+dir_y[k];
            if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy] - map[i][j] == 1){
                count++;
                go(dx,dy);
            }
        }
    }
}


