/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestDataProvider {

  static Stream<List<Integer>> sortData() {
    List<Integer> data = new ArrayList<>();
    data.add(3);
    data.add(2);
    data.add(1);
    return Stream.of(data);
  }
}
