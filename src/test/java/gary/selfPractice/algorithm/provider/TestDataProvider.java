/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestDataProvider {

  /** @return empty list */
  static Stream<List<Integer>> emptyData() {
    List<Integer> data = new ArrayList<>();
    return Stream.of(data);
  }

  /** @return list with one element */
  static Stream<List<Integer>> oneElementData() {
    List<Integer> data = new ArrayList<>();
    data.add(10);
    return Stream.of(data);
  }

  /** @return list with three element */
  static Stream<List<Integer>> threeElementData() {
    List<Integer> data = new ArrayList<>();
    data.add(3);
    data.add(2);
    data.add(1);
    return Stream.of(data);
  }

  /** @return list with null as first element */
  static Stream<List<Integer>> includeNullElementDataAtFirst() {
    List<Integer> data = new ArrayList<>();
    data.add(null);
    data.add(3);
    data.add(2);
    data.add(1);
    return Stream.of(data);
  }

  /** @return list with null at middle */
  static Stream<List<Integer>> includeNullElementDataAtMiddle() {
    List<Integer> data = new ArrayList<>();
    data.add(3);
    data.add(2);
    data.add(null);
    data.add(1);
    return Stream.of(data);
  }

  /** @return list with multiple null element inside */
  static Stream<List<Integer>> includeNullElementsData() {
    List<Integer> data = new ArrayList<>();
    data.add(2);
    data.add(10);
    data.add(3);
    data.add(null);
    data.add(null);
    data.add(null);
    data.add(1);
    return Stream.of(data);
  }
}
