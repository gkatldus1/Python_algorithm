import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea7465 {
    static ArrayList<Integer>[] list;   //그래프 정보를 담을 인접 리스트
    static boolean[] visited;           //방문 기록을 확인할 배열
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int loop=1; loop<=T; loop++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N];
            visited = new boolean[N];
            for(int i=0; i<N; i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                list[from].add(to);
                list[to].add(from);
            }
            for(int i=0; i<N; i++){
                if(!visited[i]){    //방문하지 않은 노드라면 다른 무리이기 때문에 카운트해주고 탐색을 시작.
                    cnt++;
                    dfs(i);
                }
            }
            System.out.println("#"+loop+" "+cnt);
            cnt = 0;
        }
    }
    static void dfs(int start){
        visited[start] = true;  //방문하지 않은 노드라면 true로 만들어준다.
        for(int i = 0; i < list[start].size(); i++) {   //start노드에 연결된 노드들을 dfs 탐색
            int temp = list[start].get(i);
            if(visited[temp] == false) {    
                dfs(temp);
            }
        }
    }
}
