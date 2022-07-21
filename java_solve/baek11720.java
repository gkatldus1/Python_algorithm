import java.util.Scanner;

public class baek11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //숫자의 개수를 입력 받을 버퍼 생성
        int N = sc.nextInt();       //입력 받은 수 N에 저장
        String sNum = sc.next();    // 문자열로 공백없이 받은 숫자들 저장
        char[] cNum = sNum.toCharArray();   //문자열을 문자 배열로 변환
        int sum = 0;
        for (int i=0; i< cNum.length; i++){
            sum += cNum[i] - '0';   //아스키 코드값을 빼줘 int 형으로 변환한 뒤 총합을 구해줌
        }
        System.out.print(sum);
    }
}