import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 헌터 {
  static ArrayList<Node> infos;
  static boolean[] chk; // 탐색여부
  static int ans, N, placeNum;

  // ans: 탐색하는데 걸린 최단 시간, N: 맵의 크기, placeNum: 방문해야하는 장소의 수
  static class Node implements Comparable<Node> {
    int r, c, type;

    // 타입은 행선지 정보
    // -1: 1번 고객
    // 1: 1번 몬스터
    public Node(int r, int c, int type) {
      this.r = r;
      this.c = c;
      this.type = type;
    }

    @Override
    public int compareTo(Node o) {
      return Math.abs(this.type) == Math.abs(o.type)
          ? Integer.compare(this.type, o.type)
          : Integer.compare(Math.abs(this.type), Math.abs(o.type));
    }
  }

  static int calDis(Node des, int hr, int hc) {
    return Math.abs(hr - des.r) + Math.abs(hc - des.c);
  }

  static void dfs(int dep, int sumDis, int hr, int hc) {

    if (dep == placeNum) {
      ans = Math.min(ans, sumDis);
      return;
    }

    for (int i = 0; i < placeNum; i++) {
      // 방문했거나 || 의뢰한 몬스터를 방문하지 않고 고객을 방문한 경우
      if (chk[i] || (i % 2 == 0 && !chk[i + 1]))
        continue;
      Node des = infos.get(i);// 방문할 곳 정보 가져오기
      chk[i] = true;
      dfs(dep + 1, sumDis + calDis(des, hr, hc), des.r, des.c);
      chk[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    for (int t = 1; t <= T; t++) {
      ans = Integer.MAX_VALUE;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      infos = new ArrayList<>();
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          int tmp = Integer.parseInt(st.nextToken());
          if (tmp != 0) {
            infos.add(new Node(r, c, tmp));
          }
        }
      }
      Collections.sort(infos);// 방문할 장소 정보에 따라 정렬
      placeNum = infos.size(); // 방문할 장소 수 파악
      chk = new boolean[placeNum];// 방문 여부 초기화
      dfs(0, 0, 0, 0); // 탐색 시작
      System.out.println("#" + t + " " + ans);

    }
  }
}
