import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * valid: 두번째 산술연산자가 +-*,/이면서 길이 4
 * 두번째가 산술연산자가 아니면 길이2
 * 
 *  invalid
 * 두번째가 산술연사자이면서 길이가 4가 아닌것
 * 두번째가 산술연산자가 아니면서 길이가 2가 아닌것
 * 
 */


public class swea1233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc =1; tc<=10; tc++){
            int N = Integer.parseInt(br.readLine());
            int ans = 1;
            String[] str;
            for(int i=1; i<=N; i++){
                str = br.readLine().split(" ");
                if(str[1].equals("+")||str[1].equals("-")||str[1].equals("*")||str[1].equals("/")){
                    if(str.length!=4){
                        ans = 0;
                    }
                }else if(str.length!=2){
                    ans = 0; 
                }
                
            }
            System.out.println("#"+tc+" "+ans);

        }

    }
}
