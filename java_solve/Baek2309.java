import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2309 {
    static int[] dwarf;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        for(int i=0; i<9; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        combination(0, 0, 7, new int[7]);
    }

    static void combination(int cnt, int start, int R, int[] selected){
        if(cnt == R){
            if(Arrays.stream(selected).sum()==100){
                Arrays.sort(selected);
                for(int i=0; i<selected.length; i++){
                    System.out.println(selected[i]);
                }
                flag = true;
            }
            return;
        }
        for(int i=start; i<dwarf.length; i++){
            selected[cnt] = dwarf[i];
            combination(cnt+1, i+1, R, selected);
            if(flag)    break;
        }
    }
}
