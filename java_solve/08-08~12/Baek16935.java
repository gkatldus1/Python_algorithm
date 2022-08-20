import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek16935 {
    static int[][] map;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] K = new int[R];
        st = new StringTokenizer(br.readLine());
        for(int l=0; l<R; l++){
            K[l] = Integer.parseInt(st.nextToken());
            
            switch(K[l]){
                case 1: oper1();
                    break;
                case 2: oper2();
                    break;
                case 3: oper3();
                    break;
                case 4: oper4();
                    break;
                case 5: oper5();
                    break;
                case 6: oper6();
                    break;
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int[] arr: map){
            for(int n: arr){
                sb.append(n+" ");
            }
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    static void oper1(){    //투포인터로 앞의 배열을 뒤의 배열과 바꿔줌
        int[] temp;
        int front = 0;
        int back = N-1;
        while(front<back){
            temp = map[front];
            map[front] = map[back];
            map[back] = temp;
            front++;
            back--;
        }
    }

    static void oper2(){    //투 포인터로 배열 앞의 원소를 뒤의 원소와 바꿔줌
        int front = 0;
        int back = M-1;
        int temp;
        for(int i=0; i<N; i++){
            while(front<back){
                temp = map[i][front];
                map[i][front] = map[i][back];
                map[i][back] = temp;
                front++;
                back--;
            }
            front = 0;
            back = M-1;
        }

    }

    static void oper3(){    //임시 배열에 오른쪽으로 90도 회전한 원소들을 넣어주고 원래 배열과 바꿔치기
        int[][] temp = new int[M][N];
        int row = 0;
        int col = 0;
        for(int i=N-1; i>=0; i--){
            col = 0;
            for(int j=0; j<M; j++){
                temp[j][i] = map[row][col];
                col++;
            }
            row++;
        }
        map = temp;
        //M과 N이 바뀌었으므로 바꿔줌.
        int tmp = M;
        M = N;
        N = tmp;
    }

    static void oper4(){    //임시 배열에 왼쪽으로 90도 회전한 원소들을 넣어주고 원래 배열과 바꿔치기
        int[][] temp = new int[M][N];
        int row = 0;
        int col = 0;
        for(int i=0; i<N; i++){
            col = M-1;
            for(int j=0; j<M; j++){
                temp[j][i] = map[row][col];
                col--;
            }
            row++;
        }
        map = temp;
        //M과 N이 바뀌었으므로 바꿔줌.
        int tmp = M;
        M = N;
        N = tmp;
    }

    static void oper5(){
        int[][] tempAll = new int[N][M];
        int[][] temp = new int[N/2][M/2];
        //1->2
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                temp[i][j] = map[i][j];
            }
        }
        int row = 0;
        for(int i=0; i<N/2; i++){
            for(int j=M/2; j<M; j++){
                tempAll[i][j] = temp[row][j-(M/2)];
            }
            row++;
        }
        //2->3
        for(int i=0; i<N/2; i++){
            for(int j=M/2; j<M; j++){
                temp[i][j-(M/2)] = map[i][j];
            }
        }
        row = 0;
        for(int i=N/2; i<N; i++){
            for(int j=M/2; j<M; j++){
                tempAll[i][j] = temp[row][j-(M/2)];
            }
            row++;
        }
        //3->4
        for(int i=N/2; i<N; i++){
            for(int j=M/2; j<M; j++){
                temp[i-(N/2)][j-(M/2)] = map[i][j];
            }
        }
        row = 0;
        for(int i=N/2; i<N; i++){
            for(int j=0; j<M/2; j++){
                tempAll[i][j] = temp[row][j];
            }
            row++;
        }
        //4->1
        for(int i=N/2; i<N; i++){
            for(int j=0; j<M/2; j++){
                temp[i-(N/2)][j] = map[i][j];
            }
        }
        row = 0;
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                tempAll[i][j] = temp[row][j];
            }
            row++;
        }
        map= tempAll;
    }

    static void oper6(){
        int[][] tempAll = new int[N][M];
        int[][] temp = new int[N/2][M/2];
        //1->4
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                temp[i][j] = map[i][j];
            }
        }
        int row = 0;
        for(int i=N/2; i<N; i++){
            for(int j=0; j<M/2; j++){
                tempAll[i][j] = temp[row][j];
            }
            row++;
        }
        //4->3
        for(int i=N/2; i<N; i++){
            for(int j=0; j<M/2; j++){
                temp[i-(N/2)][j] = map[i][j];
            }
        }
        row = 0;
        for(int i=N/2; i<N; i++){
            for(int j=M/2; j<M; j++){
                tempAll[i][j] = temp[row][j-(M/2)];
            }
            row++;
        }
        //3->2
        for(int i=N/2; i<N; i++){
            for(int j=M/2; j<M; j++){
                temp[i-(N/2)][j-(M/2)] = map[i][j];
            }
        }
        row = 0;
        for(int i=0; i<N/2; i++){
            for(int j=M/2; j<M; j++){
                tempAll[i][j] = temp[row][j-(M/2)];
            }
            row++;
        }
        //2->1
        for(int i=0; i<N/2; i++){
            for(int j=M/2; j<M; j++){
                temp[i][j-(M/2)] = map[i][j];
            }
        }
        row = 0;
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                tempAll[i][j] = temp[row][j];
            }
            row++;
        }
        map= tempAll;
        
    }

}
