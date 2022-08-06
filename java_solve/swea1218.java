import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class swea1218 {
    static HashMap <Character, Character> hm = new HashMap<>();
    public static void main(String[] args) throws Exception{
        hm.put('}','{');
        hm.put(')','(');
        hm.put(']','[');
        hm.put('>','<');
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int loop=1; loop<=10; loop++){
            int ans = 1;
            int length = Integer.parseInt(bf.readLine());
            char[] braces = new char[length];
            String str = bf.readLine();
            //char 배열에 괄호들을 입력받음
            for(int i=0; i<length; i++){
                braces[i] = str.charAt(i);
            }
            // System.out.println(Arrays.toString(braces));
            // 스택에 열린 괄호라면 넣어주고 닫힌 괄호라면 스택에서 팝하여 짝이 맞는지 확인한다.
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<braces.length; i++){
                if(braces[i] == '(' || braces[i] =='{' || braces[i] == '[' || braces[i] == '<' ){
                    stack.push(braces[i]);
                }
                else{
                    char ch = stack.pop();
                    if(hm.get(braces[i]) != ch){
                        ans = 0;
                        break;
                    }
                }
            }
            if(ans==0||!stack.isEmpty()){
                System.out.print("#"+loop+" "+ans);
                System.out.println();
                continue;
            }

            System.out.print("#"+loop+" "+ans);
            System.out.println();
        }


    }
}
