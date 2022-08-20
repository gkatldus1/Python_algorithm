import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(bf.readLine());
        for(int k=1; k<=loop; k++){
            int N = Integer.parseInt(bf.readLine());
            int[][] farm = new int[N][N];
            int sum = 0;
            for(int i=0; i<N; i++){
                String str = bf.readLine();
                for(int j=0; j<N; j++){
                    farm[i][j] = str.charAt(j) - '0';
                    //farm[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
                
            }



            int answer = 0, area = 0, mid = (N / 2);
			for (int i = 0; i < N; ++i) {
				int st = mid - area;
				int en = mid + area;
				for (int j = st; j <= en; ++j) {
					answer += farm[i][j];
				}
				
				if (i >= mid) {
					area--;
				} else {
					area++;
				}
			}
			
	
            

            // for(int i=0; i<N/2; i++){   //위에 삼각형 더하기
            //     for(int j=N/2-i; j<=(N/2+i); j++){
            //         sum += farm[i][j];
            //     }
            // }
            // for(int i=N/2; i>=0; i--){  //아래 삼각형 더하기
            //     for(int j = N/2-i; j <=N/2+i; j++){
            //         sum += farm[N-i-1][j];
            //     }
            // }
            System.out.printf("#%d %d%n",k, answer);
        }
        
    }
}