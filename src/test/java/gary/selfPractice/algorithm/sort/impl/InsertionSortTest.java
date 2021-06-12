/* Licensed of Gary Liao (C)2021 */
package gary.selfPractice.algorithm.sort.impl;

import gary.selfPractice.algorithm.recordTime.TimingExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ExtendWith(TimingExtension.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("Testing InsertSort...")
@ComponentScan(basePackages = "gary.selfPractice.algorithm.sort.impl")
public class InsertionSortTest {

  @Autowired private InsertionSort insertionSort;

  @Tag("InsertionSort")
  @Order(1)
  @DisplayName("Test empty list...")
  @ParameterizedTest
  @MethodSource("gary.selfPractice.algorithm.provider.TestDataProvider#emptyData")
  void testEmptySort(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    Assertions.assertEquals("[]", sortedData.toString());
  }

  @Tag("InsertionSort")
  @Order(2)
  @DisplayName("Test size 1 list...")
  @ParameterizedTest
  @MethodSource("gary.selfPractice.algorithm.provider.TestDataProvider#oneElementData")
  void testSizeOneSort(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    Assertions.assertEquals("[10]", sortedData.toString());
  }

  @Tag("InsertionSort")
  @Order(3)
  @DisplayName("Test size 3 list...")
  @ParameterizedTest
  @MethodSource("gary.selfPractice.algorithm.provider.TestDataProvider#threeElementData")
  void testSizeThreeSort(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals("[1, 2, 3]", sortedData.toString());
  }

  @Tag("InsertionSort")
  @Order(4)
  @DisplayName("Test list include null at first element...")
  @ParameterizedTest
  @MethodSource(
      "gary.selfPractice.algorithm.provider.TestDataProvider#includeNullElementDataAtFirst")
  void testDataWithNullAtFirst(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals("[1, 2, 3, null]", sortedData.toString());
  }

  @Tag("InsertionSort")
  @Order(5)
  @DisplayName("Test list include null at middle element...")
  @ParameterizedTest
  @MethodSource(
      "gary.selfPractice.algorithm.provider.TestDataProvider#includeNullElementDataAtMiddle")
  void testDataWithNullAtMiddle(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals("[1, 2, 3, null]", sortedData.toString());
  }

  @Tag("InsertionSort")
  @Order(6)
  @DisplayName("Test list include multiple null elements...")
  @ParameterizedTest
  @MethodSource("gary.selfPractice.algorithm.provider.TestDataProvider#includeNullElementsData")
  void testDataWithNullElements(List<Integer> testData) {
    List<Integer> sortedData = insertionSort.sorting(testData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals("[1, 2, 3, 10, null, null, null]", sortedData.toString());
  }

  @Test
  @Order(7)
  @Tag("InsertionSort")
  @DisplayName("Test list with random 1000 data...")
  void testDataWithRandomData() {
    final int size = 1000;
    List<Integer> orderedList = new ArrayList<>();
    List<Integer> unSortedData = new ArrayList<>();
    Random randomNum = new Random(1);
    for (int i = 0; i < size; i++) orderedList.add(i);
    for (int i = size; i > 0; i--) unSortedData.add(orderedList.remove(randomNum.nextInt(i)));
    for (int i = 0; i < size; i++) orderedList.add(i);

    List<Integer> sortedData = insertionSort.sorting(unSortedData);
    System.out.println(sortedData.toString());
    Assertions.assertEquals(sortedData.toString(), orderedList.toString());
  }
}
