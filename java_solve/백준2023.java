import java.util.Scanner;

public class 백준2023 {
    static int N;
    static String[] prime = {"2","3","5","7"};  //한자리 소수에서부터 시작
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<4; i++){
            findSpecialPrime(prime[i]);
        }
        System.out.println(sb.toString());
    }


    private static void findSpecialPrime(String s){
        if(s.length() == N){        //길이가 N이 된다면 출력
            sb.append(s).append("\n");
            return;
        }
        for(int i=0; i<=9; i++){
            if((i%2)==0)        //끝이 2로 끝난다면 항상 약수가 있으므로 제외
                continue;
            String temp = s+String.valueOf(i);      //숫자를 붙여가며 소수인지 판별
            if(isPrime(Integer.parseInt(temp))){
                findSpecialPrime(temp);
            }
            
        }


    }

    private static boolean isPrime(int num){    //소수인지 판별하는 메서드
        if(num==1){
            return false;
        }
        int sqrt = (int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if((num%i) == 0){
                return false;
            }
        }
        return true;
    
    }
}
