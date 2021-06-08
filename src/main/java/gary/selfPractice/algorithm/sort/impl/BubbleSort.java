/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Bubble sort implementation.
 *
 * @param <T>
 */
@Component
public class BubbleSort<T> extends Sort<T> {

  /* Algorithm pseudo code
   * for(i=0 to collectionSize-1){
   *   for(j=i to collectionSize-1){
   *      if(collection[j]<collection[i])
   *        swap(i, j)
   *   }
   * }
   * */
  @Override
  public List<T> sorting(List<T> sortedData) {
    // boolean for case when data get sorted correctly before the last loop
    // then, we can save some time doing unneeded compare.
    boolean swapNeeded = true;
    for (int i = 0; i < sortedData.size() && swapNeeded; i++) {
      swapNeeded = false;
      for (int j = i; j < sortedData.size(); j++) {
        if (isBigger(sortedData.get(i), sortedData.get(j))) {
          // swap i and j element
          Swap(sortedData, i, j);
          swapNeeded = true;
        }

        // break for loop when the data already sorted correctly
        if (!swapNeeded) break;
      }
    }

    return sortedData;
  }
}
