import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>() ;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int idx = -1;
        for(int i=1; i<=N; i++){
            idx = i-nums[i-1]-1;
            list.add(idx, i);
            
        }
        // for(Integer item: list){
        //     System.out.print(item+" ");
        // }
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
