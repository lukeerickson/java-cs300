
public class AlgoExample {

  // complexity: O(1)
  public static double method1(int N) {
    return Math.pow(N, 2);
  }

  // complexity: O(N)
  public static double method2(int N) {
    double result = 1;
    for (int i = 0; i < N; i++)
      result *= 2;
    return result;
  }

  // complexity: O(log N)
  // look for the way in which i changes
  // i*= 2 is a good indication of logarithmic
  public static int method3(int N) {
    int result = 0;
    for (int i = 1; i < N; i *= 2)
      result++;
    return result;
  }

  // complexity: O(N^2)
  public static double method5(int N) {
    double result = 0;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < i; k++)
        result++;
    }
    return result;
  }

  // complexity: O(N^2)
  public static double method6(int N) {
    double result = 0;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < i; k++)
        result++;
    }
    for (int j = 0; j < N; j++)
      result--;
    return result;
  }

  // complexity: O(N^3)
  public static double method7(int N) {
    double result = 0;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < i; k++) {
        result++;
        for (int j = 0; j < N; j++)
          result--;
      }
    }
    return result;
  }

  // complexity: O(N)
  // constant time dependent on N
  public static double method8(int N) {
    if (N == 0)
      return N;
    return N + method8(N - 1);
  }

  // complexity: O(log N)
  // cuz N/2
  public static double method9(int N) {
    if (N == 0)
      return N;
    return N + method9(N / 2);
  }

  // complexity: O(N^2)
  public static double method11(int N) {
    if (N == 0)
      return N;
    double total = method11(N-1);
    for(int i = 0; i < N; i++)
      total += i;
    return total;
  }
  
  // complexity: O(N^2)
  public static double method4(int N) {
    double result = 1;
    for (int i = 0; i < N * N; i++)
      result *= 2;
    return result;
  }
  
  // complexity: very
  public static double method10(int N) {
    if (N == 0)
      return N;
    double total = N;
    for (int i = 0; i < N; i++)
      total += method10(N - i);
    return total;
  }

  public static void main(String[] args) {
    System.out.println(method1(5));

  }
}
