

import java.io.File;
import java.util.Scanner;

public class Case02 {

	public static int[][] way = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("input_robot.txt");
		Scanner in = new Scanner(file);
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++) {
			// 맵의 크기
			int N = in.nextInt();
			// 맵 초기화
			char[][] board = new char[N][N];
			// 로봇들의 이동거리 합
			int distanceSum = 0;
			
			
			// 맵에 벽 및 로봇 할당
			// S -> 이동가능, A,B,C -> 로봇, W -> 벽
			for(int i = 0; i < N; i++ ) {
				for(int j = 0; j < N; j++ ) {
					board[i][j] = in.next().charAt(0);
				}
			}
			// 각 로봇의 좌표에서 이동거리 구하기
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					switch ( board[x][y] ) {
						case 'A':
							distanceSum += move(x,y,board,1);
							break;
						case 'B':
							distanceSum += move(x,y,board,1);
							distanceSum += move(x,y,board,3);
							break;
						case 'C':
							for(int i = 0; i < 4; i++) {
								distanceSum += move(x,y,board,i);
							}
							break;
					}
				}
			}
			System.out.println("#" + t + " " + distanceSum);
		}
	}
	
	/**
	 * 선택한 방향으로 이동가능 거리 계산하는 함수
	 * @param verticle x좌표
	 * @param horizen y좌표
	 * @param board 로봇보드판
	 * @param select 방향선택
	 * @return int 이동가능 거리 반환
	 */
	public static int move(int verticle, int horizen, char[][] board, int select) {
		
		int next_x = way[select][0] + verticle;
		int next_y = way[select][1] + horizen;
		int move = 0;
		
		if( next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board.length) {
			return move;
		}
		
		while( board[next_x][next_y] == 'S') {
			next_x += way[select][0];
			next_y += way[select][1];
			move++;
			
			if( next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board.length) {
				break;
			}
		}
		
		return move;
	}

}
