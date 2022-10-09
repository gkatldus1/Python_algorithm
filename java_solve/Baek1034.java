import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1034 {
    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    zeroCnt++;
            }

            int rowCnt = 0;
            if (zeroCnt <= K && (zeroCnt % 2) == (K % 2)) { //전부 켜질 수 있는 행을 발견하면 이와 같은 행을 세준다.
                for (int j = 0; j < N; j++) {
                    if (isEqual(map[i], map[j]))
                        rowCnt++;
                }
            }
            max = Math.max(max, rowCnt);

        }
        
        System.out.println(max);

    }
    
    static boolean isEqual(int[] arr1, int[] arr2) {
        boolean isSame = true;
        for (int i = 0; i < M; i++) {
            if (arr1[i] != arr2[i]) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }
    
    
}
