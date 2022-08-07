import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tank {
    static char[][] map;
    static char[] instruct;
    static int H;
    static int W;
    static int x;
    static int y;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int loop=0; loop<T; loop++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for(int i=0; i<H; i++){
                String str = bf.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            
            int N = Integer.parseInt(bf.readLine());
            String str = bf.readLine();
            instruct = new char[N];
            for(int i=0; i<N; i++){
                instruct[i] = str.charAt(i);
            }
            command();
            
            System.out.print("#"+(loop+1)+" ");
            for(int j=0; j<H; j++){
                for(int i=0; i<W; i++){
                    System.out.print(map[j][i]);
                }
                System.out.println();
            }

        }
    }
    
    
    
    static void command(){
        for(int i=0; i<H; i++){     //전차 위치 찾기
            for(int j=0; j<W; j++){
                if(isTank(i, j)){
                    x = i;
                    y = j;
                    break;
                }
            }
        } 
        //명령어 시작
        for(char ins: instruct){
            switch(ins){
                case 'U':
                    Up();
                    break;
                case 'D':
                    Down();
                    break;
                case 'L':
                    Left();
                    break;
                case 'R':
                    Right();
                    break;
                case 'S':
                    Shoot();
                    break;
            }
        }
    }
    static boolean isOut(int x, int y){
        boolean res = false;
        if(x<0 || x >= H|| y<0 ||y>=W ){
            res = true;
            return res;
        }
        return res;
    }

    static boolean isTank(int x, int y){
        boolean res = false; 
        if(map[x][y]=='^' ||map[x][y]=='v' || map[x][y]=='<' || map[x][y]=='>')
            res = true;
        return res;
    }
    static void Up(){
        if(isOut(x-1, y))
            return;
        map[x][y] = '^';
        if(map[x-1][y] == '.'){
            map[x-1][y] = '^';
            map[x][y] = '.';
            x--;
        }
    }
    static void Down(){
        if(isOut(x+1, y))
            return;
        map[x][y] = 'v';
        if(map[x+1][y] == '.'){
            map[x+1][y] = 'v';
            map[x][y] = '.';
            x++;
        }
    }
    static void Left(){
        if(isOut(x, y-1))
            return;
        map[x][y] = '<';
        if(map[x][y-1] == '.'){
            map[x][y-1] = '<';
            map[x][y] = '.';
            y--;
        }
    }
    static void Right(){
        if(isOut(x, y+1))
            return;
        map[x][y] = '>';
        if(map[x][y+1] == '.'){
            map[x][y+1] = '>';
            map[x][y] = '.';
            y++;
        }
    }
    static void Shoot(){
        int i= x;
        int j = y;
        if(map[i][j] == '^'){
            while(true){
                if(isOut(i-1, j))
                    return;
                if(map[i-1][j] == '*'){
                    map[i-1][j] = '.';
                    return;
                }
                if(map[i-1][j] == '#'){
                    return;
                }
                i--;
            }
        }else if(map[i][j] == 'v'){
            while(true){
                if(isOut(i+1, j))
                    return;
                if(map[i+1][j] == '*'){
                    map[i+1][j] = '.';
                    return;
                }
                if(map[i+1][j] == '#'){
                    return;
                }
                i++;
            }
        }else if(map[i][j] == '<'){
            while(true){
                if(isOut(i, j-1))
                    return;
                if(map[i][j-1] == '*'){
                    map[i][j-1] = '.';
                    return;
                }
                if(map[i][j-1] == '#'){
                    return;
                }
                j--;
            }
        }else if(map[i][j] == '>'){
            while(true){
                if(isOut(i, j+1))
                    return;
                if(map[i][j+1] == '*'){
                    map[i][j+1] = '.';
                    return;
                }
                if(map[i][j+1] == '#'){
                    return;
                }
                j++;
            }
        }
    }

}
