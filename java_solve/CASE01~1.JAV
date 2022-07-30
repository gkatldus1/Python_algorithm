package com.ssafy.ws00.problem;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Case01 {

	public static int[][] move = new int[][] {
		{-1,0},{-1,1},{0,1},{1,1},
		{1,0},{1,-1},{0,-1},{-1,-1}
	};
	
	public static String[][] park; // 사각형의 크기
	public static int x; // 행의 크기
	public static int y; // 열의 크기
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("input_board.txt");
		Scanner in = new Scanner(file);
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++) {
			// 초기화
			x = in.nextInt();
			y = in.nextInt();
			park = new String[x][y];
			
			// 참가자의 인원
			int person = in.nextInt();
			// 총상금 초기화
			int money = 0;
			
			// 사각형에 값 할당
			for(int i = 0; i < park.length; i++) {
				for(int j = 0; j < park[i].length; j++) {
					park[i][j] = in.next();
				}
			}
			
			for(int j = 0; j < person; j++) {
				money += game(in);
			}
		
			/* 2차원 배열 확인용
			for(String[] board : park) {
				System.out.println(Arrays.toString(board));
			}
			*/
			System.out.println("#" + t + " " + money);
		}	
	}
	

	public static int game(Scanner in) {
		// 시작위치
		int[] pos = new int[2];
		// 이동방향 저장
		int moving_x;
		int moving_y;
		// 참가자 시작위치
		for(int i = 0; i < 2; i++) {
			pos[i] = in.nextInt() - 1;
		}
		// 참가자 이동횟수
		int jump = in.nextInt();
		// 중도 실패 검증
		boolean isCheck = true;
		
		for(int i = 1; i <= jump; i++) { //;;;;;;;;;;문제;;;;;;;;;;;;;;
			// 범위 검증
			if( pos[0] < 0 || pos[0] >= x || pos[1] < 0 || pos[1] >= y ) {
				isCheck = false;
				break;
			}
			
			// 방향과 이동 칸수 
			// moving_x 방향
			// moving_y 이동 칸수
			moving_x = park[pos[0]][pos[1]].charAt(0) - '0';
			moving_y = park[pos[0]][pos[1]].charAt(1) - '0';
			
			for(int j = 1; j <= moving_y; j++) {
				pos[0] += move[moving_x - 1][0];
				pos[1] += move[moving_x - 1][1];
			}
			
			if( pos[0] < 0 || pos[0] >= x || pos[1] < 0 || pos[1] >= y ) {
				isCheck = false;
			}
		}
		// 정상적으로 게임을 완료 ( 초기 게임 비용 1000원 빼고 상금이 지급됨 )
		if( isCheck ) {
			return Integer.parseInt(park[pos[0]][pos[1]]) * 100 - 1000;
		}
		
		return -1000;
	}
	
}
