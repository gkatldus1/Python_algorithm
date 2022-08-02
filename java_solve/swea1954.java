import java.util.Scanner;

public class swea1954 {
    static int move[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0; i<tc; i++){
            int N = sc.nextInt();
            int num = 1;
            int x = 0;
            int y = 0;
            int dir = 0;
            int[][] map = new int[N][N];
            while(num<=N*N){    //다음에 이동할 인덱스가 범위를 벗어나거나 숫자가 차있으면 방향을 바꿔서 숫자를 넣는다.
                map[x][y] = num;
                num++;
                if(x + move[dir][0] <0 ||x + move[dir][0] >=N || y + move[dir][1] <0 ||y + move[dir][1] >=N || map[x + move[dir][0]][y + move[dir][1]] != 0){
                    dir = (dir+1) % 4;
                }
                x = x + move[dir][0];
                y = y + move[dir][1];

                
            }

            System.out.println("#"+(i+1));
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    System.out.print(map[j][k]+" ");
                }
                System.out.println();
            }
        }
        
    }
}
