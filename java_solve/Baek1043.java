import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baek1043 {
  static int[] parent;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");

    int n = Integer.parseInt(inputs[0]);
    int m = Integer.parseInt(inputs[1]);

    boolean[] people_know = new boolean[n + 1];

    HashSet<Integer>[] parties = new HashSet[m + 1];
    for (int i = 1; i <= m; i++) {
      parties[i] = new HashSet<>();
    }

    inputs = br.readLine().split(" ");
    int know_num = Integer.parseInt(inputs[0]);

    for (int i = 1; i <= know_num; i++) {
      int tmp = Integer.parseInt(inputs[i]);
      people_know[tmp] = true;
    }

    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int p = 1; p <= m; p++) {
      
    }



  }
}
