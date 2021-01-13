import java.lang.Math;

public class Radix extends SortableLinkedList{
  public static void main (String[] args) {
    // System.out.println(nth(123, 1));
    // System.out.println(nth(-123, 1));
    // System.out.println(nth(123, 2));
    // System.out.println(nth(-123, 2));

    // System.out.println(length(0));
    // System.out.println(length(15));
    // System.out.println(length(-10));
    // System.out.println(length(5112));
  }

  public static int nth (int n, int col) {
    n = Math.abs(n);
    return (int) (n % (Math.pow(10, col + 1)) / Math.pow(10, col));
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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
        original.extend(buckets[i]);
      }
    }
  }
}
