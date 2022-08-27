
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 매 턴마다 현재 아기 상어의 크기에서 먹을 수 있는 모든 물고기를 우선 순위 큐에 넣어준다. 그러면 설정해둔 제약 조건에 따라
 * 저절로 정렬이 일어나게 된다. 문제에서 요구하는 조건의 물고기가 우선 순위 큐의 가장 앞에 오게 되고
 * poll하게 되면 이번 차례에 먹을 수 있는 물고기가 나오도록 로직을 짰다.
 * 만약 우선순위 큐에 아무것도 들어오지 않았다면 먹을 수 있는 물고기가 
 * 없다는 뜻이므로 프로그램을 종료한다.
 */


public class Baek16236 {
	static class Fish implements Comparable<Fish>{
		int x;  //물고기가 있는 행
		int y;  //물고기가 있는 열
		int count;  //물고기가 있는 곳까지 가는데 걸리는 시간
		int size;   //물고기 크기
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
            if(this.count == o.count){ //거리가 같고
                if(o.x==this.x)//높이도 같으면 왼쪽에 있는 순으로 정렬
                    return this.y - o.y;
                return this.x - o.x;//거리만 같고 높이는 다르다면 높이 순으로 정렬

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
            findFish();//먹을 수 있는 물고기 리스트 가져오는 메서드
            if(fish.size()>=1){ //먹을 수 있는 물고기가 있다면 
                Fish temp = fish.poll();     //먹을 수 있는 가장 가까운 물고기를 꺼내 먹고
                map[temp.x][temp.y] = 0;    //물고기가 있던 자리는 0으로 만든다.
                sk.x = temp.x;              //아기 상어를 물고기가 있던 위치로 옮긴다.
                sk.y = temp.y;
                sk.count += temp.count;     //sk.count는 상어가 움직인 시간의 총합, temp.count 해당 물고기를 먹으러 가는데까지 걸리는 시간
                eat_count++;
                //먹은 물고기 수가 상어 사이즈랑 똑같아지면
                if(eat_count==sk.size){
                    sk.size+=1;
                    eat_count = 0;

                }
            }
        }
        //flag가 false면 먹을 수 있는 물고기가 없다는 뜻! 이제 엄마 부르자
        
        System.out.println(sk.count);
        return;
        
    }



	static void findFish() {
		
        fish = new PriorityQueue<>();   //먹을 수 있는 물고기를 담아서 거리 순으로, 거리가 같다면 높이 순으로 높이도 같다면 맨 왼쪽에 있는
                                         //물고기가 가장 먼너 나오도록 힙을 사용해주었다.

		Queue<Point> queue = new LinkedList<>();    //bfs탐색을 위해서 queue를 선언
		visited = new boolean[N][N];            //탐색할때 무한루프에 빠지지 않도록 하기 위해 지나간 곳을 표기하는 배열
		queue.offer(new Point(sk.x, sk.y)); //현재 아기상어의 위치를 탐색을 위해 큐에 넣어준다
		visited[sk.x][sk.y] = true;
        second = 0;     //현재 아기 상어 위치에서 먹을 수 있는 물고기에 도달하기까지 시간을 재기 위한 변수
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
                        queue.offer(new Point(dx, dy)); //다음 먹을 수 있는 물고기 탐색을 위해 이동한 현재 위치를 큐에 넣어줌
                    }
                }
                
            }

            
		}
		//탐색이 완료되고 fish에 아무것도 없다면
        if(fish.size()==0){ //먹을 수 있는 물고기가 없다는 뜻. 엄마 불러야되니까 flag를 false로 만들어준다.
            flag = false;
        }
		
	}

}