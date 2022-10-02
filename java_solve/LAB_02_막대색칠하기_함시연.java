public class LAB_02_막대색칠하기_함시연 {
  static int[] ans;
  public static void main(String[] args) {
    int n = 6;
    ans = new int[n + 1];
    ans[1] = 2;
    ans[2] = 5;
    System.out.println(findAns(n));
  }

  static int findAns(int n) {
    if (n == 1 || n == 2) {
      return ans[n];
    }
    if (ans[n] != 0)
      return ans[n];
    return ans[n] = findAns(n - 1) * 2 + findAns(n - 2);
  }
}
