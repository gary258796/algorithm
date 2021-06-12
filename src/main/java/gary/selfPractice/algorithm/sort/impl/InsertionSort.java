/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InsertionSort extends Sort<Integer> {

  /* Algorithm
     from i=1 to collection.size-1
       compareElement = collection[i]; // item that needs to be insert to sorted array this loop
       from j=i-1 to j>=0 && collection[j]>compareElement
          collection[j+1] = collection[j];
       collection[j+1] = compareElement;
  */
  @Override
  public List<Integer> sorting(List<Integer> sortedData) {
    for (int i = 1; i < sortedData.size(); i++) {
      Integer compareElement = sortedData.get(i);
      int j = i - 1;
      while (j >= 0 && isBigger(sortedData.get(j), compareElement)) {
        sortedData.set(j + 1, sortedData.get(j));
        j--;
      }
      sortedData.set(j + 1, compareElement);
    }

    return sortedData;
  }

}
