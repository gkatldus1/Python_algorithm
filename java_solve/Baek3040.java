
import java.util.Arrays;
import java.util.Scanner;

public class Baek3040 {
    static int[] cap = new int[9];
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            cap[i] = sc.nextInt();
        }
        
        combi(0, new int[7]);

    }
    static void combi(int start, int[] arr){
        if(cnt==7){
            if(Arrays.stream(arr).sum()==100){
                for(int i=0; i<arr.length; i++){
                    System.out.println(arr[i]);
                }
                
            }
            return;
        }
        for(int i=start; i<9; i++){
            arr[cnt] = cap[i];
            cnt++;
            combi(i+1, arr);
            cnt--;
        }
    }
}
