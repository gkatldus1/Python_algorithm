import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {
    static char[] chars;
    static char[] selected;
    static String vo = "aeiou";

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        combination(0, 0, L, C);
        System.out.println(sb);

    }

    static void combination(int cnt, int start, int L, int C) {
        if (cnt == L) {
            if (isValid(selected)) {

                sb.append(String.valueOf(selected) + "\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            selected[cnt] = chars[i];
            combination(cnt + 1, i + 1, L, C);
        }
    }

    static boolean isValid(char[] selected) {
        int count_vo = 0, count_con = 0;
        for (char ch : selected) {
            if (vo.contains(ch + ""))
                count_vo++;
            else
                count_con++;
        }
        if (count_vo >= 1 && count_con >= 2)
            return true;
        return false;
    }
}
