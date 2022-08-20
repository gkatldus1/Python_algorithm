package 백트랙킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1247 {
    static int N;
    static int min;
    static int[] numbers;
    static Point[] clients;
    static Point company;
    static Point home;
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int loop=1; loop<=tc; loop++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            clients = new Point[N];
            numbers = new int[N];
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i=0; i<N; i++){
                clients[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            perm(0,0);
            System.out.println("#"+loop+" "+min);
        }

    }
    private static void perm(int cnt, int flag) {
		if(cnt==N) {//고객 집 방문 순서를 다 정했을 시 계산 시작
			calc();
			return;
		}
		for(int i=0; i<N; i++) {
			//시도하는 수가 선택되었는지 판단
			if((flag & 1<<i)!=0)	continue;
			numbers[cnt] = i;
			//다음수 뽑으러가기
			perm(cnt+1, flag | 1<<i);
		}	
	}

    static void calc(){
        int temp = 0;
        int x1 = company.x; //처음에 회사위치를 x1,y1에 넣어줌
        int y1 = company.y;
        int x2 = 0;
        int y2 = 0;
        for(int i=0; i<N; i++){
            x2 = clients[numbers[i]].x;
            y2 = clients[numbers[i]].y;
            temp += Math.abs(x1-x2)+Math.abs(y1-y2);
            x1 = clients[numbers[i]].x; //방문한 고객의 집의 위치를 x1,y1에 넣어줌
            y1 = clients[numbers[i]].y;
        }
        //마지막 방문 고객부터 집까지의 거리를 구함
        x2 = home.x;
        y2 = home.y;
        temp += Math.abs(x1-x2)+Math.abs(y1-y2);
        min =Math.min(min, temp);
    }
}
