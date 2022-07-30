import java.util.Scanner;

public class baek1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //시험 과목 개수를 입력받을 버퍼 생성
        int N = sc.nextInt();   //시험과목 개수 입력을 받음
        int[] A = new int[N];   // 시험 과목 수 크기의 배열 생성

        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();    //시험 과목 수만큼 점수 입력 받음
        }

        long sum = 0;   //평균 계산을 위해 합을 저장할 변수
        long max = 0;   // 최고점을 저장할 변수

        for (int i=0; i<N; i++){
            if (A[i] > max) max = A[i]; //최대값을 구하는 로직
            sum = sum + A[i];   //성적 전체합을 구함
        }

        System.out.println(sum*100.0 / max / N);    //문제에서 요구하는 공식을 사용하여 정답 출력
    }
}
