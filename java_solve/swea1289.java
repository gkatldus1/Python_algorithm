import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i < T; i++){
            String input = br.readLine();
            int len = input.length();
            int index = 0;  //저장할 원래 값을 비교할 인덱스
            int count = 0;  // 바꾼 횟수 카운트
            char[] initial = input.toCharArray();   //바뀌기 전 메모리 값
            char[] memory = new char[len];  //0000...으로 초기화된 메모리
            for(int j = 0; j< memory.length; j++){
                memory[j] = '0';    //메모리를 원래 메모리값의 길이 만큼 0으로 초기화
            }
            while(true){
                if(index == initial.length) //값을 전부 비교했으면 break
                    break;

                if(initial[index]!=memory[index]){  //값이 다르면 전부 initial의 값으로 바꿔주고 카운트를 올려줌
                    for(int k = index; k < memory.length; k++){
                        memory[k] = initial[index];
                    }
                    count++;
                    
                }
                index++;
            }
            System.out.println("#"+(i+1)+" "+count);
        }
    }
}
