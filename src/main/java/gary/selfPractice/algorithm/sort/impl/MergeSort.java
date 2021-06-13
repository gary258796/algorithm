/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MergeSort extends Sort<Integer> {

  /**
   * fmt:off
     *
     *  Algorithm
     *
     *  MergeSort(left, right) {
     *      if(left<right) {
     *          mid = (left+right)/2;
     *          MergeSort(left, mid);
     *          MergeSort(mid+1, right);
     *          merge(left, mid, right);
     *      }
     *  }
     *
     *  fmt:on
   */
  @Override
  public List<Integer> sorting(List<Integer> sortedData) {
    MergeSorted(sortedData, 0, sortedData.size() - 1);
    return sortedData;
  }

  /**
   * Implement algorithm of merge sort
   *
   * @param unSortedData:
   * @param left:
   * @param right:
   */
  private void MergeSorted(List<Integer> unSortedData, Integer left, Integer right) {
    if (left < right) {
      int midIndex = (left + right) / 2;
      MergeSorted(unSortedData, left, midIndex);
      MergeSorted(unSortedData, midIndex + 1, right);
      mergeList(unSortedData, left, midIndex, right);
    }
  }

  /**
   * Merge two part of list, when finished, the part of list will be sorted.
   *
   * @param unSortedList:
   * @param left: start Index of first part.
   * @param mid: end index of first part && start index of second part
   * @param right: end index of second part
   */
  private void mergeList(List<Integer> unSortedList, Integer left, Integer mid, Integer right) {
    /* Calculate length of left and right list */
    int lengthOfLeft = mid - left + 1;
    int lengthOfRight = right - mid;
    /* Create two temp arrays */
    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    /* Copy Data to arrays */
    for (int i = 0; i < lengthOfLeft; i++) leftList.add(unSortedList.get(left + i));
    for (int j = 0; j < lengthOfRight; j++) rightList.add(unSortedList.get(mid + 1 + j));
    /* Merge left and right array */
    int i = 0, j = 0;
    int k = left; // index start to be set as new sorted data
    // when i or j not used off all elements in left or right list
    while (i < lengthOfLeft && j < lengthOfRight) {
      // right(j) >= left(i)
      if (isBigger(rightList.get(j), leftList.get(i))
          || isEquals(rightList.get(j), leftList.get(i))) {
        unSortedList.set(k, leftList.get(i));
        i++;
      } else {
        unSortedList.set(k, rightList.get(j));
        j++;
      }

      k++;
    }

    /* Handle remains data in left or right list , will only have one of list remains data */
    while (i < lengthOfLeft) {
      unSortedList.set(k, leftList.get(i));
      i++;
      k++;
    }
    while (j < lengthOfRight) {
      unSortedList.set(k, rightList.get(j));
      j++;
      k++;
    }
  }
}
