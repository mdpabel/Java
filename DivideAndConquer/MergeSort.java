package DivideAndConquer;

public class MergeSort {

  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private void sort(int[] arr, int left, int right) {
    if (left >= right)
      return;

    int mid = (left + right) / 2;

    sort(arr, left, mid);
    sort(arr, mid + 1, right);

    merge(arr, left, mid, right);
  }

  private void merge(int[] arr, int left, int mid, int right) {
    int leftArrSize = mid - left + 1;
    int rightArrSize = right - mid;

    // Create temporary arrays
    int[] leftArr = new int[leftArrSize];
    int[] rightArr = new int[rightArrSize];

    for (int i = 0; i < leftArrSize; i++)
      leftArr[i] = arr[left + i];

    for (int j = 0; j < rightArrSize; j++)
      rightArr[j] = arr[mid + 1 + j];

    // marge back to original array
    int i = 0, j = 0;
    int k = left;

    while (i < leftArrSize && j < rightArrSize) {
      if (leftArr[i] <= rightArr[j])
        arr[k++] = leftArr[i++];
      else
        arr[k++] = rightArr[j++];
    }

    // Copy remaining elements of left and right arrays if any
    while (i < leftArrSize) {
      arr[k++] = leftArr[i++];
    }

    while (j < rightArrSize)
      arr[k++] = rightArr[j++];
  }

}