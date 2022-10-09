import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502_연구소_함시연 {
	static int max;
	static int N, M;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Point> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map;
		map = new int[N][M];
		for(int r = 0; r<N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					list.add(new Point(r, c));
				}
			}
		}
//		for(int[] arr: map) {
//			System.out.println(Arrays.toString(arr));
//		}
		max = Integer.MIN_VALUE;
		wall(map, 0);
		System.out.println(max);
		
		
	}
	static void wall(int[][] map, int cnt) {
		if(cnt == 3) {//벽 세 개 다 세웠으면
			
			//bfs로 감염병 전파
			bfs(map);
			//전파 완료 후 개수 세기
			int result = getSafe(map);
			max = Math.max(result, max);
			
			return;
		}
		int[][] newMap = new int[N][M]; 
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {	//벽이랑 병이 있는 곳이 아니라면 
					copy(map, newMap);
					newMap[r][c] = 1;
					wall(newMap, cnt+1);
					
				}
			}
		}
	}
	static void bfs(int[][] map) {
		Queue<Point> queue = new ArrayDeque<>();
		for(int i=0; i<list.size(); i++) {	//바이러스의 위치들을 큐에 넣어줌
			queue.offer(list.get(i));
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			//4방 탐색
			for(int d=0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr>=0 && nr<N&& nc>=0 && nc<M && map[nr][nc] == 0) {//범위를 벗어나지 않고
					map[nr][nc] = 2;
					queue.offer(new Point(nr, nc));
				}
			}
			
		}
		
	}
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	
	static int getSafe(int[][] map) {
		int result = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					result++;
				}
			}
		}
		return result;
	}
	
	
	
	static void copy(int[][] map, int[][] newMap) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
	
}
