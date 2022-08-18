import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        while(N>=0){
            if(N%5==0){ //5의 배수라면 이제껏 구한 카운트에 나눈 몫을 더하여 답을 구해줌. 
                count = N/5+count;
                break;
            }
            N-=3;   //5의 배수가 아니라면 3으로 빼준뒤 5의 배수인지 다시 판별
            count+=1;
        }

        if(N<0){    //3과 5로 만들 수 없는 수이므로 -1 출력
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }
}
