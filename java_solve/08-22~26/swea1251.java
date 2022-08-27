import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.awt.Point;

public class swea1251 {
    static boolean[] selected;
    static int N;
    static Point[] pos;
    static Point[] selec_pos;
    static double min;
    static double e;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            pos = new Point[N];
            selec_pos = new Point[N];
            min = Double.MAX_VALUE;
            selected = new boolean[N];

            for(int i=0; i<N; i++){
                pos[i] = new Point();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                pos[i].x = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                pos[i].y = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine());
            // for(int i=0; i<N; i++){
            //     System.out.println(pos[i]);
            // }
            perm(0, 0);
            System.out.println("#"+tc+" "+Math.round(min));
        }
    }
    static void perm(int cnt, int flag) {
		if(cnt ==N) {
			calc();
			return;
		}
		for(int i=0; i<N; i++) {
			//시도하는 수가 선택되었는지 판단
			if((flag & 1<<i)!=0)	continue;
			selec_pos[cnt] = pos[i];
			//다음수 뽑으러가기
			perm(cnt+1, flag | 1<<i);
		}
	}




    // static void permutation(int cnt, int r){
    //     if(cnt == r){
    //         calc();
    //         return;
    //     }

    //     for(int i=0; i<N; i++){
    //         if(selected[i]) continue;
    //         selected[i] = true;
    //         selec_pos[cnt] = pos[i];
    //         permutation(cnt+1, r);
    //         selected[i] = false;
    //     }

    // }
    static void calc(){
        long temp = 0;
        for(int i=0; i<N-1; i++){
            long x1 = selec_pos[i].x;
            long x2 = selec_pos[i+1].x;
            temp += Math.abs(x1-x2)*Math.abs(x1-x2);
            
            long y1 = selec_pos[i].y;
            long y2 = selec_pos[i+1].y;
            temp += Math.abs(y1-y2)*Math.abs(y1-y2);
        }
        min = Math.min((double)temp*e, min);
    }
}
