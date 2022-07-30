package com.ssafy.ws03.step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class Solution {
	
	// 팔방 방향 배열
	static int[][] direction = {
			{1,0},{-1,0},{0,1},{0,-1},
			{1,1},{1,-1},{-1,1},{-1,-1}
	};

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File("input.txt");
		
		Scanner in = new Scanner(file);
		
		int tc = in.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			
			// 산업단지의 크기
			int N = in.nextInt();
			// 빌딩의 쵀대 높이
			int max = Integer.MIN_VALUE;
			// 주의에 공원단지가 있는지 검증하는 변수
			boolean isHeight = false;
			// 높이
			int height = 0;
			// 산업단지 조성 | 2차원 배열 선언 및 초기화
			char[][] city = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					city[i][j] = in.next().charAt(0);
				}
			}
			
			// 빌딩의 높이 구하기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					isHeight = false;
					height = 0;
					
					// 해당 구획과 인접한 팔방에 공원단지가 있는지 점검
					for(int w = 0; w < 8; w++) {
						
						int x = i + direction[w][0];
						int y = j + direction[w][1];
						
						// 2차 배열의 index를 범위에서 벗어나지 않을 경우
						if( x >= 0 & x < N & y >= 0 & y < N) {
							if(city[x][y] == 'G') {
								isHeight = true;
								break;
							}
						}
					}
					// 공원단지가 없다면 최대높이 구하기
					if( !isHeight ) {
						for(int k = 0; k < N; k++) {
							if( city[i][k] == 'B' ) {
								height++;
							}
							if( city[k][j] == 'B' ) {
								height++;
							}
						}
					} else {
						height = 2;
					}
					// 제일 높은 건물 층수
					max = Math.max(max, height - 1);
				}
			}
			
			// 결과 출력
			System.out.println("#" + t + " " + max);
		}
	}

}
