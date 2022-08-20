import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1208 {
    /*
     * 방법생각: 1. 정렬후 앞과 뒤 양쪽에서 투포인터?
     * 
     */
    static int[] box = new int[100];
    public static void main(String[] args) throws Exception {
        int dump_count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int loop = 0; loop<10; loop++){
            dump_count = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for(int i=0; i<100; i++){
                box[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<dump_count; i++){
                Arrays.sort(box);
                box[0]++;
                box[99]--;
            }
            Arrays.sort(box);
            System.out.printf("#%d %d", loop+1, box[99]-box[0]);
            System.out.println();
        }
    }

}
