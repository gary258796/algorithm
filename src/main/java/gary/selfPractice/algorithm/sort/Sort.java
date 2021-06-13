/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort;

import java.util.List;
import java.util.Objects;

/**
 * Interface that all sorts need to implements。 Provide a method 'sort', responsible to finish
 * sorting mission.
 */
public abstract class Sort<T> {

  /**
   * Main method of sorting data.
   *
   * @param sortedData: Data to be sort
   * @return sorted data by small to big
   */
  public abstract List<T> sorting(List<T> sortedData);

  /**
   * Return boolean which tells if first parameter is bigger than the second one.
   *
   * @param first:
   * @param second:
   * @return true if first is bigger than second
   */
  protected boolean isBigger(T first, T second) {
    boolean result = false;

    // Handle null condition
    // Treat null as the biggest value.
    // Therefore the sorting result will have all null elements at the back of the list.
    if (first == null && second != null) return true;
    else if (first != null && second == null) return false;
    else if (first == null && second == null) return false;

    if (first instanceof String) {
      String firstString = (String) first;
      String secondString = (String) second;
      if (firstString.compareTo(secondString) > 0) result = true;
    } else if (first instanceof Integer) {
      Integer firstInt = (Integer) first;
      Integer secondInt = (Integer) second;
      if (firstInt > secondInt) result = true;
    }

    return result;
  }

  /**
   * Return boolean which tells if first is equals to second
   *
   * @param first:
   * @param second:
   * @return boolean
   */
  protected boolean isEquals(T first, T second) {
    return Objects.equals(first, second);
  }

  /**
   * Swap the element value in indexA and indexB inside List
   *
   * @param list:
   * @param indexA:
   * @param indexB:
   */
  protected void Swap(List<T> list, int indexA, int indexB) {
    T temp = list.get(indexA);
    list.set(indexA, list.get(indexB));
    list.set(indexB, temp);
  }
}
