import java.util.Scanner;

public class Baek2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;          //N이 있으므로 무조건 시작 카운트는 1
        int start_index = 1;    //투포인터 시작 인덱스
        int end_index = 1;      // 투포인터 끝 인덱스
        int sum = 1;            //N이 되는지 확인하기 위한 총합 변수
        while(end_index != N){  // 엔드 인덱스가 N이 아닐때까지 반복
            if(sum == N){       //총합이 N이 되면 카운트를 올려주고 엔드 인덱스를 증가시켜 다음 범위의 숫자를 탐색해나간다.
                count++;
                end_index++;
                sum = sum + end_index;
            } else if(sum > N){     //총합이 N을 넘으면 시작 인덱스를 증가시켜 앞의 숫자를 빼주게 된다.
                sum = sum - start_index;
                start_index++;
            } else{             // 계속 숫자 범위를 넓혀 N이 되는지 탐색한다.
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
