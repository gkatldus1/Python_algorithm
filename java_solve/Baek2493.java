import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        int[] ans = new int[N];
        Stack<Integer> myStack = new Stack<>(); //스택 생성
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken()); //데이터를 배열에 저장
        }

        myStack.push(N-1);  //가장 오른쪽의 수를 스택에 넣어준다.
        for(int i= N-2; i >=0; i--){    //for를 n번만 반복하기 위해 스택에 데이터의 인덱스를 넣고 스택안의 인덱스 숫자가 현재 인덱스i의 숫자 보다 작다면 계속해서 정답 배열에 값을 넣어준다.
            while(!myStack.isEmpty()&&nums[myStack.peek()]<nums[i]){
                ans[myStack.pop()] = i+1;
            }
            myStack.push(i);    //비교가 완료된 후 현재 i의 값을 넣어준다.
        } 
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ans.length; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
        }
}

