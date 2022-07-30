import java.io.File;
import java.util.Scanner;

public class Test5 {

	private static int[][] direction = {
			{1,0},{1,1},{0,1},{-1,1},
			{-1,0},{-1,-1},{0,-1},{1,-1}
	};
	
	private static int[][] board;
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("Test5.txt");
		Scanner sc = new Scanner(file);
		
		int n = 20;
		board = new int[n][n];
		
		for(int i = 1; i < n; i++ ) {
			for(int j = 1; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int[] end = getCordinate(n);
		System.out.printf("%d %d",end[0],end[1]);
	}
	
	private static int[] getCordinate(int n) {
		
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				
				int next_x = i;
				int next_y = j;
				int cnt = 0;
				int index = 0;
				
				if( board[i][j] == 1 | board[i][j] == 2) {
					
					while( index < 8 ) {
						next_x += direction[index][0];
						next_y += direction[index][1];				
						
						if( next_x <= 0 || next_x >= n || next_y <= 0 || next_y >= n ) {
							next_x = i;
							next_y = j;
							cnt = 0;
							index++;
							continue;
						}
						
						if ( board[next_x][next_y] == board[i][j] ) {
							cnt++;
						} else {
							next_x = i;
							next_y = j;
							cnt = 0;
							index++;
							continue;
						}
						
						if( cnt == 5) {
							int temp_x = next_x + direction[index][0];
							int temp_y = next_y + direction[index][1];
							if ( board[temp_x][temp_y] == board[i][j] ) {
								next_x = i;
								next_y = j;
								cnt = 0;
								index++;
								continue;
							} else {
								System.out.println(board[i][j]);
								int a = Math.min(i, next_x);
								int b = Math.min(j, next_y);
								return new int[] {a,b};
							}
						}
						
					}
				}
				
			}
		}
		
		return null;
	}

}
