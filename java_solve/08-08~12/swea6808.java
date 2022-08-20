import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea6808 {
    static int[] cards = new int[19];
    static int[] cards_A = new int[9];  //규영이 카드 목록
    static int[] cards_B = new int[9];  //인영이 카드 목록
    static boolean[] isSelected = new boolean[9] ;
    static int win; //규영이가 이긴 경우의 수
    static int lose;//규영이가 진 경우의 수
    static int A;   //규영이 점수
    static int B;   //인영이 점수
    static int A_idx;//재귀를 돌며 증가해가는 규영이 카드 인덱스
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cards[0] = 3;
        int loop = Integer.parseInt(br.readLine());
        String[] str;
        for(int tc=1; tc<=loop; tc++){
            str = br.readLine().split(" ");
            for(int i=0; i<9; i++){
                cards[Integer.parseInt(str[i])] = 1; //규영이 카드 저장
                cards_A[i] = Integer.parseInt(str[i]); 
            }
            int index = 0;
            for(int i=0; i<19; i++){    //인영이 카드 저장
                if(cards[i] == 0){
                    cards_B[index++] = i; 
                }
            }
            game(0,A_idx);
            
            System.out.println("#"+tc+" "+win+" "+lose);
            //사용한 static 변수들 전부 초기화
            for(int i=0; i<9; i++){
                isSelected[i] = false;
                cards_A[i] = 0;
                cards_B[i] = 0;
            }
            for(int i=1; i<19; i++){
                cards[i] = 0;
            }
            win = 0;
            lose = 0;
            A=0;
            B=0;
            A_idx = 0;
        }

    }
    //재귀로 순열을 구하는 메서드
    static void game(int cnt, int idx){
        if(cnt == 9){
            if(A>B){
                win += 1;
            }else if(B>A){
                lose += 1;
            }
            return;
        }
        for(int i=0; i<9; i++){
            if(isSelected[i]) continue;
            int temp1 = A;
            int temp2 = B;
            if(cards_A[idx]>cards_B[i]){
                A += cards_A[idx] + cards_B[i]; 
            }else if(cards_A[idx]<cards_B[i]){
                B += cards_A[idx] + cards_B[i]; 
            }
            isSelected[i] = true;
            game(cnt+1,idx+1);
            isSelected[i] = false;
            A = temp1;
            B = temp2;
        }
    }
}
