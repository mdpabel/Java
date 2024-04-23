package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
  List<Integer> items = new ArrayList<>();

  public void add(int item) {
    items.add(item);
    bubbleUp();
  }

  public void remove() {
    var lastIndex = items.size() - 1;
    var lastEl = items.get(lastIndex);

    items.set(0, lastEl);
    items.remove(lastIndex);

    bubbleDown();
  }

  private void bubbleDown() {
    var parentIdx = 0;

    while (parentIdx < items.size()) {
      var leftChildIdx = getLeftChildIdx(parentIdx);
      var rightChildIdx = getRightChildIdx(parentIdx);

      var maxIdx = parentIdx;

      if (leftChildIdx < items.size() && items.get(leftChildIdx) > items.get(maxIdx)) {
        maxIdx = leftChildIdx;
      }
      if (rightChildIdx < items.size() && items.get(rightChildIdx) > items.get(maxIdx)) {
        maxIdx = rightChildIdx;
      }

      if (parentIdx == maxIdx) {
        break;
      }

      swap(parentIdx, maxIdx);
      parentIdx = maxIdx;
    }
  }

  private void bubbleUp() {
    var index = items.size() - 1;
    var parent = getParentIndex(index);

    while (index > 0 && items.get(index) > items.get(parent)) {
      swap(index, parent);
      index = parent;
      parent = getParentIndex(index);
    }
  }

  private void swap(int idx1, int idx2) {
    var item1 = items.get(idx1);
    var item2 = items.get(idx2);
    items.set(idx1, item2);
    items.set(idx2, item1);
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private int getLeftChildIdx(int index) {
    return index * 2 + 1;
  }

  private int getRightChildIdx(int index) {
    return index * 2 + 2;
  }

  @Override
  public String toString() {
    return items.toString();
  }
}
