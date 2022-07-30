import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //값을 입력받기 위한 버퍼
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); 
        //숫자개수와 반복 횟수를 입력받음
        int number = Integer.parseInt(stringTokenizer.nextToken());//입력 받을 숫자 개수를 int형으로 형 변환
        int loop = Integer.parseInt(stringTokenizer.nextToken());//입력 받은 반복 횟수를 int형으로 형 변환
        long[]S = new long[number + 1]; //입력 받을 숫자 개수보다 1많은 배열을 생성 
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());  //숫자를 입력받고 파싱을 위한 객체 생성

        for(int i=1; i <= number; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());  //입력받은 숫자의 처음부터 값을 누적하여 배열에 저장
        }
        for(int k = 0; k < loop; k++){  //구하고자 하는 범위의 첫번째 인덱스보다 앞의 값을 뺼셈하여 원하는 범위 값을 구함
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }

    }

