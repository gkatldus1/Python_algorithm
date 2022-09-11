import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시터자리잡기2 {
  static class Gate {
    int pos;
    int fisher;

    public Gate(int pos, int fisher) {
      this.pos = pos;
      this.fisher = fisher;
    }
  }

  static int N; // 낚시터의 수 N
  static Gate[] gates; // 게이트 정보 저장
  static int min = Integer.MAX_VALUE, fisherCnt; // min: 최소이동거리 (정답)
  static boolean[] selected; // 순열 selected 배열
  static int[] map; // 낚시터

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      int N = Integer.parseInt(br.readLine());
      map = new int[N + 1];
      gates = new Gate[3 + 1];
      selected = new boolean[3 + 1];
      StringTokenizer st;
      for (int i = 1; i <= 3; i++) {
        st = new StringTokenizer(br.readLine());
        int pos = Integer.parseInt(st.nextToken());
        int fisher = Integer.parseInt(st.nextToken());
        gates[i] = new Gate(pos, fisher);
      }
      DFS(0, 0);
      System.out.println("#" + tc + " " + min);

    }

  }

  private static void DFS(int cnt, int sum) {
    if (sum >= min) {
      return;
    }
    if (cnt == 3) {

      min = Math.min(min, sum);
      return;
    }

    for (int i = 1; i <= 3; i++) {
      if (selected[i])
        continue;
      // 1. 게이트 선택
      selected[i] = true;
      // 2. 낚시꾼 배치
      // System.out.println(sum);
      DFS(cnt + 1, sum + inFishers(i, gates[i].fisher, true));
      outFishers(i);

      if (gates[i].fisher % 2 == 0) {
        DFS(cnt + 1, sum + inFishers(i, gates[i].fisher, false));
        outFishers(i);
      }

      // 3. 선택해제
      selected[i] = false;

    }
  }

  // 낚시꾼 배치 함수, flag=true이면 왼쪽 -> 오른쪽, false이면 오른쪽 -> 왼쪽 순서로 배치
  private static int inFishers(int idx, int fishers, boolean flag) {
    int distance = 0;
    fisherCnt = 0; // 현재까지 배치한 낚시꾼 수
    int sum = 0;

    while (fisherCnt < fishers) {
      sum += flag ? left(idx, distance) : right(idx, distance);

      if (fisherCnt == fishers)
        break;

      sum += flag ? right(idx, distance) : left(idx, distance);
      distance++;
    }

    return sum;
  }

  private static int left(int idx, int distance) {
    int left = gates[idx].pos - distance;

    if (left > 0 && map[left] == 0) {
      map[left] = idx;
      fisherCnt++;
      return distance + 1;
    }
    return 0;
  }

  private static int right(int idx, int distance) {
    int right = gates[idx].pos + distance;

    if (right <= N && map[right] == 0) {
      map[right] = idx;
      fisherCnt++;
      return distance + 1;
    }
    return 0;
  }

  private static void outFishers(int idx) {
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (map[i] == idx) {
        map[i] = 0;
        cnt++;
      }

      if (cnt == gates[idx].fisher)
        return;
    }
  }

}
