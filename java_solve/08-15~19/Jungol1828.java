import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol1828 {
    static class Material implements Comparable<Material>{//온도를 저장해줄 객체
        int low;
        int high;
        public Material(int low, int high){
            this.low = low;
            this.high = high;
        }
        @Override
        public int compareTo(Material o) { //낮은 온도순으로 정렬
            return o.low - this.low;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Material[] arr = new Material[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int cnt = 1;
        Material temp = arr[0];
        for(int i=1; i<N; i++){ //낮은 온도의 내림차순으로 정렬한 후, 높은 온도가 낮은 온도보다 작으면 카운트를 증가시킨다.
            if(temp.low>arr[i].high){
                cnt++;
                temp = arr[i];
            }
        }
        System.out.println(cnt);

    }
}
