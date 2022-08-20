package 분할정복;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Baek1992 {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        
        for(int i=0; i<N;i++){
            String str  = br.readLine();
            for(int j=0; j<N; j++){
                video[i][j] = str.charAt(j)-'0';
            }
        }
        press(0, 0, N);
        System.out.println(sb);
    }

    static void press(int r, int c, int N){
        //압축이 가능한 경우 압축
        if(isPossible(N, r, c)){
            sb.append(video[r][c]);
            return;
        }

        int half = N/2;

        sb.append('(');

        press(r, c, half);  //왼쪽 위
        press(r, c+half, half);  //오른쪽 위
        press(r+half, c, half);//왼쪽 아래
        press(r+half, c+half, half);//오른쪽 아래

        sb.append(')');

    }

    //압축이 가능한지 체크
    static boolean isPossible(int N, int r, int c){
        int value = video[r][c];

        for(int i = r; i< r+N; i++){
            for(int j=c; j<c+N; j++){
                if(value != video[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


}
