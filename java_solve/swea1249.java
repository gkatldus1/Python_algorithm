import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1249 {
    static int T;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c)-'0';
                }
            }

            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = map[i][j];
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp1 = -1;
                    int temp2 = -1;
                    if (isIn(i - 1, j)) {
                        temp1 = dp[i][j] + dp[i - 1][j];
                    }
                    if (isIn(i, j - 1)) {
                        temp2 = dp[i][j - 1] + dp[i][j];
                    }
                    if (temp1 != -1 && temp2 != -1) {
                        dp[i][j] = Math.min(temp1, temp2);
                    } else if (temp1 != -1) {
                        dp[i][j] = temp1;
                    } else if(temp2 != -1) {
                        dp[i][j] = temp2;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

            sb.append(String.format("#%d %d%n", tc, dp[N-1][N-1]));
        }
        System.out.println(sb);
    }

    static boolean isIn(int r, int c) {
        return (0 <= r && r < N && 0 <= c && c < N);
    }
}
