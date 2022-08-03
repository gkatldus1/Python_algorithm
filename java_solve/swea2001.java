import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int loop = 1; loop <=T; loop++){
            int max = 0;
            int temp = 0;
            StringTokenizer st= new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());   //2차원 배열 입력 받아 저장
                }
            }
            for(int i=0; i<N-M+1; i++){     //처음부터 M의 크기만큼 탐색
                for(int j=0; j<N-M+1; j++){
                    temp = 0;
                    for(int k=0; k<M; k++){     
                        for(int l=0; l<M; l++){
                            temp += map[i+k][j+l];      //M*M크기만큼 더해줌
                        }
                    }
                    max = Math.max(max, temp);      //max값을 찾는 코드
                }
            }

            System.out.println("#"+loop+" "+max);


        }
    }
}   
