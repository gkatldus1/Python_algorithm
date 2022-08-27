import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3289 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for(int i=1; i<=N; i++){
                parent[i] = i;
            }
            char ins;
            int a, b;
            sb.append("#"+tc+" ");
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                ins = st.nextToken().charAt(0);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if(ins=='0'){
                    union(a, b);
                }else{
                    if(isSameParent(a, b)){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }

            }
            
            System.out.println(sb.toString());


        }

    }
    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y)    return true;
        else    return false;
    }


    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y] = x;//연결
        }        
    }
    static int find(int x){
        if(parent[x]==x)    return x;
        return parent[x] = find(parent[x]);
    }
}
