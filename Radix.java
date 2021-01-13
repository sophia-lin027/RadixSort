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

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      bucket[i] = new SortableLinkedList();
    }

    int largest = 0;
    for (int i = 0; i <= largest; i++) {
      while (data.size() >  0) {
        if (length(data.get(0)) > largest) {
          largest = length(data.get(0));
        }
        (bucket[Math.abs(nth(data.get(0), i))]).add(data.remove(0));
      }
      merge(data, bucket);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList positive_values = new SortableLinkedList();
    SortableLinkedList negative_values = new SortableLinkedList();

    while (data.size() > 0) {
      if (data.get(0) >= 0) {
        positive_values.add(data.remove(0));
      }
      else {
        negative_values.add(data.remove(0));
      }
    }

    radixSortSimple(positive_values);
    radixSortSimple(negative_values);

    while (negative_values.size() > 0) {
      data.add(0, negative_values.remove(0));
    }

    data.extend(positive_values);
  }
}
