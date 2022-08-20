package 분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek1780 {
    static int N;
    static int[][] paper;
    static int m_count, z_count, p_count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        district(0,0,N);
        System.out.println(m_count);
        System.out.println(z_count);
        System.out.println(p_count);

    }

    static void district(int r, int c, int size){
        if(isPossible(r, c, size)){
            return;
        }
        int sep = size/3;
        district(r, c, sep); district(r, c+sep, sep); district(r, c+(sep*2), sep);//왼쪽 가운데 오른쪽, 첫번째 라인
        district(r+sep, c, sep); district(r+sep, c+sep, sep); district(r+sep, c+(sep*2), sep);//왼쪽 가운데 오른쪽, 두번째 라인
        district(r+(sep*2), c, sep); district(r+(sep*2),c+sep, sep); district(r+(sep*2),c+(sep*2), sep);//왼쪽 가운데 오른쪽, 세번째 라인


    }

    static boolean isPossible(int r, int c, int size){
        int value = paper[r][c];
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(value!=paper[i][j]){
                    return false;
                }
            }
        }
        if(value==-1)   m_count++;
        else if(value==0)   z_count++;
        else    p_count++;
        return true;
    }

}
