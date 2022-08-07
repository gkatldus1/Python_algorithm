import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1929 {

public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    for(int i=M; i<=N; i++){
        isPrime(i);
    }

}
private static void isPrime(int num){
    if(num==1){
        return;
    }
    for(int i=2; i<=Math.sqrt(num); i++){
        if((num%i) == 0){
            return;
        }
    }
    System.out.println(num);

}

}
