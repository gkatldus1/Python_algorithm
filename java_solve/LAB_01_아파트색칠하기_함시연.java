import java.io.IOException;

public class LAB_01_아파트색칠하기_함시연 {
  static int[] ans;
  // public static void main(String[] args) {
  //   int n = 8;
  //   ans = new int[n + 1];
  //   ans[1] = 2;
  //   ans[2] = 3;
  //   System.out.println(findAns(8));
  // }
  public static void main(String []args) throws IOException {        
    int n = 8;
    int[] f = new int[n + 1];
    f[1] = 2;
    f[2] = 3;
    
    for(int i = 3; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    
    System.out.println(f[n]);
  }
  static int findAns(int n){
    if(ans[n]!=0)
      return ans[n];
    return ans[n] = findAns(n - 1) + findAns(n - 2);
  }
}
