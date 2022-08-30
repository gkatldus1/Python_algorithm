import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17144 {
  static int[][] map;
  static int R, C, T;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int[] dyson_r = new int[2];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    int idx = 0;
    for (int r = 0; r < R; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < C; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());
        if (map[r][c] == -1) { // 공기 청정기 위치 기록
          dyson_r[idx++] = r;
        }
      }
    }
    // for (int[] arr : map) {
    // System.out.println(Arrays.toString(arr));
    // }
    for (int i = 0; i < T; i++) {
      spread();
      dyson();
    }
    int result = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] != -1)
          result += map[i][j];
      }
    }
    System.out.println(result);

  }

  static void dyson() {
    int start = dyson_r[0];

    // 위에
    int temp1 = map[start][C - 1];// 처음 사라지는 모서리 저장
    for (int c = C - 1; c > 1; c--) { // 맨 아래 라인
      map[start][c] = map[start][c - 1];
    }
    map[start][1] = 0;

    int temp2 = map[0][C - 1];
    for (int r = 0; r <= start - 2; r++) {// 올라가는 라인
      map[r][C - 1] = map[r + 1][C - 1];
    }
    map[start - 1][C - 1] = temp1; // 사라진 모서리 복구

    int temp3 = map[0][0];
    for (int c = 0; c < C - 2; c++) {// 맨 위에 라인
      map[0][c] = map[0][c + 1];
    }
    map[0][C - 2] = temp2;

    for (int r = start - 1; r > 1; r--) {// 내려가는 라인
      map[r][0] = map[r - 1][0];
    }
    map[1][0] = temp3;

    // 아래
    int start2 = dyson_r[1];
    temp1 = map[start2][C - 1];
    for (int c = C - 1; c > 1; c--) {
      map[start2][c] = map[start2][c - 1];
    }
    map[start2][1] = 0;
    temp2 = map[R - 1][C - 1];
    for (int r = R - 1; r > start2 + 1; r--) {
      map[r][C - 1] = map[r - 1][C - 1];
    }
    map[start2 + 1][C - 1] = temp1;
    temp3 = map[R - 1][0];
    for (int c = 0; c < C - 2; c++) {
      map[R - 1][c] = map[R - 1][c + 1];
    }
    map[R - 1][C - 2] = temp2;

    for (int r = start2 + 1; r < R - 2; r++) {
      map[r][0] = map[r + 1][0];
    }
    map[R - 2][0] = temp3;
  }

  static void spread() {
    int[][] copyMap = new int[R][C];
    int cnt = 0;
    // for (int i = 0; i < R; i++) {
    // copyMap[i] = Arrays.copyOf(map[i], C);
    // }
    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (map[r][c] > 0) {// 미세먼지가 존재한다면
          for (int i = 0; i < 4; i++) {
            int dir_x = r + dx[i];
            int dir_y = c + dy[i];
            if (isValid(dir_x, dir_y)) {// 확산 될 수 있는 곳을 발견하고
              copyMap[dir_x][dir_y] += (map[r][c] / 5); // 확산해주고
              // for (int[] arr : copyMap) {
              // System.out.println(Arrays.toString(arr));
              // }
              cnt++;
            }
          }
          copyMap[r][c] += map[r][c] - ((map[r][c] / 5) * cnt); // 확산된 수 만큼 빼준다.
          cnt = 0;
        } else if (map[r][c] == -1) {
          copyMap[r][c] = -1;
        }
      }
    }
    map = copyMap;
  }

  static boolean isValid(int x, int y) {
    if (x >= 0 && x < R && y >= 0 && y < C && map[x][y] > -1) {
      // 범위를 벗어나지 않고 공기청정기가 아니면 트루
      return true;
    } else
      return false;
  }
}
