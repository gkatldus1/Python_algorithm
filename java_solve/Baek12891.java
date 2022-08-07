import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baek12891
 */
public class Baek12891 {
    static int checkArr[];  //비밀번호 규칙 배열
    static int myArr[];     //슬라이딩 윈도우의 비밀번호 요소 개수
    static int checkSecret;     // 비밀번호 규칙의 각 요소를 만족시켰는지 카운트 변수
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S]; //입력받을 문자열 배열
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++){     //비밀번호 규칙 저장
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0)    //A C T G 중 어떤 요소가 0이라면 항상 그 요소에 대한 규칙을 만족하기에 +1
                checkSecret++;
        }
        for(int i = 0; i < P; i++){     //처음 윈도우의 크기만큼 배열 업데이트
            Add(A[i]);
        }
        if(checkSecret == 4)    //checkSecret이 4이면 모든 규칙을 만족함으로 결과+1
            Result++;

        for(int i = P; i< S; i++){  //하나씩 윈도우를 오른쪽으로 옮기면서 결과를 최신화해줌
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4)
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c){    //윈도우를 옮길 때 새로 들어오는 문자를 처리해주는 함수
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c){ //윈도우를 옮길 때 빠지는 문자를 처리해주는
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;    
        }
    }
    
}