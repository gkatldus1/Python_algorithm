

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea3234 {
    
    static int ans;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        boolean[]selected;
        int[] weight;
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            selected = new boolean[N];
            weight = new int[N];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }
            permutation(0, N, 0, 0, selected, weight, N);
            
            sb.append("#"+tc+" "+ans+"\n");
            Arrays.fill(selected, false);
            ans = 0;
        }
        System.out.println(sb);
    }

    static void permutation(int cnt, int r, int right_sum, int left_sum, boolean[] selected, int[] weight, int N){
        if(cnt == r){
            ans++;
            return;
        }
        //순열과 부분집합을 동시에
        for(int i=0; i<N; i++){
            if(selected[i]) continue;
            selected[i] = true;
            //왼쪽 저울에 추 올리기
            permutation(cnt+1, r, right_sum, left_sum+weight[i], selected, weight, N);
            //추를 올려도 왼쪽보다 작을 경우만
            if(right_sum+weight[i]<=left_sum){
                //오른쪽 저울에 추 올리기
                permutation(cnt+1, r, right_sum+weight[i], left_sum, selected, weight, N);
            }
            selected[i] = false;
            
        }
    }

    
}
