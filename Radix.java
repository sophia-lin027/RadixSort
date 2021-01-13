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
    int largest = 0;
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) > largest) {
        largest = data.get(i);
      }
    }
    int passes = length(largest);

    for (int i = 0; i < passes; i++) {
      SortableLinkedList zero = new SortableLinkedList();
      SortableLinkedList one = new SortableLinkedList();
      SortableLinkedList two = new SortableLinkedList();
      SortableLinkedList three = new SortableLinkedList();
      SortableLinkedList four = new SortableLinkedList();
      SortableLinkedList five = new SortableLinkedList();
      SortableLinkedList six = new SortableLinkedList();
      SortableLinkedList seven = new SortableLinkedList();
      SortableLinkedList eight = new SortableLinkedList();
      SortableLinkedList nine = new SortableLinkedList();
      for (int j = 0; j < data.size(); j++) {
        int digit = nth(data.get(j), i);
        if (digit == 0) zero.add(data.get(j));
        else if (digit == 1) one.add(data.get(j));
        else if (digit == 2) two.add(data.get(j));
        else if (digit == 3) three.add(data.get(j));
        else if (digit == 4) four.add(data.get(j));
        else if (digit == 5) five.add(data.get(j));
        else if (digit == 6) six.add(data.get(j));
        else if (digit == 7) seven.add(data.get(j));
        else if (digit == 8) eight.add(data.get(j));
        else if (digit == 9) nine.add(data.get(j));
      }

      SortableLinkedList temporary = new SortableLinkedList();
      SortableLinkedList[] bucket = new SortableLinkedList[] {zero, one, two, three, four, five, six, seven, eight, nine};
      merge(temporary, bucket);

      for (int j = data.size() - 1; j>= 0; j--) {
        data.remove(j);
      }
      data.extend(temporary);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList positive_values = new SortableLinkedList();
    SortableLinkedList negative_values = new SortableLinkedList();

    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) >= 0) {
        positive_values.add(data.get(i));
      }
      else {
        negative_values.add(data.get(i));
      }
    }

    radixSortSimple(positive_values);
    radixSortSimple(negative_values);
    SortableLinkedList temporary = new SortableLinkedList();

    for (int i = data.size() - 1; i>= 0; i--) {
      data.remove(i);
    }

    for (int i = 0; i < negative_values.size(); i++) {
      data.add(negative_values.get(i));
    }

    data.extend(positive_values);
  }
}
