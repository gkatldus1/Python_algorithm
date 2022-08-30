import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ17135 {
  static int N, M, D;
  static int[][] map;
  static int selected[] = new int[3];
  static int enemy_cnt = Integer.MIN_VALUE;

  static class Point {
    int r;
    int c;
    int dis;

    public Point(int r, int c, int dis) {
      this.r = r;
      this.c = c;
      this.dis = dis;
    }

  }

  static ArrayList<Point> enemy_list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    combination(0, 0);
    System.out.println(enemy_cnt);
  }

  static void combination(int cnt, int start) {
    if (cnt == 3) {// 궁수 세 명의 위치가 선택되었다면 계산하는 함수 호출

      calc(selected);
      return;
    }

    for (int i = start; i < M; i++) {// M개의 열 중에서 궁수 3명이 있을 위치를 조합으로 고른다.
      selected[cnt] = i;
      combination(cnt + 1, i + 1);
    }
  }

  static void calc(int[] selected) {
    int cnt = 0; // 제거 적 카운트
    int[][] copyMap = new int[N][M];
    for (int i = 0; i < N; i++)
      System.arraycopy(map[i], 0, copyMap[i], 0, M);
    int castle_row = N;
    while (castle_row > 0) {
      // 1. 첫번째 궁수부터 적들의 거리를 계산해준다.가장 가까운 위치의 적 찾기
      for (int i = 0; i < 3; i++) {
        int temp_dis = 0; // 적들을 만날때마다 거리 계산하는 임시 거리 변수
        Point min_dis = new Point(-1, -1, Integer.MAX_VALUE);// 최종적으로 가장 짧은 거리를 구하기 위한 클래스
        for (int r = 0; r < castle_row; r++) {
          for (int c = 0; c < M; c++) {
            if (copyMap[r][c] == 1) { // 적을 발견했다면

              temp_dis = Math.abs(castle_row - r) + Math.abs(selected[i] - c);// 현재 적까지의 거리를 계산

              if (temp_dis <= D) { // 적이 공격할 수 있는 D이하인 거리에 있을 때
                if (min_dis.dis > temp_dis) { // 임시 최소거리 적보다 거리가 짧을 때
                  min_dis = new Point(r, c, temp_dis);
                } else if (min_dis.dis == temp_dis) { // 임시 최소거리와 거리가 같을 때
                  if (min_dis.c > c) { // 현재 적의 위치가 보다 왼쪽에 있다면
                    min_dis = new Point(r, c, temp_dis);
                  }
                }
              }
            }
          }
        }
        // 현재 궁수의 최소 거리의 적을 찾았고 이를 다른 궁수들과 한번에 공격하기 위해 리스트에 저장해준다.
        if (min_dis.r != -1)
          enemy_list.add(min_dis);

      }
      // 모든 궁수들이 자기가 공격할 타겟 선택 완료-> 공격
      for (Point enemy : enemy_list) {
        if (copyMap[enemy.r][enemy.c] == 1) {
          cnt += 1; // 제거한 적들을 수를 카운트
          copyMap[enemy.r][enemy.c] = 0;

        }
      }
      enemy_list.clear();
      // 적을 내리는 것과 똑같은 궁수들을 위로 올린다.
      castle_row -= 1;

    }

    enemy_cnt = Math.max(enemy_cnt, cnt);
  }
}
