import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class shuffle {
  static int N, ans;

  static int[] shuffle(int[] left, int[] right, int idx) {
    int[] ans = new int[N];
    int lIdx = idx;
    int rIdx = N / 2;
    for (int i = 0; i < N; i++) {

      // 오른쪽만 넣을때
      if (lIdx - idx >= N / 2) {
        ans[i] = right[rIdx - N / 2];
        rIdx++;
        continue;
      }

      // 왼쪽만 넣을때
      if (rIdx - N / 2 >= N / 2) {
        ans[i] = left[lIdx - idx];
        lIdx++;
        continue;
      }

      // 번갈아가면서 넣을 때
      if (rIdx <= lIdx) {
        ans[i] = right[rIdx - N / 2];
        rIdx++;
      } else {
        ans[i] = left[lIdx - idx];
        lIdx++;
      }
    }

    return ans;
  }

  static int[][] divideCard(int[] total) {
    int[][] twoArray = new int[2][N / 2];
    for (int i = 0; i < N; i++) {
      twoArray[i / (N / 2)][i % (N / 2)] = total[i];
    }
    return twoArray;
  }

  static boolean chk(int[] array) {
    boolean flagUp = true;
    boolean flagDown = true;
    for (int i = 0; i < N; i++) {
      if (i + 1 != array[i])
        flagUp = false;
      if (N - i != array[i])
        flagDown = false;
      if (!flagUp && !flagDown)
        return false;
    }
    return true;
  }

  static void dfs(int dep, int[] cardArray) {
    if (dep >= ans || dep > 5) // 정답과 같거나 dep가 5를 초과하는 경우
      return;

    if (chk(cardArray)) {// 오름차순이거나 내림차순인 경우
      ans = Math.min(ans, dep);
      return;
    }

    int[][] dividedArray = divideCard(cardArray);// 카드 분리
    for (int i = 0; i < N; i++) {
      dfs(dep + 1, shuffle(dividedArray[0], dividedArray[1], i));
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    for (int t = 1; t <= T; t++) {
      // 초기화 & 입력
      ans = Integer.MAX_VALUE;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      int[] inputArray = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        inputArray[i] = Integer.parseInt(st.nextToken());
      }
      dfs(0, inputArray);
      System.out.println("#" + t + " " + (ans <= 5 ? ans : -1));
    }
  }

}
