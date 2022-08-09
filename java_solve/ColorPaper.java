import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ColorPaper {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N  = Integer.parseInt(br.readLine());
        int[][] boxes = new int[100][100];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            for(int j=width; j<width+10; j++){
                for(int k=height; k<height+10; k++){
                    boxes[j][k] = 1;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                sum += boxes[i][j];
            }
        }
        System.out.println(sum);
    }
}
