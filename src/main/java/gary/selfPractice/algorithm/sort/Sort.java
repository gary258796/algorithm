/* (C)2021 */
package gary.selfPractice.algorithm.sort;

import java.util.List;

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
}
