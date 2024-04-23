package DivideAndConquer;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] items = { 1, 0, 12, 11, 13, 5, 6 };

    var mergeSort = new MergeSort();
    mergeSort.sort(items);

    System.out.println(Arrays.toString(items));
  }
}
