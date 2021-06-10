/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@DisplayName("Testing sorting...")
@ComponentScan(basePackages = "gary.selfPractice.algorithm.sort.impl")
public class BubbleSortTest {

  @Autowired private BubbleSort bubbleSort;

  @Tag("BubbleSort")
  @DisplayName("Run BubbleSort.. ")
  @ParameterizedTest
  @MethodSource("gary.selfPractice.algorithm.provider.TestDataProvider#sortData")
  void bubbleSort(List<Integer> testData) {
    List<Integer> sortedData = bubbleSort.sorting(testData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals("[1, 2, 3]", sortedData.toString());
  }
}
