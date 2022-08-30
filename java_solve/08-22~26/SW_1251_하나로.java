import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_1251_하나로 {
    static class line implements Comparable<line> {
        int x;
        int y;
        double weight;

        public line(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(line o) {
            if (this.weight > o.weight)
                return 1;
            else if (this.weight < o.weight)
                return -1;
            return 0;
        }
    }

    static int parent[];
    static int N;
    static line[] pos;
    static double min;
    static double e;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<line> weights = new ArrayList<>(); // 간선들의 길이를 저장할 리스트
            N = Integer.parseInt(br.readLine());
            pos = new line[N]; // 입력 받은 노드들을 저장할 배열

            for (int i = 0; i < N; i++) {
                pos[i] = new line(0, 0, 0); // 노드들을 저장할 객체들 생성
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pos[i].x = Integer.parseInt(st.nextToken()); // x좌표 입력
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pos[i].y = Integer.parseInt(st.nextToken()); // y좌표 입력
            }
            e = Double.parseDouble(br.readLine());

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    weights.add(new line(i, j,
                            Math.pow(Math.abs(pos[i].x - pos[j].x), 2) + Math.pow(Math.abs(pos[i].y - pos[j].y), 2)));
                    // 모든 노드들의 간선 쌍의 경우의 수를 구해서 저장!
                } // 리스트에 저장
            }

            // 두 점의 연결 여부를 확인할 parent 배열 만들기(처음엔 서로소)
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            double ans = 0.0;

            Collections.sort(weights); // 간선의 길이를 오름차순으로 정렬(크루스컬 알고리즘을 위해)

            for (int i = 0; i < weights.size(); i++) { // 작은 길이의 간선부터 서클을 이루는지 확인 후(같은 집합인지 아닌지 분별) 아니라면 union하여 연결시켜준다.
                if (!isSameParent(weights.get(i).x, weights.get(i).y)) {
                    union(weights.get(i).x, weights.get(i).y);
                    ans += weights.get(i).weight; // 연결된 간선의 합들을 구해나간다.
                }
            }

            ans *= e; // 구한 값에 가중치를 곱해준다.

            System.out.println("#" + tc + " " + Math.round(ans));
        }
    }

    // 매개변수의 부모를 찾는 메서드
    static int findParent(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = findParent(parent[x]); // path compression
    }

    // 부모가 다르면 연결해주는 메서드
    static void union(int x, int y) {
        // 부모 찾기
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            parent[y] = x; // 연결
        }
    }

    // 부모가 같은지 확인
    static boolean isSameParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y)
            return false;

        return true;
    }
}
