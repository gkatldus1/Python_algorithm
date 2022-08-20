import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1991 {
    private static class Node{  //입력 받은 값을 저장하고 트리를 구성할 노드
        char val;
        Node left, right;
        public Node(char val){
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] tree = new Node[N];  //N크기의 노드 배열 생성
        for(int i=0; i<N; i++){     //N만큼 A~ 노드 생성
            char temp =  (char)('A'+i);
            tree[i] = new Node(temp);
        }
        char l_temp;
        char r_temp;
        for(int i=0; i<N; i++){     //입력 받은 정보대로 부모 자식 노드를 맺어줌
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0)-'A';

            if((l_temp=st.nextToken().charAt(0))=='.'){
                tree[index].left = null;
            }else{
                tree[index].left = tree[l_temp-'A'];
            }
            if((r_temp=st.nextToken().charAt(0))=='.'){
                tree[index].right = null;
            }else{
                tree[index].right = tree[r_temp-'A'];
            }
        }
        System.out.println(dfsByPreOrder(tree[0]));
        System.out.println(dfsByInOrder(tree[0]));
        System.out.println(dfsByPostOrder(tree[0]));

    }
    static String dfsByPreOrder(Node current){  //부모노드, 왼쪽 자식노드, 오른쪽 자식 노드 순으로 값을 조회
        String print = "";
        print += current.val;
        if(current.left!=null)  print+=dfsByPreOrder(current.left);
        if(current.right!=null) print+= dfsByPreOrder(current.right);
        return print;
    }
    static String dfsByInOrder(Node current){//부모노드, 오른쪽 자식 노드, 왼쪽 자식 노드 순으로 값을 조회
        String print = "";
        if(current.left!=null)  print+=dfsByInOrder(current.left);
        print += current.val;
        if(current.right!=null) print+= dfsByInOrder(current.right);
        return print;
    }
    static String dfsByPostOrder(Node current){ //왼쪽 자식노드, 오른쪽 자식노드, 부모 노드 순으로 값을 조회
        String print = "";
        if(current.left!=null)  print+=dfsByPostOrder(current.left);
        if(current.right!=null) print+= dfsByPostOrder(current.right);
        print += current.val;
        return print;
    }
}
