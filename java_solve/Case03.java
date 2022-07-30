package com.ssafy.ws00.problem;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Case03 {

	public static int[][] direction = {
			{},
			{-1,0},	// 북쪽
			{0,1},	// 동쪽
			{1,0},	// 남쪽
			{0,-1}	// 서쪽
	};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("input_miro.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();					// 배열의 크기
			int[][] board = new int[N+1][N+1];		// 2차원 배열 선언
			int[] start = new int[2];				// 출발점 좌표
			for(int i = 0; i < 2; i++) {
				start[i] = sc.nextInt();
			}
			int jumper = sc.nextInt();				// 점퍼의 갯수
			int[][] jumpMap = new int[jumper][2];	// 점퍼의 좌표
			// 점퍼좌표 할당
			getDate(jumper, jumpMap, sc);
			
//			for(int j = 0; j < jumper; j++ ) {
//				jumpMap[j][0] = sc.nextInt();		// 점퍼의 x좌표
//				jumpMap[j][1] = sc.nextInt();		// 점퍼의 y좌표
//			}
			
			int moveCount = sc.nextInt();			// 이동지시 개수
			int[][] moveCommand = new int[moveCount][2];	// 이동지시 배열
			// 지시 할당
			getDate(moveCount, moveCommand, sc);
			
//			for(int n = 0; n < moveCount; n++) {
//				moveCommand[n][0] = sc.nextInt(); 	// 방향
//				moveCommand[n][1] = sc.nextInt(); 	// 이동칸수
//			}
			
			// 2차원 배열 초기화 ( 점퍼좌표기입 )
			for(int k = 0; k < jumper; k++) {
				int x = jumpMap[k][0];	// x좌표
				int y = jumpMap[k][1];	// y좌표
				
				board[x][y] = 1;		// 점퍼 == 1
			}
			
			// 2차원 배열확인
//			for(int[] arr : board) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			int[] ending = getCoordicate(moveCount,moveCommand,board,start);
			System.out.printf("#%d %d %d %n",t,ending[0],ending[1]);
		}
	}
	
	/**
	 * 좌표 or 방향지시 데이터 입력해주는 함수
	 * @param Count	입력해야하는 횟수
	 * @param obj	입력 값이 들어가는 배열
	 * @param in	데이터를 받아오는 IO
	 */
	public static void getDate(int Count, int[][] obj, Scanner in) {
		
		for(int i = 0; i < Count; i++) {
			obj[i][0] = in.nextInt();
			obj[i][1] = in.nextInt();
		}
	}
	
	/**
	 * 미로를 출발하여 최종적으로 도달하는 좌표를 반환하는 함수
	 * @param moveCount 이동 횟수
	 * @param moveCommand 뱡향지시 사항
	 * @param board 점퍼가 입력된 미로
	 * @param start 시작좌표
	 * @return int[] 종료지점 좌표
	 */
	public static int[] getCoordicate(int moveCount,int[][] moveCommand, int[][] board,int[] start) {
		
		int move_x = start[0];	// x좌표 
		int move_y = start[1];	// y좌표
		
		for(int i = 0; i < moveCount; i++) {
			
			for(int j = 0; j < moveCommand[i][1]; j++) {
				move_x += direction[moveCommand[i][0]][0];
				move_y += direction[moveCommand[i][0]][1];
				
				if( move_x <= 0 || move_x >= board.length 
						|| move_y <= 0 || move_y >= board.length
						|| board[move_x][move_y] == 1) {
					return new int[] {0,0};
				}
			}
			
		}
		
		return new int[] {move_x,move_y};
	}

}
