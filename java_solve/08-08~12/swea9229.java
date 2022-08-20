import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea9229 {
    static ArrayList<ArrayList<Integer>> result;
    static int[] snacks;    //과자를 저장할 배열
    static int[] selected;  //선택된 2개의 과자를 넣을 배열
    static int M;   //입력 받을 M 그램
    static int answer;  //출력할 답
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int loop = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=loop; tc++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snacks = new int[N];
            selected = new int[2];
            answer = -1;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            combi(0,0); //재귀함수로 r=2인 조합을 구하고 조합들의 합을 구한 후, 최대값을 찾는다.
    
            System.out.println("#"+tc +" "+answer);
        }
    
    }
    private static void combi(int cnt, int start){
        if(cnt==2){
            int sum = Arrays.stream(selected).sum();
            if(sum>M) return;
            answer = answer > sum ? answer :sum;
            return;
        }

        for(int i=start; i< snacks.length; i++){
            selected[cnt] = snacks[i];
            combi(cnt+1, i+1);
        }

    }
 
}
