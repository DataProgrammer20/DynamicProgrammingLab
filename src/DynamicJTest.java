/*
  * Author: William Kingsley
  * Date: 4/20/2018
  * Overview: This JUnit test contains various test conditions
  * for examining the calculateReturn method belonging to the
  * DynamicChangeMaking.java class.
  * ----------------------------------------------------------
  * Note: The array returned by the calculateReturn method is
  * sorted in descending order. As a result, all test cases
  * utilize arrays that are sorted in descending order.
  * ----------------------------------------------------------
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class DynamicJTest {
    @Test
    void emptyCoinArrayError() {
        int array[] = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {DynamicChangeMaking.calculateReturn(array, 9);});
        assertEquals("Array of size zero is not allowed", exception.getMessage());
    }
    @Test
    void negativeValueError() {
        int array[] = {1, 5, 10, 25};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {DynamicChangeMaking.calculateReturn(array, -1);});
        assertEquals("Value cannot be negative", exception.getMessage());
    }
    @Test
    void zeroValueResult() {
        int[] array = {1, 5, 10, 25};
        int resultArray[] = {0};
        assertArrayEquals(resultArray, DynamicChangeMaking.calculateReturn(array, 0));
    }
    @Test
    void expectedValueResult() {
        int array[] = {1, 5, 10, 25};
        int resultArray[] = {25, 25, 25, 10, 10};
        assertArrayEquals(resultArray, DynamicChangeMaking.calculateReturn(array, 95));
    }
}