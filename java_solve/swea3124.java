import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea3124 {
    static class line implements Comparable<line>{
        int x;
        int y;
        int weight;
        public line(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(line o) {
            if(this.weight > o.weight)
                return 1;
            else if(this.weight < o.weight)
                return -1;
            return 0;
        }
    }
    static int parent[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int tc=1; tc<=T; tc++){
            ArrayList<line> lines = new ArrayList<>();
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            parent = new int[V+1];
            for(int i=1; i<=V; i++){    //서로소 집합을 만들어줌
                parent[i] = i;
            }
            for(int i=0; i<E; i++){ //간선에 대한 정보를 받아줌
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                lines.add(new line(a,b,c));
            }

            long ans= 0;
            Collections.sort(lines);    //크루스컬 알고리즘을 위해 정렬
            for(int i=0; i<lines.size(); i++){  //가중치가 작은값부터 최소 신장 트리를 구성해줌.
                if(!isSameParent(lines.get(i).x, lines.get(i).y)){
                    union(lines.get(i).x, lines.get(i).y);
                    ans += lines.get(i).weight;
                }
            }
            System.out.println("#"+tc+" "+ans);
        
        }
    
    }
    static int findParent(int x){
        if(parent[x]== x)   return x;
        else    
            return parent[x] = findParent(parent[x]);
    }


    static boolean isSameParent(int x, int y){
        x = findParent(x);
        y = findParent(y);
        if(x!=y)    return false;

        return true;
    }


    static void union(int x, int y){
        //부모 찾기
        x = findParent(x);
        y = findParent(y);

        if(x != y){
            parent[y] = x; //연결
        }
    }

}
