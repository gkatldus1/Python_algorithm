import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2578 {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        map = new int[5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] compare = new int[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                compare[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        int ans=0;
        outer:for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                change(compare[i][j]);
                ans++;
                if(ans>=13){
                    if(check()){
                        System.out.println(ans);
                        break outer;
                    }
                }
            }
        }
        
        // for(int[] arr: map){
        //     for(int i=0; i<5; i++)
        //         System.out.print(arr[i]+" ");
        //     System.out.println();
        // }
        

    }
    static void change(int n){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j] == n)  map[i][j] = 1;
            }
        }
    }
    static boolean check(){
        int line=0;
        int cnt=0;
        //가로 빙고 체크
        for(int[] arr: map){
            for(int i=0; i<5; i++)
                if(arr[i]==1)   cnt++; 
            if(cnt==5)  line++;
            cnt=0;
        }
        //세로 빙고 체크
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[j][i]==1)    cnt++;
            }
            if(cnt==5)  line++;
            cnt=0;
        }
        //대각선 좌상단 우하단
        for(int i=0; i<5; i++)
            if(map[i][i]==1)    
                cnt++;
        
        if(cnt==5)  line++;
        cnt=0;
        //대각선 우상단 좌하단
        for(int i=0; i<5; i++)
            if(map[i][4-i]==1) 
                cnt++;

        if(cnt==5)  line++;

        //빙고인지 아닌지 확인
        if(line>=3) return true;
        return false;
    }
}
