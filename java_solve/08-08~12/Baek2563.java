import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2563 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N  = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(width, height);
        }
        Arrays.sort(boxes);
        int allBoxes = 100*N; 
        for(int i=1; i<boxes.length; i++){
            if(boxes[i].width[0] >= boxes[i-1].width[0] && boxes[i].width[0] < boxes[i-1].width[1]){

                if(boxes[i].height[1]<=boxes[i-1].height[1]&&boxes[i].height[1]>boxes[i-1].height[0]){
                    int height = boxes[i].height[1] - boxes[i-1].height[0];
                    int width = boxes[i-1].width[1] - boxes[i].width[0];
                    allBoxes -= (height*width);

                } else if(boxes[i].height[0]>=boxes[i-1].height[0]&&boxes[i].height[0]<boxes[i-1].height[1]){
                    int height = boxes[i-1].height[1] - boxes[i].height[0];
                    int width = boxes[i-1].width[1] - boxes[i].width[0];
                    allBoxes -= (height*width);
                }
            }
        }
        bw.write(allBoxes);
        bw.close();
    }
}
class Box implements Comparable<Box>{
    int[] width = new int[2];
    int[] height = new int[2];
    public Box(int w, int h){
        this.width[0] = w;
        this.width[1] = w+10;
        this.height[0] = h;
        this.height[1] = h+10;
    }
    @Override
    public int compareTo(Box o) {
        return this.width[0] - o.width[0];
    }
}