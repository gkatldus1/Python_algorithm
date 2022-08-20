import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4012two {
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
            selected = new int[N/2];
            S = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0,0, N/2);
            System.out.println("#"+loop+" "+min);
            min = Integer.MAX_VALUE;
        }
    }

    static void combination(int start,int depth, int r){    //조합으로 N/2개만큼 재료를 선택
        if(depth == r){
            int cnt = 0;
            int[] B_selected = new int[N/2];
            for(int i=0; i<N; i++){ //A에 선택되지 않은 재료를 B에 넣어줌
                if(isSelected[i]){
                    continue;
                }
                B_selected[cnt++] = i;
            }

            A = 0;
            B = 0;
            for(int i=0; i<N/2-1; i++){//선택된 재료 중 2개를 조합하여 맛을 더해줌
                for(int j=i+1; j<N/2; j++){
                    A+= S[selected[i]][selected[j]];
                    A+= S[selected[j]][selected[i]];
                }
            }
            for(int i=0; i<N/2-1; i++){//선택된 재료 중 2개를 조합하여 맛을 더해줌
                for(int j=i+1; j<N/2; j++){
                    B+= S[B_selected[i]][B_selected[j]];
                    B+= S[B_selected[j]][B_selected[i]];
                }
            } 
            
            int temp = Math.abs(A-B);
            min = Math.min(temp, min);
            return;
        }
        for(int i=start; i<N; i++){
            isSelected[i] = true;
            selected[depth] = i;
            // System.out.println(selected[depth]);
            combination(i+1, depth+1, r);
            isSelected[i] = false;
        }
    }
    
}
