/* (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.sort.Sort;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Selection sort implementation.
 *
 * @param <T>
 */
@Component
public class SelectionSort<T> extends Sort<T> {

  /*
    Algorithm:
    from i = 0 to collection.size-2
      pick i as minElement;
      from j=i+1 to collection.size-1
        if(collection[j]<minElement)
          minElement = j;
      if(minElement != i)
        Swap(minElement,i);
  */
  @Override
  public List<T> sorting(List<T> sortedData) {
    for (int i = 0; i < sortedData.size() - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < sortedData.size(); j++) {
        if (isBigger(sortedData.get(i), sortedData.get(j))) minIndex = j;
      }
      if (minIndex != i) Swap(sortedData, i, minIndex);
    }

    return sortedData;
  }
}
