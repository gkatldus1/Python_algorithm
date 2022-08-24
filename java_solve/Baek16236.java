
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16236 {
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int count;
		int size;
		public Fish(int x, int y, int size){
			this.size = size;
			this.x = x;
			this.y = y;
		}
		public Fish(int x, int y, int size, int count){
			this.size = size;
			this.x = x;
			this.y = y;
			this.count = count;
		}
        @Override
        public int compareTo(Fish o) {
            if(this.count == o.count){ //거리가 같으면
                if(o.x==this.x)//높이가 같으면 왼쪽에 있는 순으로 정렬
                    return this.y - o.y;
                return this.x - o.x;

            }  
            return this.count - o.count;
            
        }
	}
    static int second;
	static Fish sk;
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1, 0},{1, 0},{0,-1},{0,1}}; //위, 아래, 좌, 우
    static PriorityQueue<Fish> fish;
    static boolean[][] visited;
    static boolean flag = true;
    static int eat_count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sk = new Fish(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
        move();


	}

    static void move(){
        while(flag){
            findFish();//먹을 수 있는 물고기 가져오고
            if(fish.size()>=1){ //있으면
                Fish temp = fish.poll();     
                map[temp.x][temp.y] = 0;
                sk.x = temp.x;
                sk.y = temp.y;
                sk.count += temp.count;
                eat_count++;
                //먹은 게 사이즈랑 똑같아지면
                if(eat_count==sk.size){
                    sk.size+=1;
                    eat_count = 0;

                }
            }
        }
        //이제 엄마 부르자
        
        System.out.println(sk.count);
        return;
        
    }



	static void findFish() {
		
        fish = new PriorityQueue<>();
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][N];
		queue.offer(new Point(sk.x, sk.y));
		visited[sk.x][sk.y] = true;
        second = 0;
		while(!queue.isEmpty()) {
            int size = queue.size();
            second++;
            while(--size>=0){
                Point pos = queue.poll();
                for(int i=0; i<4; i++) {
                    int dx = pos.x + deltas[i][0];
                    int dy = pos.y + deltas[i][1];
                    
                    if(dx >= 0 && dy >= 0 && dx < N && dy <N &&!visited[dx][dy] && sk.size >= map[dx][dy]) {
                        
                        if(map[dx][dy]!=0 && map[dx][dy] < sk.size ) {    //현재 먹을 수 있는 물고기 넣기
                            fish.add(new Fish(dx, dy,map[dx][dy], second));
                        }
                        
                        visited[dx][dy]= true;
                        queue.offer(new Point(dx, dy)); //현재 위치 넣기
                    }
                }
                
            }

            
		}
		
        if(fish.size()==0){ //먹을 수 있는 물고기 없으면 엄마 불러야돼
            flag = false;
        }
		
	}

}