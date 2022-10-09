import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek2239 {

	static int[][] map;
	static boolean end;
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			map = new int[9][9];
			for (int i = 0; i < 9; ++i) {
				String input = br.readLine();
				for (int j = 0; j < 9; ++j) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			dfs(0);
			
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j) {
					bw.write(map[i][j]+"");
				}bw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dfs(int depth) {
		if (depth == 81) { //81개를 다 채웠다면 스도쿠 완성
			end = true;
			return;
		}
		//9*9배열의 모든 원소를 순회하면서 숫자를 채워넣어감
		int y = depth / 9;
		int x = depth % 9;
		//0이 아니라면 다음 단계로
		if (map[y][x] != 0) {
			dfs(depth + 1);
		} else {//0이라면 넣을 수 있는 수를 넣어주고 다음 단계로
			for (int i = 1; i <= 9; ++i) {
				if (!isVaild(y, x, i)) continue;
				map[y][x] = i;
				dfs(depth + 1);
				if (end) return;
				map[y][x] = 0;
			}
		}
	}
	
	public static boolean isVaild(int y, int x, int n) {
		for (int i = 0; i < 9; ++i) {
			if (map[y][i] == n || map[i][x] == n) return false;
		}
		
		int yy = y / 3 * 3;
		int xx = x / 3 * 3;
		for (int i = yy; i < yy + 3; ++i) {
			for (int j = xx; j < xx + 3; ++j) {
				if (map[i][j] == n) return false;
			}
		}
		return true;
	}
}
