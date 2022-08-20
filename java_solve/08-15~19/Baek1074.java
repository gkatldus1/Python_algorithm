package 분할정복;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek1074 {
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long r  = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        findZ(N, r, c);
        System.out.println(ans);

    }
    static void findZ(int N, long r, long c){
        if(N==0) return;

        long size = (int)Math.pow(2, N);
        long half = size/2;

        if(r/half==0 && c/half==0){ //1사분면
            findZ(N-1, r%half, c%half);
        }
        else if(r/half==0&&c/half==1){//2사분면
            ans += half*half;
            findZ(N-1, r%half, c%half);
        }
        else if(r/half==1&&c/half==0){//3사분면
            ans += half*half*2;
            findZ(N-1, r%half, c%half);
        }
        else /*if(r/half==1&&c/half==1)*/{//4사분면
            ans += half*half*3;
            findZ(N-1, r%half, c%half);
        }
        
    }
}
