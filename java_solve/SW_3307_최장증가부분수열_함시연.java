import java.util.Scanner;

public class SW_3307_최장증가부분수열_함시연 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int[] input = new int[n];
            int[] dp = new int[n];
            int max = 0;
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (input[j] < input[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println("#" + t + " "+max);

        }



    }
}
