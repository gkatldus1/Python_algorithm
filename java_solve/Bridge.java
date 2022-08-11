import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bridge {
    
    static int[][] dp=new int[30][30];  //메모이제이션을 위한 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int loop=1; loop<=tc; loop++){
            st= new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            sb.append(combi(east, west)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    static int combi(int n, int r){     //재귀로 조합을 구해주고 배열에 저장하여 시간복잡도를 낮춘다.
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        if(n==r || r==0){
            return dp[n][r] = 1;
        }
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
