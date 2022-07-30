import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //입력 버퍼 생성
        StringTokenizer st = new StringTokenizer(br.readLine());    //N, M 입력 받고 토큰 생성
        int N = Integer.parseInt(st.nextToken());   // N을 int로 변환
        int M = Integer.parseInt(st.nextToken());   //M을 int로 변환
        int map[][] = new int[N + 1][N + 1];    //표를 받기 위한 배열 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());    //값들을 한줄씩 입력 받음
            for (int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());   //입력받은 값을 int로 파싱 후 배열에 저장
            }
        }
        int sum[][] = new int[N + 1][N + 1];    //구간합을 위한 배열 생성
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + map[i][j];  //루프문을 통해 전체 구간합들을 구한 뒤 배열에 저장
            }
        }
        for (int i = 0; i < M; i++){    //반복 횟수만큼 구해야할 좌표들을 입력 받고 int로 변환
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]; //목표로 하는 구간을 포함하고 있는 전체 큰 사각형에서 포함되어 있지 않은 구간들을 제거한 후 중복되어 뺴어진 값을 다시 더해줌 
            System.out.println(result);
        }
    }
}
