import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시터자리잡기 {
  static int N;
  static int ans;
  static int[][] infos;
  static int[][] idxList = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 1, 0 }, { 2, 0, 1 } };

  static int calcDisSum(int[] posInfo) {
    int sumDis = 0;
    for (int i = 1; i <= N; i++) {
      if (posInfo[i] != 0)
        sumDis += Math.abs(posInfo[i] - i) + 1;
    }
    return sumDis;
  }

  static int findMinDis(int gate, int[] posInfo) {
    int leftDis = 0;
    while (gate - leftDis > 0 && posInfo[gate - leftDis] != 0) { // 왼쪽으로 낚시꾼이 들어갈 수 있는 자리 탐색
      leftDis++;
    }
    int rightDis = 0;
    while (gate + rightDis <= N && posInfo[gate + rightDis] != 0) {
      rightDis++; // 오른쪽으로 낚시꾼이 들어갈 수 있는 자리 탐색
    }
    int minDis = Math.min(leftDis, rightDis);
    int maxDis = Math.max(leftDis, rightDis);

    return (gate + minDis <= N && posInfo[gate + minDis] == 0) || (gate - minDis > 0 && posInfo[gate - minDis] == 0)
        ? minDis
        : maxDis;
  }

  static void dfs(int dep, int method, int[] posInfo) {
    if (dep == 3) { // 게이트 3개 다 돌았을 때
      ans = Math.min(ans, calcDisSum(posInfo));
      return;
    }

    int[] newPosInfo = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      newPosInfo[i] = posInfo[i];
    }
    int gate = infos[idxList[method][dep]][0]; // 게이트의 위치
    int fisherNum = infos[idxList[method][dep]][1]; // 게이트에 대기하는 낚시꾼

    int distance = 0;

    while (fisherNum > 1) { // 2개 이상 남은 경우 계속 수행한다.
      if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
        newPosInfo[gate + distance] = gate;
        fisherNum--;
      }
      if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
        newPosInfo[gate - distance] = gate;
        fisherNum--;
      }
      distance++;
    }

    if (fisherNum == 0) { // fisherNum==0 인 경우
      dfs(dep + 1, method, newPosInfo);
    } else { // fisherNum == 1인 경우, 왼쪽으로 갈지 오른쪽으로 갈지 분기처리

      distance = findMinDis(gate, newPosInfo);

      if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {// 마지막 남은 한개를 왼쪽에 배치할 경우
        int[] copy = new int[N + 1];
        for (int i = 0; i <= N; i++) {
          copy[i] = newPosInfo[i];
        }
        copy[gate - distance] = gate;
        dfs(dep + 1, method, copy);
      }
      if (gate + distance <= N && newPosInfo[gate + distance] == 0) {// 마지막 남은 한 명을 오른쪽에 배치할 경우
        int[] copy = new int[N + 1];
        for (int i = 0; i <= N; i++) {
          copy[i] = newPosInfo[i];
        }
        copy[gate + distance] = gate;
        dfs(dep + 1, method, copy);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      infos = new int[3][2];// 게이트의 위치와 기다리는 낚시꾼의 수

      for (int i = 0; i < 3; i++) {
        st = new StringTokenizer(br.readLine());
        infos[i][0] = Integer.parseInt(st.nextToken());
        infos[i][1] = Integer.parseInt(st.nextToken());
      }

      ans = Integer.MAX_VALUE;
      for (int method = 0; method < 6; method++) {
        // 낚시꾼들 자리에 할당하는 기능
        dfs(0, method, new int[N + 1]); // 게이트의 순서 경우의 수를 매개변수로 보내준다.
      }
      System.out.println("#" + t + " " + ans);
    }

  }
}