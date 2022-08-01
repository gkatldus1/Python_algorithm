import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Baek1244 {
    static char[] button;   //스위치 저장 배열
    static String[] map;    //학생 데이터 저장 배열

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        int len = Integer.parseInt(bf.readLine());
        button = new char[len];
        
        int stu_len;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<len; i++){
            button[i] = st.nextToken().charAt(0);
            
        }
        stu_len = Integer.parseInt(bf.readLine());
        map = new String[stu_len];
        for(int i=0; i<stu_len; i++){
            map[i] = bf.readLine();
            
        }
        for(int i=0; i<map.length; i++){
            if(map[i].charAt(0) == '1'){
                boy(i); //남학생일때 메서드
            } else{
                 girl(i);   //여학생일때 메서드
             }
        }
        for(int i=0; i<button.length; i++){ //출력구문
            System.out.print(button[i] + " ");
            if((i+1)%20 == 0)
                System.out.println();
        }
    }
    

    static void boy(int i){
        String[] strs = map[i].split(" ");

        int val = Integer.parseInt(strs[1]);
        for(int j=0; j<button.length; j++){
            if(((j+1)%val) == 0){   //스위치들의 수가 남학생 숫자의 배수인지 비교
                if(button[j] == '1'){
                    button[j] = '0';
                } else{
                    button[j] = '1';
                }
            }
        }
    }

    static void girl(int i){
        String[] strs = map[i].split(" ");
        int val = Integer.parseInt(strs[1]) - 1;
        int start = 0;
        int end = 0;
        int left = val;
        int right = val;
        while(true){
            left -= 1;  //좌우 인덱스 이동
            right += 1;
            
            if(left<0 || right>= button.length) //인덱스가 배열 범위 이내인지 확인
                break;

            if(button[left] == button[right]){  //좌우 대칭인지 비교
                start = left;
                end = right;
            } else{
                break;
            }
        }
        if(start==0&&end==0){   //좌우가 하나도 대칭이 아닐때
            if(button[val] == '1')   
                button[val] = '0';
            else
                button[val] = '1';
            return;    
        }
        for(int j=start; j<=end; j++){  //대칭인 범위내에서 값 변화
            if(button[j] == '1')   
                button[j] = '0';
            else
                button[j] = '1';
        }

    }


}
