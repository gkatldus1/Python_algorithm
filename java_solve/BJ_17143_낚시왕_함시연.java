import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕_함시연 {
	static int R, C, M;
	static int[][] deltas = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};	//상, 하, 우, 좌  : 상 하는 3-x, 우 좌는 7-x
	static int success = 0;
	
	static class Fisher{
		int c;
	}
	
	static class Shark implements Comparable<Shark>{
		int r, c, size, speed;
		int dir; 
		public Shark(int r, int c, int speed, int dir,int size) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.size = size;
			this.speed = speed;
		}
		@Override
		public int compareTo(Shark o) {
			return this.r-o.r;
		}
		
		
	}
		static List<Shark> s_list = new ArrayList<>();
		
		static int map[][];
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[R+1][C+2];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				s_list.add(new Shark(r,c,s,d,z));
			}
			
			if(M==0) {
				System.out.println(0);
				System.exit(0);
			}
			
			Fisher fisher = new Fisher();
			Collections.sort(s_list);
			for(int i=0; i<C; i++) {
				fish(fisher);
			}
			System.out.println(success);
			
		}
		static void fish(Fisher fisher) {
			fisher.c += 1;	//낚시꾼 이동
			Iterator<Shark> itr = s_list.iterator();
			while(itr.hasNext()) {
				Shark shark = itr.next();
				if(shark.c == fisher.c) {
					success += shark.size;
					s_list.remove(shark);
					break;
				}
				
			}
			

			//상어이동
			swim();
			//우리 상어 밥 먹을 시간
			happyMeal();
			Collections.sort(s_list);
		}
		//우리 상어 움직이자
		
		static void swim() {
			for(int i=0; i<s_list.size(); i++) {
				Shark shark = s_list.get(i);
				int r,c,nr,nc;
				nr=nc=0;
				r = shark.r;
				c = shark.c;
				int dir = shark.dir;
				for(int k=0; k<shark.speed; k++) {
					
					nr = r+deltas[dir][0];
					nc = c+deltas[dir][1];
					
					if(nr>0 && nr<=R && nc>0 && nc<=C) {//방향 안바꿈
						r = nr;
						c = nc;
						
					}
					else {//방향바꿈
						if(dir==1 || dir==2 ) {
							dir = 3 - dir;
							nr = r + deltas[dir][0];
							nc = c + deltas[dir][1];
							r = nr;
							c = nc;

						}
						else {
							dir = 7-dir;
							nr = r + deltas[dir][0];
							nc = c + deltas[dir][1];
							r = nr;
							c = nc;

						}
					}
					
				}
				shark.r = r;
				shark.c = c;
				shark.dir = dir;
			}
		}
		
		static void happyMeal() {
			Shark[][] temp = new Shark[R+1][C+1];
			
			for(int i=s_list.size()-1; i>=0; i--) {
				Shark shark = s_list.get(i);
				if(temp[shark.r][shark.c]!=null) {//지금 상어가 몸 좀 누우려는 곳에 다른 상어가 있다?
					if(temp[shark.r][shark.c].size>shark.size) {
						s_list.remove(shark);
					}else {
						s_list.remove(temp[shark.r][shark.c]);
						temp[shark.r][shark.c] = shark;
					}
				}else {
					temp[shark.r][shark.c] = shark;
				}
			}
		}
		
		
		
		
		static void happyMeal1() {
			int[][] temp = new int[R+1][C+1];
			for(int arr[]: temp) {	//0으로 초기화
				Arrays.fill(arr, 0);
			}
			
			for(int i=s_list.size()-1; i>=0; i--) {
				Shark shark = s_list.get(i);
				if(temp[shark.r][shark.c]!=0) {//지금 상어가 몸 좀 누우려는 곳에 다른 상어가 있다?
					Shark shark2 = s_list.get(temp[shark.r][shark.c]); //안에 있는 놈 데려와
					int loser = shark.size > shark2.size? temp[shark.r][shark.c]: i;// 둘이 맞짱
					s_list.remove(loser);
					if(loser!= i) {//i랑 loser가 다를 경우 맵 갱신
						temp[shark.r][shark.c] = i;
					}
				}else {
					temp[shark.r][shark.c] = i;
				}
			}
		}
		
		
}
