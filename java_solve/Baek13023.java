import java.util.*;
 
public class Baek13023 {    
    
    static int n;
    static ArrayList<Integer>[] list;   //그래프 정보를 담을 인접 리스트
    static boolean[] visited;           //방문 기록을 확인할 배열
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        list = new ArrayList[n];    //노듸 수 크기만큼의 ArrayList 배열 생성 
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();    //각각의 노드에 ArrayList 생성하여 할당
        }
        
        for(int i = 0; i < m; i++) {    //입력 받은 그래프 정보를 저장해줌
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i = 0; i < n; i++) {    //모든 노드를 돌며 문제를 만족하는 관계가 있는지 확인
            visited = new boolean[n];   // 방문배열 기록을 초기화해줌
            dfs(i, 0);
        }
        System.out.println(0);
    }
    
    public static void dfs(int x, int len) {    //재귀를 돌며 dfs 탐색
        if(len == 4) {  // 관계를 만족할시 출력 후 프로그램 종료
            System.out.println(1);
            System.exit(0);
        }
        
        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {   //x노드에 연결된 노드들을 dfs 탐색
            int temp = list[x].get(i);
            if(visited[temp] == false) {
                
                dfs(temp, len + 1);
                visited[temp] = false;  //탐색 완료한 노드를 false로 바꾼 후 다음 노드 탐색
            }
        }
    }
}
