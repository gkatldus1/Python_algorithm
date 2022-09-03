import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2491 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    if (N == 1) {
      System.out.println(1);
      System.exit(0);

    }
    int max = Integer.MIN_VALUE;
    int cnt = 1;
    // 작아지는 값
    for (int i = 0; i < N - 1; i++) {
      if (nums[i] <= nums[i + 1]) {
        cnt++;
        max = Math.max(max, cnt);
      } else
        cnt = 1;
    }
    cnt = 1;
    // 커지는 값
    for (int i = 0; i < N - 1; i++) {
      if (nums[i] >= nums[i + 1]) {
        cnt++;
        max = Math.max(max, cnt);
      } else
        cnt = 1;
    }
    System.out.println(max);
  }
}
