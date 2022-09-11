import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//한 정점~모든정점 최단경로는 다익스트라,,,
class Node implements Comparable<Node> {
	int idx, weight;

	Node(int idx, int weight) {
		this.weight = weight;
		this.idx = idx;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class BJ_1753_윤호운 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 1부터시작
		int e = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine()); // 시작 정점

		ArrayList<Node>[] arr = new ArrayList[v + 1];
		// 노드 방문표시
		boolean[] visited = new boolean[v + 1];
		// k에서 ?까지 가중치넣을 배열
		int[] dist = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = 100000000; // 큰값으로 초기화~
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			// 가중치랑 연결노드 저장
			arr[Integer.parseInt(st.nextToken())]
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(k, 0)); // 시작정점 넣기
		dist[k] = 0; // 시작정점 -시작정점 가증치는 0

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			// 방문한 노드면 다음노드로
			if (visited[now.idx])
				continue;
			visited[now.idx] = true;
			// 나랑 연결된 노드인 next노드 살펴보기
			for (int i = 0; i < arr[now.idx].size(); i++) {
				Node next = arr[now.idx].get(i);
				// 'k~next까지 거리'가 'k~나까지의거리 + next의 가중치' 보다 크면 dist값 업데이트~
				if (dist[next.idx] > dist[now.idx] + next.weight) {
					dist[next.idx] = dist[now.idx] + next.weight;
					// 업데이트한 가중치 큐에 삽입
					pq.offer(new Node(next.idx, dist[next.idx]));
				}

			}
		}

		for (int i = 1; i <= v; i++) {
			if (dist[i] == 100000000)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}

		System.out.println(sb);

	}
}
