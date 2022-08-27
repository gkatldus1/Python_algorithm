import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek4485 {
  static class Node implements Comparable<Node> {
    int r;
    int c;
    int weight;

    public Node(int r, int c, int weight) {
      this.r = r;
      this.c = c;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }

  }

  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };
  static int N;
  static int[][] map;
  static int[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int cnt = 0;
    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;
      map = new int[N][N]; // 입력받을 루피에 대한 정보
      visited = new int[N][N]; // 해당 좌표까지의 최소값을 갱신하며 저장할 배열
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          visited[i][j] = Integer.MAX_VALUE; // 처음 최댓값으로 초기화
        }
      }
      dijk();
      cnt++;
      sb.append("Problem" + " " + cnt + ": " + visited[N - 1][N - 1] + "\n");
    }
    System.out.print(sb.toString());
  }

  static void dijk() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, map[0][0])); // 0,0에서 시작
    visited[0][0] = map[0][0];

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      int r = now.r;
      int c = now.c;
      int weight = now.weight; // 현재 위치에 올때까지 걸린 비용

      if (r == N - 1 && c == N - 1)
        break; // 이전 반복에서 목적지에 대한 정보가 갱신되었으므로 탈출

      if (visited[r][c] < weight)
        continue; // 가지치기

      for (int i = 0; i < 4; i++) {// 4방위를 탐색하며 최소값 갱신
        int dr = r + dx[i];
        int dc = c + dy[i];
        if (!isValid(dr, dc))
          continue;

        if (visited[dr][dc] > map[dr][dc] + weight) { // 현재 위치까지의 비용과 앞으로 가게될 좌표의 비용을 합친 값이
          visited[dr][dc] = map[dr][dc] + weight; // 기존 기록된 비용보다 작을 시에 갱신
          pq.offer(new Node(dr, dc, visited[dr][dc]));
        }
      }

    }

  }

  static boolean isValid(int r, int c) {
    return (r >= 0 && r < N && c >= 0 && c < N);
  }
}
