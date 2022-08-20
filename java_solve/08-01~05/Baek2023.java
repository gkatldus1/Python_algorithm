import java.util.Scanner;

public class Baek2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int start = 1;
        int end = 1;
        for(int i=0; i<N-1; i++){
            start *= 10;
        }
        end = start*10;

        for(int i=start; i<end; i++){
            if(isPrime(i)){
                if(findSpecialPrime(i)){
                    System.out.println(i);
                }
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
    private static boolean findSpecialPrime(int num){
        int count= 0;
        for(int i=0; i<N-1; i++){
            num = (num/10);
            if(isPrime(num)){
                count++;
            }else{
                break;
            } 
        }
        if(count==3){
            return true;
        }
        return false;
    }
}
