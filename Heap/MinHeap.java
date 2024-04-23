package Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
  List<Integer> heap = new ArrayList<Integer>();

  public MinHeap(List<Integer> array) {
    heap = buildHeap(array);
  }

  public List<Integer> buildHeap(List<Integer> array) {
    int lastParentIdx = (array.size() - 2) / 2;
    for (int currentIdx = lastParentIdx; currentIdx >= 0; currentIdx--) {
      siftDown(currentIdx, array.size() - 1, array);
    }
    return array;
  }

  public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
    while (true) {
      int leftChildIdx = getLeftChildIdx(currentIdx);
      int rightChildIdx = getRightChildIdx(currentIdx);
      int smallestIdx = currentIdx;

      if (leftChildIdx <= endIdx && heap.get(leftChildIdx) < heap.get(smallestIdx)) {
        smallestIdx = leftChildIdx;
      }

      if (rightChildIdx <= endIdx && heap.get(rightChildIdx) < heap.get(smallestIdx)) {
        smallestIdx = rightChildIdx;
      }

      if (smallestIdx != currentIdx) {
        swap(currentIdx, smallestIdx, heap);
        currentIdx = smallestIdx;
      } else {
        break;
      }
    }
  }

  public void siftUp(int currentIdx, List<Integer> heap) {
    int parentIdx = getParentIdx(currentIdx);
    while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
      swap(currentIdx, parentIdx, heap);
      currentIdx = parentIdx;
      parentIdx = getParentIdx(currentIdx);
    }
  }

  public int peek() {
    return heap.get(0);
  }

  public int remove() {
    int valueToRemove = heap.get(0);
    int lastIdx = heap.size() - 1;
    swap(0, lastIdx, heap);
    heap.remove(lastIdx);
    siftDown(0, lastIdx - 1, heap);
    return valueToRemove;
  }

  public void insert(int value) {
    heap.add(value);
    siftUp(heap.size() - 1, heap);
  }

  private int getParentIdx(int index) {
    return (index - 1) / 2;
  }

  private int getLeftChildIdx(int index) {
    return 2 * index + 1;
  }

  private int getRightChildIdx(int index) {
    return 2 * index + 2;
  }

  private void swap(int idx1, int idx2, List<Integer> heap) {
    int temp = heap.get(idx1);
    heap.set(idx1, heap.get(idx2));
    heap.set(idx2, temp);
  }
}
