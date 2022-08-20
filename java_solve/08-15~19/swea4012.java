import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4012 {
    static int S[][];
    static int A;
    static int B;
    static int[] selected;
    static boolean[] isSelected;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int loop=1; loop<=T; loop++){
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            selected = new int[N];
            S = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            permutation(0, N);
            System.out.println("#"+loop+" "+min);
        }
    }

    static void permutation(int depth, int r){
        if(depth == r){
            A = 0;
            B = 0;
            for(int i=0; i<N/2-1; i++){
                for(int j=i+1; j<N/2; j++){
                    A+= S[selected[i]][selected[j]];
                    A+= S[selected[j]][selected[i]];
                }
            }
            for(int i=N/2; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    B+= S[selected[i]][selected[j]];
                    B+= S[selected[j]][selected[i]];
                }
            }  
            
            int temp = Math.abs(A-B);
            min = Math.min(temp, min);
            return;
        }
        for(int i=0; i<N; i++){
            if(isSelected[i])   continue;   //수가 선택되었다면 되돌아가기
            isSelected[i] = true;
            selected[depth] = i;
            // System.out.println(selected[depth]);
            permutation(depth+1, r);
            isSelected[i] = false;
        }
    }
    
}
