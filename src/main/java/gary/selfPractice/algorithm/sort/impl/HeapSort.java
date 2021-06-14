/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class HeapSort extends Sort<Integer> {

  /**
   * fmt:off
     *
     *  Algorithm
     *  1. make unSorted list as max-heap, since we want our result as a increasing order.
     *  2. Largest item is at the root, swap root with last item, and do heapify.
     *  3. Repeat step 2 until the size of heap is equals to 1
     *
     *
     *  Info:
     *  For a Complete Binary tree,
     *  index l will have left child at 2*l+1, and right child at 2*l+2.
     *  index i will have parent at (i-1)/2
     *  fmt:on
   */
  @Override
  public List<Integer> sorting(List<Integer> sortedData) {
    heapSort(sortedData);
    return sortedData;
  }

  private void heapSort(List<Integer> unSortedData) {
    // The last node with child leaf.
    int lastNodeWithLeaf = unSortedData.size() / 2 - 1;
    // heapify from the last node with child leaf to root.
    // then we will have our list as a max-heap
    for (int i = lastNodeWithLeaf; i >= 0; i--) heapify(unSortedData, i, unSortedData.size());

    // sort data by continually swapping root with last element.
    for (int i = unSortedData.size() - 1; i > 0; i--) {
      Swap(unSortedData, 0, i);
      // need only heapify root cause the heap is max-heap before swap.
      heapify(unSortedData, 0, i);
    }
  }

  /**
   * Need max-heap, so will put largest at root.
   *
   * @param unSortedData: data to be sort
   * @param root: current index as root, will heapify this 'root' node.
   * @param length: data's length
   */
  private void heapify(List<Integer> unSortedData, int root, int length) {
    int leftChild = root * 2 + 1;
    int rightChild = root * 2 + 2;
    int max = root; // max will be set to root as default

    // compare with left child first
    if (leftChild < length && isBigger(unSortedData.get(leftChild), unSortedData.get(root)))
      max = leftChild;
    // then compare with right child
    if (rightChild < length && isBigger(unSortedData.get(rightChild), unSortedData.get(max)))
      max = rightChild;

    // Swap if max isn't equals to root
    if (!Objects.equals(max, root)) {
      Swap(unSortedData, root, max);
      heapify(unSortedData, max, length);
    }
  }
}
