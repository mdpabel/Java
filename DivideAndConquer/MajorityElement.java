package DivideAndConquer;

public class MajorityElement {
  public int majority(int[] arr) {
    return majority(arr, 0, arr.length - 1);
  }

  private int majority(int[] arr, int left, int right) {
    if (left == right)
      return arr[left];

    int mid = (left + right) / 2;

    int leftMajority = majority(arr, left, mid);
    int rightMajority = majority(arr, mid + 1, right);

    if (leftMajority == rightMajority)
      return leftMajority;

    int leftOccurrences = countOccurrences(arr, leftMajority, left, right);
    int rightOccurrences = countOccurrences(arr, rightMajority, left, right);

    return leftOccurrences > rightOccurrences ? leftMajority : rightMajority;
  }

  private int countOccurrences(int[] arr, int item, int left, int right) {
    int count = 0;

    for (int i = left; i < right + 1; i++) {
      if (arr[i] == item)
        count++;
    }

    return count;
  }
}
