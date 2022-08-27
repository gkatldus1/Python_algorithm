import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baek1753
 */
public class Baek1753 {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] list = new ArrayList[V + 1];
        int start = Integer.parseInt(br.readLine());
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
        }

        int[] visited = new int[V + 1];// 스타트 노드에서부터의 거리 모음 배열
        Arrays.fill(visited, Integer.MAX_VALUE);
        // visited[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            int to = temp.to;
            int weight = temp.weight;
            if (visited[to] != Integer.MAX_VALUE)// 이미 방문한 곳이면 처음으로
                continue;
            // 새로 방문한 노드를 추가시키고
            visited[to] = weight;
            // 그 노드와 연결된 다른 노드들과의 거리를 기존 기록과 비교해 갱신시킨다.
            for (int i = 0; i < list[to].size(); i++) {
                int another_to = list[to].get(i).to;
                int another_weight = list[to].get(i).weight;
                if (visited[another_to] > visited[to] + another_weight) {// 기존 거리 보다 더 짧으면 갱신시켜주자
                    pq.offer(new Node(another_to, visited[to] + another_weight));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(visited[i] + "\n");
        }
        System.out.println(sb.toString());
    }

}