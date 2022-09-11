import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15686 {
    static List<Integer> sum_list = new ArrayList<>();
    static List<Home> home = new ArrayList<>();
    static List<Chicken> chicken = new ArrayList<>();
    static int[] selected;
    static int min = Integer.MAX_VALUE;

    static class Home {
        int x;
        int y;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Chicken {
        int x;
        int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        int temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    chicken.add(new Chicken(i, j));
                } else if (temp == 1) {
                    home.add(new Home(i, j));
                }
            }
        }
        findStreet(0, M, 0);
        System.out.println(min);
    }

    static void findStreet(int count, int M, int start) {

        if (count == M) { // M만큼 치킨집이 선택 되었다면

            int temp_street = 0;

            for (int i = 0; i < home.size(); i++) { // 각각의 집마다 치킨 거리를 구해준다.
                int temp_min = Integer.MAX_VALUE;
                int r = home.get(i).x;
                int c = home.get(i).y;
                for (int j : selected) {
                    int temp = Math.abs(r - chicken.get(j).x) + Math.abs((c - chicken.get(j).y)); // 집에서 모든 치킨집의 거리를 빼주고
                                                                                                  // 그 중 가장 작은 곳을 찾는다.
                    temp_min = Math.min(temp, temp_min);
                }
                temp_street += temp_min;
            }
            min = Math.min(temp_street, min);
            return;
        }

        for (int i = start; i < chicken.size(); i++) { // 조합으로 치킨 집을 선택하고
            selected[count] = i;
            findStreet(count + 1, M, i + 1);
        }
    }

}
