import java.io.StringReader;
import java.util.Scanner;

public class robot {

    static String str = 
    "3\r\n"+
    "6\r\n"+
   "S A S S W S\r\n"+
    "S W A S C S\r\n" +
    "S W S W S S\r\n"+
    "S W S S W S\r\n"+
    "S B S S W S\r\n"+
    "S S S S S S";

    public static void main(String[] args) {
        Scanner in = new Scanner(new StringReader(str));
        int T = in.nextInt();
        for(int loop=0; loop<T; loop++){
            int N = in.nextInt();
            char[][] area = new char[N][N];
            for (int i = 0; i < N; i++) {   
                for (int j = 0; j < N; j++) {
                    area[i][j] = in.next().charAt(0);
                }
            }

            int sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(area[i][j] == 'A'){  //오른쪽
                        for(int k = j+1; k<N; k++){
                            if(area[i][k]!='S')
                                break;
                            sum += 1;
                        }
                        
                    }
                    if(area[i][j] == 'B'){  
                        for(int k = j+1; k<N; k++){
                            if(area[i][k]!='S')
                                break;
                            sum += 1;
                        }
                        for(int k=j-1; k>=0; k--){  //왼쪽
                            if(area[i][k]!='S')
                                break;
                            sum += 1;
                        }
                    }
                    if(area[i][j] == 'C'){
                        for(int k = j+1; k<N; k++){
                            if(area[i][k]!='S')
                                break;
                            sum += 1;
                        }
                        for(int k=j-1; k>=0; k--){
                            if(area[i][k]!='S')
                                break;
                            sum += 1;
                        }
                        for(int k = i+1; k<N; k++){     //아래쪽
                            if(area[k][j]!='S') 
                                break;
                            sum += 1;
                        }
                        for(int k=i-1; k>=0; k--){      //위쪽
                            if(area[k][j]!='S')
                                break;
                            sum += 1;
                        }
                        
                    }
                }
            }
            System.out.printf("#%d ",loop+1);
            System.out.println(sum);
        }
    }
}
