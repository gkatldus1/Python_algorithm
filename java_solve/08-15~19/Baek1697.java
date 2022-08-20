

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1697 {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        find(N, K, visited);
        System.out.println(count);
    }
    static void find(int N, int K, boolean[] visited){  //현재 위치에서 갈 수 있는 N-1, N+1, 2*N을 노드로 만들어주고 BFS로 계속 
                                                        //범위를 넓혀가며 탐색한다.
        if(N==K) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        
        visited[N] = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            count++;
            for(int i=0; i<len; i++){
                int temp = queue.poll();
                int node1 = temp-1;
                int node2= temp+1;
                int node3 = temp*2;
                if(node1==K || node2==K || node3 ==K){
                    
                    return;
                }

                if(node1>=0&&!visited[node1]){
                    visited[node1] = true;
                    queue.add(node1);
                }
                if(node2<=100000&&!visited[node2]){
                    visited[node2] = true;
                    queue.add(node2);
                }
                if(node3<=100000&&!visited[node3]){
                    visited[node3] = true;
                    queue.add(node3);
                }
                

            }
            
        }
    }
}
