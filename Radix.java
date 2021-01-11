public class Radix {
  public static void main (String[] args) {
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(5112));
  }

  public static int nth (int n, int col) {
    return 0;
  }

  public static int length (int n) {
    n = Math.abs(n);
    if (n >= 0 && n < 10) {
      return 1;
    }
    else {
      return (int) Math.log10(n) + 1;
    }
  }
}
