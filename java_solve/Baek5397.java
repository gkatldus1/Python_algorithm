import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek5397 {
    public static void main(String[] args) throws Exception {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for(int loop=0; loop<tc; loop++){
            String str = bf.readLine();
            char[] chars = new char[str.length()];
            for(int i=0; i<str.length(); i++){
                chars[i] = str.charAt(i);
            }
            for(int i=0; i<chars.length; i++){
                if(chars[i] == '<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                        continue;
                    }
                    continue;
                }else if(chars[i] == '>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                        continue;
                    }
                    continue;
                }else if(chars[i] == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                        continue;
                    }
                    continue;
                }
                left.push(chars[i]);
            }
            // StringBuffer sb = new StringBuffer();
            // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // if(!left.isEmpty()){
            //     for(char ch: left){
            //         bw.write(ch);
            //     }
            // }
            // while(!left.isEmpty()){
            //     left.pop();
            // }
            
            // if(!right.isEmpty()){
            //     bw.write(" ");
            //     for(char ch: right){
            //         bw.write(ch);
            //     }
            // }
            // while(!right.isEmpty()){
            //     right.pop();
            // }
            // bw.write("\n");
            // bw.flush();
            
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
        
    }
}
