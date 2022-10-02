import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class swea1249two {
    static int T;
    static int[][] map;
    static int N;
    static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };   //상좌우하
    static int[][] ans;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c) - '0';
                }
            }
            min = Integer.MAX_VALUE;
            ans = new int[N][N];
            for (int i = 0; i < ans.length; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;
            bfs(0, 0);
            sb.append(String.format("#%d %d%n", tc, min));
        }
        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                Point head = queue.poll();
                if (head.x == N - 1 && head.y == N - 1) {
                    min = min > ans[N - 1][N - 1] ? ans[N - 1][N - 1] : min;
                }
                if (min <= ans[head.x][head.y])
                    continue;
                for (int i = 0; i < 4; i++) {
                    int nr = head.x + deltas[i][0];
                    int nc = head.y + deltas[i][1];
                    if (!isIn(nr, nc))
                        continue;
                    if (!visited[nr][nc]||ans[nr][nc] > ans[head.x][head.y] + map[nr][nc]) {
                        visited[nr][nc] = true;
                        ans[nr][nc] = ans[head.x][head.y] + map[nr][nc];
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }


      
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isIn(int r, int c) {
        return (0 <= r && r < N && 0 <= c && c < N);
    }

}
