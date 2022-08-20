package 분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2630 {
    static int N;
    static int[][] paper;
    static int b_count;
    static int w_count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        color(0, 0, N);
        System.out.println(w_count);
        System.out.println(b_count);

    }

    private static void color(int r, int c, int size){
        if(isPossible(r, c, size)){
            return;
        } 

        int half = size/2;

        color(r, c, half);    //왼쪽 위
        color(r, c+half, half);    //오른쪽 위
        color(r+half, c, half);     //왼쪽 아래
        color(r+half, c+half, half);     //오른쪽 아래

    }

    private static boolean isPossible(int r, int c, int size){
        int value = paper[r][c];
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(value!=paper[i][j]){
                    return false;
                }
            }
        }
        if(value==0)    w_count++;
        else    b_count++;
        return true;
    }

}
