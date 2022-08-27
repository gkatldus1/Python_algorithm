import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7576 {
    public static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N;
    static int M;
    static int d_cnt;
    static int t_cnt;
    static int t_num;

    static class pos {
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<pos> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new pos(i, j));
                }
                if (map[i][j] == 0)
                    t_num++;
            }
        }
        if (t_num == 0) { // 받은 익지 않은 토마토의 개수가 0이라면 바로 끝내준다.
            System.out.println(0);
            System.exit(0);
        }

        bfs();

        if (t_cnt == t_num)
            System.out.println(d_cnt);
        else
            System.out.println(-1);

    }

    static void bfs() {

        while (!queue.isEmpty()) { // 방문대상이 있을때까지 반복
            int size = queue.size(); // 큐의 크기 확인
            d_cnt++; // 지나간 날짜 세주기

            while (--size >= 0) { // 반복 진입 전 구한 큐 크기만큼만 반복
                pos current = queue.poll(); // 방문차례인 대상 정보 꺼내기
                // 방문해서 해야할 일 처리
                for (int i = 0; i < 4; i++) {
                    int dir_x = current.x + dx[i];
                    int dir_y = current.y + dy[i];
                    // 맵을 벗어나거나 0이 아니면 돌아가기
                    if (dir_x < 0 || dir_x >= N || dir_y < 0 || dir_y >= M || map[dir_x][dir_y] != 0)
                        continue;

                    map[dir_x][dir_y] = 1;
                    t_cnt++; // 바꾼 토마토의 개수 세주기
                    queue.offer(new pos(dir_x, dir_y));
                }

            }
            if (t_cnt == t_num)
                break; // 바꾼 토바토의 개수가 입력 받은 토마토의 개수와 같다면 함수 끝
        }
    }

}
