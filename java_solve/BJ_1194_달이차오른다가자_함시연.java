import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1194_달이차오른다가자_함시연 {
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static int N, M;
	static int cnt;
	static class Point{
		int r, c;
		int key;
		
		public Point(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}
	
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Point minsik = null;
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == '0') {//민식이 출발 지점 기록해주기
					minsik = new Point(r, c, 0);
				}
			}
		}
		System.out.println(bfs(minsik));
//		for(char[] arr: map) {
//			System.out.println(Arrays.toString(arr));
//		}
		
	}
	
	static int bfs(Point minsik) {
		
		Queue<int[]>queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64];
		
		visited[minsik.r][minsik.c][0] = true;
		queue.add(new int[] {minsik.r, minsik.c, 0 });
		int size;
		while(!queue.isEmpty()) {
			cnt++;
			size = queue.size();
			
			while(size-->0) {
				int[] cur = queue.poll();
				for(int i=0; i<4; i++) {
					int nr = cur[0] + deltas[i][0];
					int nc = cur[1] + deltas[i][1];
					if(nr<0 || nr>=N || nc<0 || nc >= M || map[nr][nc] == '#')	continue;	//경로를 벗어나면 안돼 돌아가
					if(map[nr][nc] == '1')	return cnt;
					//열쇠가 없다면
					if(Character.isUpperCase(map[nr][nc]) && (cur[2]&(1<<(map[nr][nc]-'A')))==0)	continue;
					//열쇠 기록
					int key = cur[2];
					if(Character.isLowerCase(map[nr][nc]))	key|=(1<<map[nr][nc]-'a');
					// 방문했던 곳이면 돌아가기
					if(visited[nr][nc][key]) continue;
					visited[nr][nc][key] = true;
					queue.add(new int[] {nr,nc, key});	
				}
			}
		}
		return -1;
	}
}
