/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class QuickSort extends Sort<Integer> {

  /**
   * fmt:off
   * Algorithm(Divide and Conquer)
   *
   * quickSort(arr[], low, high) {
   *    if(low<high){
   *      // partition is responsible to place pivotIndex in correct place of array
   *      pivotIndex = partition(arr, low, high);
   *      // divide and conquer
   *      quickSort(arr, low, pivotIndex-1);
   *      quickSort(arr, pivotIndex+1, high);
   *    }
   * }
   *
   * // pivot element will be every last element
   * partition(array, low, high) {
   *    // Store the index of elements that are smaller then array[right]
   *    int i = low-1;
   *    for(j=low; j < high; j++ ) {
   *    // compare all element with array[right]
   *      if(array[j] <= array[right]) {
   *        // if j element is smaller or equals to our pivot element
   *        // swap j to the front part where we put all elements that are smaller than pivot
   *        i++;
   *        swap(array[i], array[j]);
   *      }
   *    }
   *    // after finishing arrange other elements, put our pivot into correct place
   *    swap(i+1, high);
   *    return i+1;
   * }
   * fmt:on
   */
  @Override
  public List<Integer> sorting(List<Integer> sortedData) {
    quickSort(sortedData, 0, sortedData.size() - 1);
    return sortedData;
  }

  /**
   * Main part of quickSort
   *
   * @param unSortedData:
   * @param low:
   * @param high:
   */
  private void quickSort(List<Integer> unSortedData, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(unSortedData, low, high);
      quickSort(unSortedData, low, pivotIndex - 1);
      quickSort(unSortedData, pivotIndex + 1, high);
    }
  }

  /**
   * Sort the subList, by putting pivot to correct place and others in bigger or smaller place
   *
   * @param unSortedData: Data unSorted totally
   * @param low: the min index of list
   * @param high: the max index of list
   * @return A List with pivot index in correct place in List and bigger and smaller elements in
   *     right position.
   */
  private Integer partition(List<Integer> unSortedData, Integer low, Integer high) {
    // The biggest index of elements that are smaller then array[right]
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (isBigger(unSortedData.get(high), unSortedData.get(j))
          || Objects.equals(unSortedData.get(high), unSortedData.get(j))) {
        i++;
        Swap(unSortedData, i, j);
      }
    }
    Swap(unSortedData, i + 1, high);
    return i + 1;
  }
}
