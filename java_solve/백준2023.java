import java.util.Scanner;

public class 백준2023 {
    static int N;
    static String[] prime = {"2","3","5","7"};
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
        if(s.length() == N){
            sb.append(s).append("\n");
            return;
        }
        for(int i=0; i<=9; i++){
            String temp = s+String.valueOf(i);
            if(isPrime(Integer.parseInt(temp))){
                findSpecialPrime(temp);
            }
            
        }


    }

    private static boolean isPrime(int num){
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
